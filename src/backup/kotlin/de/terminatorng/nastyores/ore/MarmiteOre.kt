package de.terminatorng.nastyores.ore

import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.structure.rule.BlockMatchRuleTest
import net.minecraft.tag.BlockTags
import net.minecraft.tag.TagKey
import net.minecraft.world.gen.YOffset


object MarmiteOre: INastyOreSettings {

    override fun hasItem() = true
    override fun hasBlock() = true
    override fun requiresTool() = false
    override fun toolNeeded(): TagKey<Block> = BlockTags.SHOVEL_MINEABLE

    // fun harvestLevelRequired(isIngotBlock: Boolean): Int {
    //     return 0
    // }

    // fun toolRequired(isIngotBlock: Boolean): String? {
    //     return "shovel"
    // }


    override fun genMin(): YOffset = YOffset.fixed(64)
    override fun genMax(): YOffset = YOffset.fixed(128)
    override fun ruleTest() = BlockMatchRuleTest(Blocks.CLAY)
}