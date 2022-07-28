package de.terminatorng.nastyores.ore

import net.minecraft.block.Block
import net.minecraft.block.enums.Instrument
import net.minecraft.entity.Entity
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvent
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import kotlin.math.pow

object AmadeumOre {

    private const val SOUND_VOLUME = 5.0F
    const val TICK_RATE = 20

    private fun getSound(world: World): Pair<Float, SoundEvent> {
        val i = world.random.nextInt(15)
        val f = 2.0.pow((i - 12).toDouble() / 12.0 ).toFloat()

        return Pair(f, Instrument.values().random().sound)
    }

    fun playBlockSound(world: World?, pos: BlockPos?, block: Block) {
        world!!
        pos!!

        if (world.isClient) return

        val sound = getSound(world)
        world.playSound(null, pos, sound.second, SoundCategory.MASTER, SOUND_VOLUME, sound.first)
    }

    fun playItemSound(world: World?, entity: Entity?) {
        world!!
        entity!!

        if (world.isClient) return

        if (world.random.nextInt(20) != 0) return

        val sound = getSound(world)
        world.playSoundFromEntity(null, entity, sound.second, SoundCategory.MASTER, SOUND_VOLUME, sound.first)
    }
}