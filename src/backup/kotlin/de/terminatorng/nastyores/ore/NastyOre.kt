package de.terminatorng.nastyores.ore

import de.terminatorng.nastyores.IRegistrable
import de.terminatorng.nastyores.datagen.ModDatagen
import de.terminatorng.nastyores.init.ModBlocks
import de.terminatorng.nastyores.init.ModItems
import de.terminatorng.nastyores.world.OreGen
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.ModelIds
import net.minecraft.data.server.RecipeProvider
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.tag.BlockTags
import net.minecraft.tag.TagKey
import java.util.function.Consumer

class NastyOre(override val name: String, val settings: INastyOreSettings): IRegistrable {

    fun oreBlockName() = "${name}_ore"
    fun blockName() = "${name}_block"
    fun itemName() = if (settings.itemHasIngotName()) "${name}_ingot" else name


    val oreBlock = settings.oreItemFactory(oreBlockItemSettings(), settings.oreFactory(oreBlockSettings()))
    val item: Item?
    val block: BlockItem?

    init {
        item = if (settings.hasItem()) settings.itemFactory(itemSettings()) else null

        block = if (settings.hasBlock()) settings.blockItemFactory(blockItemSettings(), settings.blockFactory(blockSettings())) else null
    }

    override fun register() {
        ModBlocks.registerBlockItem(oreBlockName(), oreBlock)

        if (item != null) ModItems.registerItem(itemName(), item)
        if (block != null) ModBlocks.registerBlockItem(blockName(), block)

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
        settings.genOreModel(oreBlock.block, generator)

        if (block != null) settings.genBlockModel(block.block, generator)
    }

    fun generateItemModels(generator: ItemModelGenerator) {
        generator.register(oreBlock, ModDatagen.createParentModel(ModelIds.getBlockModelId(oreBlock.block)))
        if (block != null) generator.register(block, ModDatagen.createParentModel(ModelIds.getBlockModelId(block.block)))
        if (item != null) settings.genItemModel(item, generator)
    }

    fun generateRecipes(exporter: Consumer<RecipeJsonProvider>?) {
        if (item != null && !settings.dropsItemDirectly())
            FabricRecipeProvider.offerSmelting(exporter, listOf(oreBlock.block), item, 0.7f, 200, "iron_ingot")

        if (block != null && item != null)
            FabricRecipeProvider.offerReversibleCompactingRecipes(exporter, item, block)
    }

    fun generateBlockLootTables(provider: FabricBlockLootTableProvider) {
        provider.addDrop(oreBlock.block, settings.drops(oreBlock.block, item))

        if (block != null) provider.addDrop(block.block, FabricBlockLootTableProvider.drops(block.block))
    }

    fun generateBlockTags(getter: (TagKey<Block>) -> FabricTagProvider<Block>.FabricTagBuilder<Block>) {
        getter(settings.levelNeeded()).add(oreBlock.block)
        getter(settings.toolNeeded()).add(oreBlock.block)

        if (block != null) {
            getter(BlockTags.NEEDS_STONE_TOOL).add(block.block)
            getter(BlockTags.PICKAXE_MINEABLE).add(block.block)
        }
    }
}