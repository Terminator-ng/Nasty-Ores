package de.terminatorng.nastyores.ore

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.block.entity.BlockEntity
import net.minecraft.data.server.BlockLootTableGenerator
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.loot.LootTable
import net.minecraft.util.math.BlockPos

import net.minecraft.world.World




object MoviumOre: INastyOreSettings {

    override fun drops(ore: Block, item: Item?): LootTable.Builder = BlockLootTableGenerator.dropsNothing()

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
            pos ?: return

            if (!world.isClient) {
                val dir = DIRECTIONS.random()
                world.setBlockState(pos.offset(dir), defaultState)
            }
        }
    }
}