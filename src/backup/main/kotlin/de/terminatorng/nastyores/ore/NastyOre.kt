package de.terminatorng.nastyores.ore

import de.terminatorng.nastyores.IRegistrable
import de.terminatorng.nastyores.datagen.ModDatagen
import de.terminatorng.nastyores.init.ModBlocks
import de.terminatorng.nastyores.init.ModItems
import de.terminatorng.nastyores.util.ArmorInfo
import de.terminatorng.nastyores.util.NastyOresArmor
import de.terminatorng.nastyores.util.NastyOresTools
import de.terminatorng.nastyores.util.ToolInfo
import de.terminatorng.nastyores.world.IOreGenSettings
import de.terminatorng.nastyores.world.OreGen
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.block.OreBlock
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.ModelIds
import net.minecraft.data.client.Models
import net.minecraft.data.server.BlockLootTableGenerator
import net.minecraft.data.server.RecipeProvider
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.loot.LootTable
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.structure.rule.RuleTest
import net.minecraft.tag.BlockTags
import net.minecraft.tag.TagKey
import net.minecraft.world.gen.YOffset
import net.minecraft.world.gen.feature.OreConfiguredFeatures
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier
import java.util.function.Consumer
import java.util.function.Predicate

abstract class NastyOre(val name: String): IRegistrable, IOreGenSettings {

    private val oreBlockSettings: FabricBlockSettings = FabricBlockSettings.of(Material.STONE)
        .strength(hardness(), resistance())
        .sounds(soundType())
        .also { if (requiresTool()) it.requiresTool() }

    private val blockItemSettings: FabricItemSettings = ModItems.createDefaultSettings()

    private val itemSettings: FabricItemSettings = ModItems.createDefaultSettings()
        .maxCount(itemStackSize())

    private val blockSettings: FabricBlockSettings = FabricBlockSettings.of(Material.METAL)
        .strength(hardness() * 2, resistance() + 1)
        .sounds(soundType())
        .also { if (requiresTool()) it.requiresTool() }


    val oreBlock = oreItemFactory(blockItemSettings, oreFactory(oreBlockSettings))
    val item: Item?
    val block: BlockItem?
    val armor: NastyOresArmor?
    val tools: NastyOresTools?


    init {
        item = if (hasItem()) itemFactory(itemSettings) else null
        block = if (hasBlock() && item != null) blockItemFactory(blockItemSettings, blockFactory(blockSettings)) else null
        armor = if (hasArmor() && item != null) NastyOresArmor(name, item, armorInfo(), itemSettings) else null
        tools = if (hasTools() && item != null) NastyOresTools(name, item, toolInfo(), itemSettings) else null
    }

    override fun register() {
        ModBlocks.registerBlockItem("${name}_ore", oreBlock)

        if (item != null) ModItems.registerItem(if (itemHasIngotName()) "${name}_ingot" else name, item)
        if (block != null) ModBlocks.registerBlockItem("${name}_block", block)
        armor?.register()
        tools?.register()

        OreGen.registerOreGen(name, oreBlock.block.defaultState, this)
    }


    fun generateBlockModels(generator: BlockStateModelGenerator) {
        genOreModel(generator)

        if (block != null) genBlockModel(generator)
    }

    fun generateItemModels(generator: ItemModelGenerator) {
        generator.register(oreBlock, ModDatagen.createParentModel(ModelIds.getBlockModelId(oreBlock.block)))
        if (block != null) generator.register(block, ModDatagen.createParentModel(ModelIds.getBlockModelId(block.block)))
        if (item != null) genItemModel(generator)
        armor?.generateItemModels(generator)
        tools?.generateItemModels(generator)
    }

    fun generateRecipes(exporter: Consumer<RecipeJsonProvider>?) {
        if (item != null && !dropsItemDirectly()) {
            FabricRecipeProvider.offerSmelting(exporter, listOf(oreBlock.block), item, 0.7f, 200, name)
            FabricRecipeProvider.offerBlasting(exporter, listOf(oreBlock.block), item, 0.7f, 100, name)
        }

        if (block != null && item != null)
            FabricRecipeProvider.offerReversibleCompactingRecipes(exporter, item, block)

        armor?.generateRecipes(exporter)
        tools?.generateRecipes(exporter)
    }

    fun generateBlockLootTables(provider: FabricBlockLootTableProvider) {
        provider.addDrop(oreBlock.block, drops())

        if (block != null) provider.addDrop(block.block, FabricBlockLootTableProvider.drops(block.block))
    }

    fun generateBlockTags(getter: (TagKey<Block>) -> FabricTagProvider<Block>.FabricTagBuilder<Block>) {
        getter(levelNeeded()).add(oreBlock.block)
        getter(toolNeeded()).add(oreBlock.block)

        if (block != null) {
            getter(BlockTags.NEEDS_STONE_TOOL).add(block.block)
            getter(BlockTags.PICKAXE_MINEABLE).add(block.block)
        }
    }


    open fun hasItem(): Boolean = false
    open fun hasBlock(): Boolean = false
    open fun hasTools(): Boolean = false
    open fun hasArmor(): Boolean = false
    open fun dropsItemDirectly(): Boolean = false
    open fun itemStackSize(): Int = 64
    // open fun smeltingXP(): Float = 0.5F
    // open fun lightLevel(): Int = 0
    // fun canTick(): Boolean = false
    open fun hardness(): Float = 3.0F
    open fun resistance(): Float = 5.0F
    open fun requiresTool(): Boolean = true
    open fun soundType(): BlockSoundGroup = BlockSoundGroup.STONE
    open fun drops(): LootTable.Builder =
        if (dropsItemDirectly() && item != null)
            BlockLootTableGenerator.oreDrops(oreBlock.block, item)
        else
            BlockLootTableGenerator.drops(oreBlock.block)

    open fun itemHasIngotName(): Boolean = !dropsItemDirectly()
    open fun levelNeeded(): TagKey<Block> = BlockTags.NEEDS_IRON_TOOL
    open fun toolNeeded(): TagKey<Block> = BlockTags.PICKAXE_MINEABLE
    open fun armorInfo(): ArmorInfo = throw UnsupportedOperationException()
    open fun toolInfo(): ToolInfo = throw UnsupportedOperationException()

    open fun oreFactory(settings: FabricBlockSettings) = OreBlock(settings)
    open fun oreItemFactory(settings: FabricItemSettings, block: Block) = BlockItem(block, settings)
    open fun itemFactory(settings: FabricItemSettings) = Item(settings)
    open fun blockFactory(settings: FabricBlockSettings) = Block(settings)
    open fun blockItemFactory(settings: FabricItemSettings, block: Block) = BlockItem(block, settings)

    open fun genOreModel(generator: BlockStateModelGenerator): Unit = generator.registerSimpleCubeAll(oreBlock.block)
    open fun genBlockModel(generator: BlockStateModelGenerator): Unit = generator.registerSimpleCubeAll(block!!.block)
    open fun genItemModel(generator: ItemModelGenerator): Unit = generator.register(item, Models.GENERATED)

    override fun veinSize(): Int = 8
    override fun countPlacement(): CountPlacementModifier = CountPlacementModifier.of(veinsPerChunk())
    override fun heightPlacement(): HeightRangePlacementModifier = HeightRangePlacementModifier.uniform(genMin(), genMax())
    override fun ruleTest(): RuleTest = OreConfiguredFeatures.STONE_ORE_REPLACEABLES
    override fun selectedBiomes(): Predicate<BiomeSelectionContext> = BiomeSelectors.foundInOverworld()

    open fun veinsPerChunk(): Int = 64
    open fun genMin(): YOffset = YOffset.getBottom()
    open fun genMax(): YOffset = YOffset.fixed(64)
}