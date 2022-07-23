package de.terminatorng.nastyores.ore

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.block.OreBlock
import net.minecraft.entity.Entity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.structure.rule.BlockMatchRuleTest
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraft.world.gen.YOffset


object IdlikeabiteOre: IInventoryTickableNastyOre {

    override fun oreFactory(settings: FabricBlockSettings) = object: OreBlock(settings) {
        override fun onBreak(world: World?, pos: BlockPos?, state: BlockState?, player: PlayerEntity?) {
            super.onBreak(world, pos, state, player)
            world ?: return
            player ?: return

            if (!world.isClient)
                player.hungerManager.addExhaustion(world.random.nextFloat() * 40.0f)
        }
    }

    override fun inventoryTick(stack: ItemStack?, world: World?, entity: Entity?, slot: Int, selected: Boolean) {
        world ?: return
        entity ?: return

        if (!world.isClient && world.random.nextInt(200) == 0)
            if (entity is PlayerEntity)
                entity.hungerManager.addExhaustion(1.0f)
    }

    override fun genMin(): YOffset = YOffset.fixed(64)
    override fun genMax(): YOffset = YOffset.fixed(128)
    override fun ruleTest() = BlockMatchRuleTest(Blocks.DIRT)

    // fun harvestLevelRequired(isIngotBlock: Boolean): Int {
    //     return 1
    // }

    // fun toolRequired(isIngotBlock: Boolean): String? {
    //     return "shovel"
    // }
}