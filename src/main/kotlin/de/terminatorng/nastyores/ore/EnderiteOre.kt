package de.terminatorng.nastyores.ore

import net.minecraft.entity.Entity
import net.minecraft.particle.ParticleTypes
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.sound.SoundEvents
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World


object EnderiteOre {
    private const val RADIUS = 40
    private const val RAD_DOUBLE = RADIUS * 2

    fun teleportEntity(entity: Entity?, pos: BlockPos? = null) {
        entity!!

        if (entity.world.isClient) return

        teleportTo(entity.world, entity, findRandomSpot(entity.world, pos ?: entity.blockPos))
    }

    private fun findRandomSpot(world: World, pos: BlockPos): BlockPos {
        val rX: Int = pos.x - RADIUS + world.random.nextInt(RAD_DOUBLE)
        val rZ: Int = pos.z - RADIUS + world.random.nextInt(RAD_DOUBLE)
        val rY: Int = 10 + world.random.nextInt(240)
        return BlockPos(rX, rY, rZ)
    }

    private fun teleportTo(world: World, entity: Entity, pos: BlockPos) {
        for (i in 0 until 30) {
            world.addParticle(
                ParticleTypes.PORTAL,
                pos.x.toDouble(),
                pos.y + world.random.nextDouble() * 2.0,
                pos.z.toDouble(),
                world.random.nextGaussian(),
                0.0,
                world.random.nextGaussian()
            )
        }

        if (world.isClient) return

        if (entity is ServerPlayerEntity && entity.networkHandler.getConnection().isOpen && entity.world === world && !entity.isSleeping && entity.hasVehicle()) {
            entity.requestTeleportAndDismount(pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble())
        } else {
            entity.requestTeleport(pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble())
        }
        entity.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 3.0F, 1.0F)
    }
}