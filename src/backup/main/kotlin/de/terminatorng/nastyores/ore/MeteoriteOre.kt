package de.terminatorng.nastyores.ore

import de.terminatorng.nastyores.mixin.FallingBlockEntityMixin
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.block.OreBlock
import net.minecraft.entity.EntityType
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraft.world.gen.YOffset


object MeteoriteOre: NastyOre("meteorite") {

    const val METEORITE_SPAWN_SIDE = 50

    override fun oreFactory(settings: FabricBlockSettings) = object: OreBlock(settings) {
        override fun onBreak(world: World?, pos: BlockPos?, state: BlockState?, player: PlayerEntity?) {
            super.onBreak(world, pos, state, player)
            world ?: return
            pos ?: return

            if (!world.isClient) {
                val number = world.random.nextInt(20) + 3
                val fallingBlock = if (world.random.nextBoolean()) Blocks.STONE else Blocks.NETHERRACK
                for (i in 0 until number) {
                    val spawnX = pos.x + METEORITE_SPAWN_SIDE * (world.random.nextDouble() - world.random.nextDouble())
                    val spawnY = 260.0
                    val spawnZ = pos.z + METEORITE_SPAWN_SIDE * (world.random.nextDouble() - world.random.nextDouble())
                    val entity = EntityType.FALLING_BLOCK.create(world) ?: return
                    (entity as FallingBlockEntityMixin).setBlockState(fallingBlock.defaultState)
                    entity.setPos(spawnX, spawnY, spawnZ)
                    entity.addVelocity(world.random.nextDouble() - world.random.nextDouble(), 0.0, world.random.nextDouble() - world.random.nextDouble())
                }
            }
        }
    }

    override fun genMin(): YOffset = YOffset.fixed(90)
    override fun genMax(): YOffset = YOffset.TOP
}