package de.terminatorng.nastyores.ore

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.entity.Entity
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World


object KilliumOre {
    // trigger achievement
    fun kill(entity: Entity?) {
        entity!!

        if (entity.world.isClient) return

        entity.damage(KilliumDamageSource, Float.MAX_VALUE)
    }

    private object KilliumDamageSource: DamageSource("nastyores.killium")
}