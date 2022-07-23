package de.terminatorng.nastyores.ore

import de.terminatorng.nastyores.MOD_LOGGER
import de.terminatorng.nastyores.mixin.MobEntityMixin
import de.terminatorng.nastyores.util.WeightedOneIntProvider
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.entity.mob.MobEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.random.Random
import net.minecraft.util.registry.Registry
import net.minecraft.world.World
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier


object TauntumOre: INastyOreSettings {

    private var mobSounds: List<SoundEvent>? = null

    override fun veinSize() = 3

    private fun getAllMobSounds(world: World) =
        mobSounds ?: Registry.ENTITY_TYPE.entrySet
            .asSequence()
            .map { it.value.create(world) }
            .filterIsInstance<MobEntity>()
            .map { (it as MobEntityMixin).invokeGetAmbientSound() }
            .filterNotNull()
            .plus(SoundEvents.ENTITY_CREEPER_PRIMED)
            .toList()
            .also { mobSounds = it }

    override fun countPlacement(): CountPlacementModifier = CountPlacementModifier.of(WeightedOneIntProvider(100))

    private fun getRandomDelay(world: World) = world.random.nextInt(400) + 40

    override fun oreFactory(settings: FabricBlockSettings) = object: OreBlock(settings) {

        @Deprecated("Deprecated in Java")
        override fun onBlockAdded(
            state: BlockState?,
            world: World?,
            pos: BlockPos?,
            oldState: BlockState?,
            notify: Boolean
        ) {
            super.onBlockAdded(state, world, pos, oldState, notify)
            world ?: return

            if (!world.isClient)
                world.createAndScheduleBlockTick(pos, this, getRandomDelay(world))
        }

        @Deprecated("Deprecated in Java")
        override fun scheduledTick(state: BlockState?, world: ServerWorld?, pos: BlockPos?, random: Random?) {
            super.scheduledTick(state, world, pos, random)
            world ?: return
            pos ?: return

            MOD_LOGGER.info("Ticking Tauntum at $pos")

            if (!world.isClient) {
                playRandomSound(world, pos)
                world.createAndScheduleBlockTick(pos, this, getRandomDelay(world))
            }
        }
    }

    private fun playRandomSound(world: World, pos: BlockPos) {
        val sound = getAllMobSounds(world).random()
        world.playSound(null, pos, sound, SoundCategory.MASTER, 1.0F, 1.0F)
    }
}