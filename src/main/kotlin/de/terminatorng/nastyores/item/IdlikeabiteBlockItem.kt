package de.terminatorng.nastyores.item

import net.minecraft.block.Block
import net.minecraft.entity.Entity
import net.minecraft.item.BlockItem
import net.minecraft.item.ItemStack
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.world.World

class IdlikeabiteBlockItem(block: Block, settings: Settings) : BlockItem(block, settings) {

    override fun inventoryTick(stack: ItemStack?, world: World?, entity: Entity?, slot: Int, selected: Boolean) {
        super.inventoryTick(stack, world, entity, slot, selected)
        world!!
        entity!!

        if (entity !is ServerPlayerEntity) return

        if (world.random.nextInt(200) == 0) entity.hungerManager.addExhaustion(1.0F)
    }

}