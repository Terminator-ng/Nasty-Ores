package de.terminatorng.nastyores.ore

import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.data.server.BlockLootTableGenerator
import net.minecraft.enchantment.Enchantments
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTable
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.function.ApplyBonusLootFunction
import net.minecraft.loot.function.SetCountLootFunction
import net.minecraft.loot.provider.number.ConstantLootNumberProvider
import net.minecraft.structure.rule.BlockMatchRuleTest
import net.minecraft.structure.rule.RuleTest
import net.minecraft.util.math.intprovider.UniformIntProvider
import net.minecraft.world.gen.YOffset
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier


object PaintitwhiteOre: INastyOreSettings {

    override fun requiresTool() = false

    // fun harvestLevelRequired(isIngotBlock: Boolean): Int {
    //     return 0
    // }

    // fun toolRequired(isIngotBlock: Boolean): String? {
    //     return "shovel"
    // }

    // fun addOreDrops(world: World?, x: Int, y: Int, z: Int, meta: Int, fortune: Int, drops: MutableList<ItemStack?>) {
    //     drops.add(ItemStack(Items.dye, 1, 15))
    // }

    override fun drops(ore: Block, item: Item?): LootTable.Builder =
        LootTable.builder()
            .pool(LootPool.builder()
                .with(BlockLootTableGenerator.applyExplosionDecay(ore, ItemEntry.builder(Items.WHITE_DYE)
                    .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE)))))

    override fun genMin(): YOffset = YOffset.fixed(32)
    override fun genMax(): YOffset = YOffset.fixed(128)
    override fun veinSize() = 8
    override fun countPlacement(): CountPlacementModifier = CountPlacementModifier.of(UniformIntProvider.create(2, 7))
    override fun ruleTest(): RuleTest = BlockMatchRuleTest(Blocks.GRAVEL)
}