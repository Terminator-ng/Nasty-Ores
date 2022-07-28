package de.terminatorng.nastyores.ore

import net.minecraft.entity.Entity
import net.minecraft.item.ItemStack
import net.minecraft.server.network.ServerPlayerEntity


object NopiumOre {

    fun dropRandomly(stack: ItemStack?, slot: Int, entity: Entity?) {
        entity!!

        if (entity !is ServerPlayerEntity) return

        if (entity.random.nextInt(200) != 0) return

        entity.dropStack(stack)
        entity.inventory.setStack(slot, ItemStack.EMPTY)
    }
}