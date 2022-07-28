package de.terminatorng.nastyores.block

import de.terminatorng.nastyores.ore.AmadeumOre
import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.random.Random
import net.minecraft.world.World

class AmadeumOreBlock(settings: Settings): TickingOreBlock(settings) {

    override fun getNextTick(world: World) = AmadeumOre.TICK_RATE

    @Deprecated("Deprecated in Java")
    override fun scheduledTick(state: BlockState?, world: ServerWorld?, pos: BlockPos?, random: Random?) {
        super.scheduledTick(state, world, pos, random)

        AmadeumOre.playBlockSound(world, pos, this)
    }
}