package de.terminatorng.nastyores.ore

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.Block
import net.minecraft.entity.Entity
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.world.World

abstract class InventoryTickableNastyOre(name: String) : NastyOre(name) {

    abstract fun inventoryTick(stack: ItemStack?, world: World?, entity: Entity?, slot: Int, selected: Boolean)

    override fun itemFactory(settings: FabricItemSettings) = object: Item(settings) {
        override fun inventoryTick(stack: ItemStack?, world: World?, entity: Entity?, slot: Int, selected: Boolean) {
            super.inventoryTick(stack, world, entity, slot, selected)

            this@InventoryTickableNastyOre.inventoryTick(stack, world, entity, slot, selected)
        }
    }

    override fun oreItemFactory(settings: FabricItemSettings, block: Block) = createBlockItem(settings, block, this)

    override fun blockItemFactory(settings: FabricItemSettings, block: Block) = createBlockItem(settings, block, this)


    companion object {
        private fun createBlockItem(settings: FabricItemSettings, block: Block, tickable: InventoryTickableNastyOre) = object: BlockItem(block, settings) {
            override fun inventoryTick(stack: ItemStack?, world: World?, entity: Entity?, slot: Int, selected: Boolean) {
                super.inventoryTick(stack, world, entity, slot, selected)

                tickable.inventoryTick(stack, world, entity, slot, selected)
            }
        }
    }

}