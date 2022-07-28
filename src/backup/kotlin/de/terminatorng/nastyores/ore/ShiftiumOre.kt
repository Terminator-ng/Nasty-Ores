package de.terminatorng.nastyores.ore

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.util.math.BlockPos
import net.minecraft.util.shape.VoxelShapes
import net.minecraft.world.BlockView

object ShiftiumOre: INastyOreSettings {

    override fun oreFactory(settings: FabricBlockSettings) = object: OreBlock(settings) {
        @Deprecated("Deprecated in Java", ReplaceWith("VoxelShapes.empty()", "net.minecraft.util.shape.VoxelShapes"))
        override fun getRaycastShape(state: BlockState?, world: BlockView?, pos: BlockPos?) = VoxelShapes.empty()
    }
}