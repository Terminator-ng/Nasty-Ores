package de.terminatorng.nastyores.ore

import de.terminatorng.nastyores.MOD_LOGGER
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.block.OreBlock
import net.minecraft.entity.EntityType
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTable
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.provider.number.UniformLootNumberProvider
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.MathHelper
import net.minecraft.util.math.random.Random
import net.minecraft.world.World
import net.minecraft.world.gen.YOffset


object PandaemoniumOre: NastyOre("pandaemonium") {

    private const val TICK_RATE = 1000

    override fun drops(): LootTable.Builder =
        LootTable.builder()
            .pool(LootPool.builder()
                .rolls(UniformLootNumberProvider.create(0.0F, 3.0F))
                .with(ItemEntry.builder(Blocks.NETHERRACK))
                .with(ItemEntry.builder(Items.NETHER_WART))
                .with(ItemEntry.builder(Blocks.OBSIDIAN))
                .with(ItemEntry.builder(Items.FIRE_CHARGE))
                .with(ItemEntry.builder(Items.BLAZE_ROD))
                .with(ItemEntry.builder(Items.MAGMA_CREAM)))

    private fun setBlockSafe(world: World, pos: BlockPos, blockState: BlockState) {
        if (world.getBlockState(pos).getHardness(world, pos) >= 0.0F)
            world.setBlockState(pos, blockState)
    }

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
            pos ?: return
            
            world?.createAndScheduleBlockTick(pos, this, TICK_RATE)
        }
        
        @Deprecated("Deprecated in Java")
        override fun scheduledTick(state: BlockState?, world: ServerWorld?, pos: BlockPos?, random: Random?) {
            super.scheduledTick(state, world, pos, random)
            world ?: return
            pos ?: return

            MOD_LOGGER.info("Ticking Pandaemonium at $pos")
            
            if (!world.isClient) {
                world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f)

                world.createAndScheduleBlockTick(pos, this, TICK_RATE)
            }
        }

        override fun onBreak(world: World?, pos: BlockPos?, state: BlockState?, player: PlayerEntity?) {
            super.onBreak(world, pos, state, player)
            world ?: return
            pos ?: return
            
            if (!world.isClient) {
                world.playSound(null, pos, SoundEvents.BLOCK_ANVIL_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f)

                val pigmen: Int = world.random.nextInt(4)
                for (i in 0 until pigmen) {
                    val entityPigZombie = EntityType.ZOMBIFIED_PIGLIN.create(world)!!
                    entityPigZombie.refreshPositionAfterTeleport(
                        pos.x + 0.5,
                        pos.y + 0.5,
                        pos.z + 0.5)
                    world.spawnEntity(entityPigZombie)
                }

                val veins: Int = world.random.nextInt(12) + 3
                for (i in 0 until veins) {
                    val xP = world.random.nextDouble() - world.random.nextDouble()
                    val yP = world.random.nextDouble() - world.random.nextDouble()
                    val zP = world.random.nextDouble() - world.random.nextDouble()
                    val length: Int = world.random.nextInt(10) + 3
                    for (iteration in 0 until length) {
                        val curX = pos.x + 0.5 + xP * iteration
                        val curY = pos.y + 0.5 + yP * iteration
                        val curZ = pos.z + 0.5 + zP * iteration

                        setBlockSafe(world, BlockPos(curX, curY, curZ), Blocks.NETHERRACK.defaultState)
                    }
                }

                val fireRange: Int = world.random.nextInt(8)
                val fireChance: Float = world.random.nextFloat() * world.random.nextFloat()
                for (xP in -fireRange..fireRange)
                    for (yP in -fireRange..fireRange)
                        for (zP in -fireRange..fireRange)
                            if (world.random.nextFloat() < fireChance)
                                if (Blocks.FIRE.canPlaceAt(state, world, pos))
                                    setBlockSafe(
                                        world,
                                        BlockPos(pos.x + xP, pos.y + yP, pos.z + zP),
                                        Blocks.FIRE.defaultState)
            }
        }
    }

    override fun genMin(): YOffset = YOffset.getBottom()
    override fun genMax(): YOffset = YOffset.fixed(10)
}