package de.terminatorng.nastyores.ore

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.block.OreBlock
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.structure.rule.BlockMatchRuleTest
import net.minecraft.tag.BlockTags
import net.minecraft.tag.TagKey
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraft.world.gen.YOffset

object AppetiteOre: INastyOreSettings {

    override fun requiresTool() = false
    override fun hardness() = 0.5F
    override fun soundType(): BlockSoundGroup = BlockSoundGroup.SAND

    override fun toolNeeded(): TagKey<Block> = BlockTags.SHOVEL_MINEABLE

    override fun oreFactory(settings: FabricBlockSettings) = object: OreBlock(settings) {
        override fun onBreak(world: World?, pos: BlockPos?, state: BlockState?, player: PlayerEntity?) {
            super.onBreak(world, pos, state, player)

            world?: return

            if (!world.isClient) {
                val hungerManager = player?.hungerManager?: return
                hungerManager.foodLevel += 4
                hungerManager.saturationLevel += 0.2F
            }
        }
    }

    override fun genMin(): YOffset = YOffset.fixed(64)
    override fun genMax(): YOffset = YOffset.fixed(128)
    override fun ruleTest() = BlockMatchRuleTest(Blocks.SAND)
}