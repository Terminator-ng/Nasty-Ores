package de.terminatorng.nastyores.item

import de.terminatorng.nastyores.ore.NopiumOre
import net.minecraft.block.Block
import net.minecraft.entity.Entity
import net.minecraft.item.BlockItem
import net.minecraft.item.ItemStack
import net.minecraft.world.World

class NopiumBlockItem(block: Block, settings: Settings) : BlockItem(block, settings) {

    override fun inventoryTick(stack: ItemStack?, world: World?, entity: Entity?, slot: Int, selected: Boolean) {
        super.inventoryTick(stack, world, entity, slot, selected)

        NopiumOre.dropRandomly(stack, slot, entity)
    }

}