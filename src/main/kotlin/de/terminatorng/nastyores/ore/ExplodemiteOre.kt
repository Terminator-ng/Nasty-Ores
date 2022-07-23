package de.terminatorng.nastyores.ore

import de.terminatorng.nastyores.MOD_LOGGER
import de.terminatorng.nastyores.util.WeightedOneIntProvider
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.block.OreBlock
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.random.Random
import net.minecraft.world.World
import net.minecraft.world.explosion.Explosion
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier


object ExplodemiteOre: INastyOreSettings {
    override fun countPlacement(): CountPlacementModifier = CountPlacementModifier.of(WeightedOneIntProvider(10))

    override fun hardness() = 8.0F
    override fun resistance() = 10.0F

    override fun oreFactory(settings: FabricBlockSettings) = object: OreBlock(settings) {
        override fun onBreak(world: World?, pos: BlockPos?, state: BlockState?, player: PlayerEntity?) {
            super.onBreak(world, pos, state, player)
            world ?: return
            pos ?: return

            if (!world.isClient) {
                if (world.random.nextInt(4) == 0) world.createExplosion(
                    null,
                    pos.x.toDouble(),
                    pos.y + 1.0,
                    pos.z.toDouble(),
                    2.0f + world.random.nextFloat() * 3.0f,
                    Explosion.DestructionType.DESTROY,
                )
            }
        }
    }

    override fun blockFactory(settings: FabricBlockSettings) = object: Block(settings) {
        override fun hasRandomTicks(state: BlockState?) = true

        @Deprecated("Deprecated in Java")
        override fun randomTick(state: BlockState?, world: ServerWorld?, pos: BlockPos?, random: Random?) {
            super.randomTick(state, world, pos, random)
            world ?: return
            pos ?: return

            MOD_LOGGER.info("Ticking Explodemite at $pos")

            createExplosion(world, pos)
        }
    }

    private fun createExplosion(world: ServerWorld, pos: BlockPos) {
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