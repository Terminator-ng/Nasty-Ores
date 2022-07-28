package de.terminatorng.nastyores.block

import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.block.entity.BlockEntity
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.enchantment.Enchantments
import net.minecraft.entity.EntityType
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.util.math.BlockPos
import net.minecraft.world.GameRules
import net.minecraft.world.World

class WantariteOreBlock(settings: Settings): OreBlock(settings) {

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

        if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) > 0) return

        if (world.isClient) return

        if (!world.gameRules.getBoolean(GameRules.DO_MOB_SPAWNING)) return

        val pig = EntityType.PIG.create(world) ?: return
        pig.refreshPositionAfterTeleport(
            pos.x + 0.5,
            pos.y + 0.5,
            pos.z + 0.5)
        pig.saddle(null)
        world.spawnEntity(pig)
        pig.playAmbientSound()
    }

}