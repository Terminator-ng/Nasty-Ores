package de.terminatorng.nastyores.block

import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.block.entity.BlockEntity
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.enchantment.Enchantments
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.util.math.BlockPos
import net.minecraft.util.registry.Registry
import net.minecraft.world.World

class MisleadiumOreBlock(settings: Settings): OreBlock(settings) {

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
        pos!!
        player!!

        if (world.isClient) return
        if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) > 0) return

        val item = Registry.ITEM.get(Registry.ITEM.keys.random())?.defaultStack ?: return

        val fX: Int = pos.x + world.random.nextInt(SIDE_RANGE) - world.random.nextInt(SIDE_RANGE)
        val fY: Int = world.random.nextBetween(10, 110)
        val fZ: Int = pos.z + world.random.nextInt(SIDE_RANGE) - world.random.nextInt(SIDE_RANGE)

        player.sendMessage(
            Text.translatable(
            "nastyores.misleadium.baseMessage",
            item,
            fX.toString(),
            fY.toString(),
            fZ.toString()
        ))
    }

    companion object {
        const val SIDE_RANGE = 500
    }

}