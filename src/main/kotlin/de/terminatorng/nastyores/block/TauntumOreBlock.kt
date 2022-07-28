package de.terminatorng.nastyores.block

import de.terminatorng.nastyores.MOD_LOGGER
import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.entity.SpawnGroup
import net.minecraft.entity.mob.MobEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.random.Random
import net.minecraft.util.registry.Registry
import net.minecraft.world.World
import net.minecraft.world.biome.SpawnSettings
import net.minecraft.world.gen.feature.DefaultBiomeFeatures

class TauntumOreBlock(settings: Settings): TickingOreBlock(settings) {

    private var mobSounds: List<SoundEvent>? = null
    private var caveMobSounds: List<SoundEvent>? = null

    override fun getNextTick(world: World) = world.random.nextBetween(40, 440)

    @Deprecated("Deprecated in Java")
    override fun scheduledTick(state: BlockState?, world: ServerWorld?, pos: BlockPos?, random: Random?) {
        super.scheduledTick(state, world, pos, random)
        world!!
        pos!!

        if (world.isClient) return

        playRandomSound(world, pos)
    }

    private fun getAllMobSounds(world: World) =
        mobSounds ?: Registry.ENTITY_TYPE.entrySet
            .asSequence()
            .map { it.value.create(world) }
            .filterIsInstance<MobEntity>()
            .map {
                val sound = it.ambientSound
                it.discard()
                sound
            }
            .filterNotNull()
            .toList()
            .also { mobSounds = it }

    private fun getCaveMobSounds(world: World) =
        caveMobSounds ?: SpawnSettings.Builder()
            .also { DefaultBiomeFeatures.addBatsAndMonsters(it) }
            .build()
            .getSpawnEntries(SpawnGroup.MONSTER)
            .entries
            .map { it.type }
            .asSequence()
            .map { it.create(world) }
            .filterIsInstance<MobEntity>()
            .map {
                val sound = it.ambientSound
                it.discard()
                sound
            }
            .filterNotNull()
            .plus(SoundEvents.ENTITY_CREEPER_PRIMED)
            .toList()
            .also { caveMobSounds = it }

    private fun playRandomSound(world: World, pos: BlockPos) {
        val sound = getCaveMobSounds(world).random()
        world.playSound(null, pos, sound, SoundCategory.MASTER, 3.0F, 1.0F)
    }

}