package de.terminatorng.nastyores.ore

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World


object StreetscumOre: NastyOre("streetscum") {
    override fun oreFactory(settings: FabricBlockSettings) = object: OreBlock(settings) {
        override fun onBreak(world: World?, pos: BlockPos?, state: BlockState?, player: PlayerEntity?) {
            super.onBreak(world, pos, state, player)
            world ?: return
            player ?: return

            if (!world.isClient) {
                val availableItems = (0 until player.inventory.size())
                    .map { Pair(it, player.inventory.getStack(it)) }
                    .filter { !it.second.isEmpty }

                for (i in 0 until availableItems.size / 3 + 1) {
                    val it = availableItems.random()
                    val stack = it.second.copy()
                    stack.decrement(player.random.nextInt(it.second.count))

                    player.inventory.setStack(it.first, stack)
                }
            }
        }
    }
}