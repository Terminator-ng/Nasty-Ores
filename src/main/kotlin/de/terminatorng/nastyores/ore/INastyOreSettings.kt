package de.terminatorng.nastyores.ore

import de.terminatorng.nastyores.world.IOreGenSettings
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.OreBlock
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.Models
import net.minecraft.data.server.BlockLootTableGenerator
import net.minecraft.enchantment.Enchantments
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTable
import net.minecraft.loot.LootTables
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.function.ApplyBonusLootFunction
import net.minecraft.loot.function.ExplosionDecayLootFunction
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.structure.rule.RuleTest
import net.minecraft.tag.BlockTags
import net.minecraft.tag.TagKey
import net.minecraft.world.explosion.Explosion
import net.minecraft.world.gen.YOffset
import net.minecraft.world.gen.feature.OreConfiguredFeatures
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier
import java.util.function.Predicate

interface INastyOreSettings: IOreGenSettings {

    fun hasItem(): Boolean = false
    fun hasBlock(): Boolean = false
    fun hasTools(): Boolean = false
    fun hasArmor(): Boolean = false
    fun dropsItemDirectly(): Boolean = false
    fun itemStackSize(): Int = 64
    // open fun smeltingXP(): Float = 0.5F
    // open fun lightLevel(): Int = 0
    // fun canTick(): Boolean = false
    fun hardness(): Float = 3.0F
    fun resistance(): Float = 5.0F
    fun requiresTool(): Boolean = true
    fun soundType(): BlockSoundGroup = BlockSoundGroup.STONE
    fun drops(ore: Block, item: Item?): LootTable.Builder =
        if (dropsItemDirectly() && item != null)
            BlockLootTableGenerator.oreDrops(ore, item)
        else
            BlockLootTableGenerator.drops(ore)

    fun itemHasIngotName(): Boolean = !dropsItemDirectly()

    fun levelNeeded(): TagKey<Block> = BlockTags.NEEDS_IRON_TOOL

    fun toolNeeded(): TagKey<Block> = BlockTags.PICKAXE_MINEABLE

    fun oreFactory(settings: FabricBlockSettings) = OreBlock(settings)
    fun oreItemFactory(settings: FabricItemSettings, block: Block) = BlockItem(block, settings)
    fun itemFactory(settings: FabricItemSettings) = Item(settings)
    fun blockFactory(settings: FabricBlockSettings) = Block(settings)
    fun blockItemFactory(settings: FabricItemSettings, block: Block) = BlockItem(block, settings)

    fun genOreModel(oreBlock: Block, generator: BlockStateModelGenerator): Unit = generator.registerSimpleCubeAll(oreBlock)
    fun genBlockModel(block: Block, generator: BlockStateModelGenerator): Unit = generator.registerSimpleCubeAll(block)
    fun genItemModel(item: Item, generator: ItemModelGenerator): Unit = generator.register(item, Models.GENERATED)

    override fun veinSize(): Int = 8
    override fun countPlacement(): CountPlacementModifier = CountPlacementModifier.of(veinsPerChunk())
    override fun heightPlacement(): HeightRangePlacementModifier = HeightRangePlacementModifier.uniform(genMin(), genMax())
    override fun ruleTest(): RuleTest = OreConfiguredFeatures.STONE_ORE_REPLACEABLES
    override fun selectedBiomes(): Predicate<BiomeSelectionContext> = BiomeSelectors.foundInOverworld()

    fun veinsPerChunk(): Int = 64
    fun genMin(): YOffset = YOffset.getBottom()
    fun genMax(): YOffset = YOffset.fixed(64)
}