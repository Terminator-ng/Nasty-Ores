package de.terminatorng.nastyores.ore

import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType
import net.minecraft.util.math.Vec3d
import net.minecraft.world.World


object SmiteOre {

    fun spawnLightning(world: World?, entity: Entity?) {
        world!!
        entity!!

        if (world.isClient) return

        val lightningEntity = EntityType.LIGHTNING_BOLT.create(world)!!
        lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(entity.blockPos))
        world.spawnEntity(lightningEntity)
    }
}