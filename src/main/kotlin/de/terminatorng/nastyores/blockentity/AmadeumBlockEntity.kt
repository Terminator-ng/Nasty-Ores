package de.terminatorng.nastyores.blockentity

import de.terminatorng.nastyores.init.ModBlockEntities
import de.terminatorng.nastyores.ore.AmadeumOre
import net.minecraft.block.BlockState
import net.minecraft.block.NoteBlock
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityTicker
import net.minecraft.block.enums.Instrument
import net.minecraft.item.Items
import net.minecraft.sound.SoundCategory
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import kotlin.math.pow

class AmadeumBlockEntity(pos: BlockPos?, state: BlockState?) : BlockEntity(ModBlockEntities.AMADEUM_BLOCK_ENTITY, pos, state) {

    companion object {
        fun tick(world: World?, pos: BlockPos?, state: BlockState?, blockEntity: AmadeumBlockEntity?) {
            world ?: return
            pos ?: return

            val sound = AmadeumOre.getSound(world)
            world.playSound(null, pos, sound.second, SoundCategory.MASTER, AmadeumOre.SOUND_VOLUME, sound.first)
        }
    }
}