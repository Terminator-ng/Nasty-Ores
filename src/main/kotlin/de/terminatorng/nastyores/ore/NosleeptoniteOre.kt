package de.terminatorng.nastyores.ore

import de.terminatorng.nastyores.MOD_LOGGER
import de.terminatorng.nastyores.util.WeightedOneIntProvider
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.random.Random

import net.minecraft.world.World
import net.minecraft.world.gen.YOffset
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier


object NosleeptoniteOre: INastyOreSettings {

    const val TICK_RATE = 1000

    override fun hasItem() = true

    override fun oreFactory(settings: FabricBlockSettings) = object: OreBlock(settings) {

        @Deprecated("Deprecated in Java")
        override fun scheduledTick(state: BlockState?, world: ServerWorld?, pos: BlockPos?, random: Random?) {
            super.scheduledTick(state, world, pos, random)
            world ?: return
            random ?: return MOD_LOGGER.warn("no block random in Nosleeptonite")
            pos ?: return

            MOD_LOGGER.info("Ticking Pandaemonium at $pos")

            if (!world.isClient) {
                if (random.nextInt(10) == 0)
                    world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F)

                world.createAndScheduleBlockTick(pos, this, TICK_RATE)
            }
        }

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
            pos ?: return

            if (!world.isClient)
                world.createAndScheduleBlockTick(pos, this, 1000)
        }

        override fun onBreak(world: World?, pos: BlockPos?, state: BlockState?, player: PlayerEntity?) {
            super.onBreak(world, pos, state, player)
            world ?: return
            pos ?: return
        }
    }



    override fun genMin(): YOffset = YOffset.fixed(5)
    override fun genMax(): YOffset = YOffset.fixed(40)
    override fun countPlacement(): CountPlacementModifier = CountPlacementModifier.of(WeightedOneIntProvider(40))
    override fun veinSize(): Int  = 1
}