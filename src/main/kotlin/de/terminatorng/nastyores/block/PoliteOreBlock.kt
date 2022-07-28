package de.terminatorng.nastyores.block

import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.block.entity.BlockEntity
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.enchantment.Enchantments
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.Text
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class PoliteOreBlock(settings: Settings): OreBlock(settings) {

    override fun afterBreak(
        world: World?,
        player: PlayerEntity?,
        pos: BlockPos?,
        state: BlockState?,
        blockEntity: BlockEntity?,
        stack: ItemStack?
    ) {
        super.afterBreak(world, player, pos, state, blockEntity, stack)
        player!!
        world!!

        if (world.isClient) return
        if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) > 0) return

        player.sendMessage(Text.translatable("nastyores.polite.mined"))
    }

}