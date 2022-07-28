package de.terminatorng.nastyores.ore

import de.terminatorng.nastyores.MOD_LOGGER
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.math.BlockPos

import net.minecraft.world.World




object BreakiumOre: NastyOre("breakium") {

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
            world ?: return
            stack ?: return

            if (stack.isDamageable)
                if (!world.isClient) {
                    MOD_LOGGER.info("Actual damager: ${stack.damage}")
                    stack.damage(stack.maxDamage - stack.damage, player) {
                        MOD_LOGGER.info("Thats a lot of damage")
                        it?.sendToolBreakStatus(it.activeHand)
                        it?.setStackInHand(it.activeHand, Items.AIR.defaultStack)
                    }
                }
        }
    }
}