package de.terminatorng.nastyores.ore

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.block.ShapeContext
import net.minecraft.entity.ai.pathing.NavigationType
import net.minecraft.util.math.BlockPos
import net.minecraft.util.shape.VoxelShape
import net.minecraft.util.shape.VoxelShapes
import net.minecraft.world.BlockView

object ShiftiumOre: NastyOre("shiftium") {

    override fun oreFactory(settings: FabricBlockSettings) = object: OreBlock(settings) {
        @Deprecated("Deprecated in Java", ReplaceWith("VoxelShapes.empty()", "net.minecraft.util.shape.VoxelShapes"))
        override fun getOutlineShape(
            state: BlockState?,
            world: BlockView?,
            pos: BlockPos?,
            context: ShapeContext?
        ): VoxelShape = VoxelShapes.empty()

        @Deprecated("Deprecated in Java", ReplaceWith("false"))
        override fun canPathfindThrough(
            state: BlockState?,
            world: BlockView?,
            pos: BlockPos?,
            type: NavigationType?
        ) = false

        @Deprecated("Deprecated in Java", ReplaceWith("VoxelShapes.fullCube()", "net.minecraft.util.shape.VoxelShapes"))
        override fun getCollisionShape(
            state: BlockState?,
            world: BlockView?,
            pos: BlockPos?,
            context: ShapeContext?
        ): VoxelShape = VoxelShapes.fullCube()
    }
}