package de.terminatorng.nastyores.block

import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.block.OreBlock
import net.minecraft.block.entity.BlockEntity
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.enchantment.Enchantments
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.random.Random
import net.minecraft.world.World
import net.minecraft.world.explosion.Explosion

class ExplodemiteOreBlock(settings: Settings): OreBlock(settings) {

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

        if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) > 0) return

        if (world.random.nextInt(4) == 0) createExplosion(world, pos)
    }

    override fun hasRandomTicks(state: BlockState?) = true

    @Deprecated("Deprecated in Java")
    override fun randomTick(state: BlockState?, world: ServerWorld?, pos: BlockPos?, random: Random?) {
        super.randomTick(state, world, pos, random)

        createExplosion(world, pos)
    }

    private fun createExplosion(world: World?, pos: BlockPos?) {
        world!!
        pos!!

        if (world.isClient) return

        world.createExplosion(
            null,
            pos.x.toDouble(),
            pos.y + 1.0,
            pos.z.toDouble(),
            2.0f + world.random.nextFloat() * 3.0f,
            Explosion.DestructionType.DESTROY,
        )
        world.setBlockState(pos, Blocks.AIR.defaultState)
    }

}