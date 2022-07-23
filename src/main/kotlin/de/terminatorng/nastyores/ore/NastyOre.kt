package de.terminatorng.nastyores.ore

import de.terminatorng.nastyores.IRegistrable
import de.terminatorng.nastyores.id
import de.terminatorng.nastyores.init.ModBlocks
import de.terminatorng.nastyores.init.ModItems
import de.terminatorng.nastyores.world.OreGen
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.*
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.Model
import net.minecraft.data.client.Models
import net.minecraft.data.server.BlockLootTableGenerator
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTable
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.provider.number.ConstantLootNumberProvider
import java.util.*
import java.util.function.Consumer

class NastyOre(override val name: String, val settings: INastyOreSettings): IRegistrable {

    private val oreBlockName = "${name}_ore"
    private val blockName = "${name}_block"

    val oreBlock = settings.oreItemFactory(oreBlockItemSettings(), settings.oreFactory(oreBlockSettings()))
    val item: Item?
    val block: BlockItem?

    init {
        item = if (settings.hasItem()) settings.itemFactory(itemSettings()) else null

        block = if (settings.hasBlock()) settings.blockItemFactory(blockItemSettings(), settings.blockFactory(blockSettings())) else null
    }

    override fun register() {
        ModBlocks.registerBlockItem(oreBlockName, oreBlock)

        if (item != null) ModItems.registerItem(name, item)
        if (block != null) ModBlocks.registerBlockItem(blockName, block)

        OreGen.registerOreGen(name, oreBlock.block.defaultState, settings)
    }

    private fun oreBlockSettings(): FabricBlockSettings = FabricBlockSettings.of(Material.STONE)
        .strength(settings.hardness(), settings.resistance())
        .sounds(settings.soundType())
        .also { if (settings.requiresTool()) it.requiresTool() }
    private fun oreBlockItemSettings(): FabricItemSettings = ModItems.createDefaultSettings()
    private fun itemSettings(): FabricItemSettings = ModItems.createDefaultSettings()
        .maxCount(settings.itemStackSize())
    private fun blockSettings(): FabricBlockSettings = FabricBlockSettings.of(Material.METAL)
        .strength(settings.hardness() * 2, settings.resistance() + 1)
        .sounds(settings.soundType())
        .also { if (settings.requiresTool()) it.requiresTool() }
    private fun blockItemSettings(): FabricItemSettings = ModItems.createDefaultSettings()


    fun generateBlockModels(generator: BlockStateModelGenerator) {
        generator.registerSimpleCubeAll(oreBlock.block)
        if (block != null) generator.registerSimpleCubeAll(block.block)
    }

    fun generateItemModels(generator: ItemModelGenerator) {
        generator.register(oreBlock, createParentModel(oreBlockName))
        if (block != null) generator.register(block, createParentModel(blockName))
        if (item != null) generator.register(item, Models.GENERATED)
    }

    private fun createParentModel(name: String) = Model(
        Optional.of(id(oreBlockName)),
        Optional.empty(),
    )

    fun generateRecipes(exporter: Consumer<RecipeJsonProvider>?) {
        if (block != null && item != null)
            FabricRecipeProvider.offerReversibleCompactingRecipes(exporter, item, block)
    }

    fun generateBlockLootTables(provider: FabricBlockLootTableProvider) {
        settings.drops(oreBlock.block, item)

        if (block != null) FabricBlockLootTableProvider.drops(block.block)
    }
}