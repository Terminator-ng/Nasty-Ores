package de.terminatorng.nastyores.mixin

import net.minecraft.entity.mob.MobEntity
import net.minecraft.sound.SoundEvent
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.gen.Invoker

@Mixin(MobEntity::class)
interface MobEntityMixin {
    @Invoker("getAmbientSound")
    fun invokeGetAmbientSound(): SoundEvent?
}