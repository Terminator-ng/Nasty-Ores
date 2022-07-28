package de.terminatorng.nastyores.item

import de.terminatorng.nastyores.ore.KilliumOre
import net.minecraft.block.Block
import net.minecraft.entity.Entity
import net.minecraft.item.BlockItem
import net.minecraft.item.ItemStack
import net.minecraft.world.World

class KilliumBlockItem(block: Block?, settings: Settings?) : BlockItem(block, settings) {

    override fun inventoryTick(stack: ItemStack?, world: World?, entity: Entity?, slot: Int, selected: Boolean) {
        world!!
        entity!!

        if (world.random.nextInt(1000) == 0) KilliumOre.kill(entity)
    }

}