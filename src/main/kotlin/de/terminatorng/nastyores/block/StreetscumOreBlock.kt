package de.terminatorng.nastyores.block

import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.block.entity.BlockEntity
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.enchantment.Enchantments
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class StreetscumOreBlock(settings: Settings): OreBlock(settings) {

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
        player!!

        if (world.isClient) return
        if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) > 0) return

        val availableItems = (0 until player.inventory.size())
            .map { Pair(it, player.inventory.getStack(it)) }
            .filter { !it.second.isEmpty }

        for (i in 0 until availableItems.size / 3 + 1) {
            val it = availableItems.random()
            val copy = it.second.copy()
            copy.decrement(player.random.nextInt(it.second.count))

            player.inventory.setStack(it.first, copy)
        }
    }

}