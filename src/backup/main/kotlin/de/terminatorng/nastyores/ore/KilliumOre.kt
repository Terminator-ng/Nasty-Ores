package de.terminatorng.nastyores.ore

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.entity.Entity
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World


object KilliumOre: InventoryTickableNastyOre("killium") {

    override fun oreFactory(settings: FabricBlockSettings) = object: OreBlock(settings) {
        override fun onBreak(world: World?, pos: BlockPos?, state: BlockState?, player: PlayerEntity?) {
            super.onBreak(world, pos, state, player)
            world ?: return
            player ?: return

            if (world.random.nextInt(5) == 0) {
                kill(player)
            } else {
                //miner.triggerAchievement(BOAchievementList.minedKillium)
            }
        }
    }

    override fun inventoryTick(stack: ItemStack?, world: World?, entity: Entity?, slot: Int, selected: Boolean) {
        world ?: return
        entity ?: return

        if (world.random.nextInt(1000) == 0) {
            kill(entity)
        }
    }

    private fun kill(entity: Entity) = entity.damage(KilliumDamageSource, Float.MAX_VALUE)

    private object KilliumDamageSource: DamageSource("killium")
}