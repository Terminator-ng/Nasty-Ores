package de.terminatorng.nastyores.block

import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class BreakiumOreBlock(settings: Settings): OreBlock(settings) {

    override fun afterBreak(
        world: World?,
        player: PlayerEntity?,
        pos: BlockPos?,
        state: BlockState?,
        blockEntity: BlockEntity?,
        stack: ItemStack?
    ) {
        super.afterBreak(world, player, pos, state, blockEntity, stack)
        world!!
        stack!!
        player!!

        if (world.isClient) return

        if (stack.isDamageable) {
            player.sendToolBreakStatus(player.activeHand)
            player.setStackInHand(player.activeHand, ItemStack.EMPTY)
        }
    }

}