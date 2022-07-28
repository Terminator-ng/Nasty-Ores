package de.terminatorng.nastyores.mixin

import net.minecraft.block.BlockState
import net.minecraft.entity.FallingBlockEntity
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.gen.Accessor

@Mixin(FallingBlockEntity::class)
interface FallingBlockEntityMixin {
    @Accessor("block")
    fun setBlockState(blockState: BlockState)
}