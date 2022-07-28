package de.terminatorng.nastyores.ore

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.EntityType
import net.minecraft.entity.ItemEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.server.world.ServerWorld
import net.minecraft.stat.Stats
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.MathHelper
import net.minecraft.world.GameRules
import net.minecraft.world.World
import java.util.function.Supplier

object GhostiumOre: INastyOreSettings {

    override fun oreFactory(settings: FabricBlockSettings) = object: OreBlock(settings) {
        override fun afterBreak(
            world: World?,
            player: PlayerEntity?,
            pos: BlockPos?,
            state: BlockState?,
            blockEntity: BlockEntity?,
            stack: ItemStack?
        ) {
            super.afterBreak(world, player, pos, state, blockEntity, stack)
            pos ?: return
            state ?: return

            player?.incrementStat(Stats.MINED.getOrCreateStat(this))
            player?.addExhaustion(0.005f)

            if (world is ServerWorld)
                if (world.getGameRules().getBoolean(GameRules.DO_TILE_DROPS)) {
                    getDroppedStacks(state, world as ServerWorld?, pos, blockEntity, player, stack).forEach {
                        val f = EntityType.ITEM.height / 2.0F
                        val d = pos.x + 0.5F + MathHelper.nextDouble(world.random, -0.25, 0.25)
                        val e = pos.y + 0.5F + MathHelper.nextDouble(world.random, -0.25, 0.25) - f
                        val g = pos.z + 0.5F + MathHelper.nextDouble(world.random, -0.25, 0.25)
                        val itemEntity = ItemEntity(world, d, e, g, it)
                        itemEntity.setPickupDelayInfinite()
                        world.spawnEntity(itemEntity)
                    }
                    state.onStacksDropped(world as ServerWorld?, pos, stack, true)
                }
        }
    }

}