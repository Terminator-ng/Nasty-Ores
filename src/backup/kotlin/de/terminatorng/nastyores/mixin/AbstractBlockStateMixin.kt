package de.terminatorng.nastyores.mixin

import de.terminatorng.nastyores.init.ModOres
import de.terminatorng.nastyores.ore.ZombieuniteOre
import net.minecraft.block.AbstractBlock.AbstractBlockState
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable

@Mixin(AbstractBlockState::class)
interface AbstractBlockStateMixin {

    @Inject(method = ["getHardness"], at = [At("TAIL")], cancellable = true)
    fun getHardnessInject(world: World, pos: BlockPos, ci: CallbackInfoReturnable<Float>) {
        if (world.getBlockState(pos).block == ModOres.ZOMBIEUNITE_ORE.nastyOre.oreBlock.block)
            ci.returnValue = ZombieuniteOre.hardness(world, pos)
    }
}