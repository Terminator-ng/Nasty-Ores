package de.terminatorng.nastyores.block

import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.random.Random
import net.minecraft.world.World

abstract class TickingOreBlock(settings: Settings): OreBlock(settings) {

    abstract fun getNextTick(world: World): Int

    private fun scheduleTick(world: World?, pos: BlockPos?) {
        world!!

        if (!world.isClient)
            world.createAndScheduleBlockTick(pos, this, getNextTick(world))
    }

    @Deprecated("Deprecated in Java")
    override fun scheduledTick(state: BlockState?, world: ServerWorld?, pos: BlockPos?, random: Random?) {
        super.scheduledTick(state, world, pos, random)

        scheduleTick(world, pos)
    }

    @Deprecated("Deprecated in Java")
    override fun onBlockAdded(
        state: BlockState?,
        world: World?,
        pos: BlockPos?,
        oldState: BlockState?,
        notify: Boolean
    ) {
        super.onBlockAdded(state, world, pos, oldState, notify)

        scheduleTick(world, pos)
    }

}