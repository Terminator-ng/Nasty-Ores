package de.terminatorng.nastyores.block

import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.random.Random
import net.minecraft.world.World

class NosleeptoniteOreBlock(settings: Settings): TickingOreBlock(settings) {

    override fun getNextTick(world: World) = TICK_RATE

    @Deprecated("Deprecated in Java")
    override fun scheduledTick(state: BlockState?, world: ServerWorld?, pos: BlockPos?, random: Random?) {
        super.scheduledTick(state, world, pos, random)
        world!!
        random!!
        pos!!

        if (world.isClient) return

        if (random.nextInt(10) != 0) return

        world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F)
    }

    override fun onBreak(world: World?, pos: BlockPos?, state: BlockState?, player: PlayerEntity?) {
        super.onBreak(world, pos, state, player)
        world!!
        pos!!
    }

    companion object {
        private const val TICK_RATE = 1000
    }
}