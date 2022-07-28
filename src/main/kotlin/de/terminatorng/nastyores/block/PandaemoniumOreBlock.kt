package de.terminatorng.nastyores.block

import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.block.OreBlock
import net.minecraft.block.entity.BlockEntity
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.enchantment.Enchantments
import net.minecraft.entity.EntityType
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.random.Random
import net.minecraft.world.GameRules
import net.minecraft.world.World

class PandaemoniumOreBlock(settings: Settings): TickingOreBlock(settings) {

    override fun getNextTick(world: World) = TICK_RATE

    private fun setBlockSafe(world: World, pos: BlockPos, blockState: BlockState) {
        if (world.getBlockState(pos).getHardness(world, pos) >= 0.0F)
            world.setBlockState(pos, blockState)
    }

    @Deprecated("Deprecated in Java")
    override fun scheduledTick(state: BlockState?, world: ServerWorld?, pos: BlockPos?, random: Random?) {
        super.scheduledTick(state, world, pos, random)
        world!!
        pos!!

        if (world.isClient) return

        world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f)
}

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

        if (world.isClient) return
        if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) > 0) return

        world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f)

        for (i in 0 until world.random.nextBetween(3, 15)) {
            val xP = world.random.nextDouble() - world.random.nextDouble()
            val yP = world.random.nextDouble() - world.random.nextDouble()
            val zP = world.random.nextDouble() - world.random.nextDouble()

            for (iteration in 0 until world.random.nextBetween(3, 13)) {
                val curX = pos.x + 0.5 + xP * iteration
                val curY = pos.y + 0.5 + yP * iteration
                val curZ = pos.z + 0.5 + zP * iteration

                setBlockSafe(world, BlockPos(curX, curY, curZ), Blocks.NETHERRACK.defaultState)
            }
        }

        val fireRange: Int = world.random.nextInt(8)
        val fireChance: Float = world.random.nextFloat() * world.random.nextFloat()
        for (xP in -fireRange..fireRange)
            for (yP in -fireRange..fireRange)
                for (zP in -fireRange..fireRange)
                    if (world.random.nextFloat() < fireChance)
                        if (Blocks.FIRE.canPlaceAt(state, world, pos))
                            setBlockSafe(
                                world,
                                BlockPos(pos.x + xP, pos.y + yP, pos.z + zP),
                                Blocks.FIRE.defaultState
                            )

        if (!world.gameRules.getBoolean(GameRules.DO_MOB_SPAWNING)) return

        val pigmen: Int = world.random.nextInt(4)
        for (i in 0 until pigmen) {
            val entityPigZombie = EntityType.ZOMBIFIED_PIGLIN.create(world)!!
            entityPigZombie.refreshPositionAfterTeleport(
                pos.x + 0.5,
                pos.y + 0.5,
                pos.z + 0.5)
            world.spawnEntity(entityPigZombie)
        }
    }

    companion object {
        private const val TICK_RATE = 1000
    }
}