package de.terminatorng.nastyores.ore

import de.terminatorng.nastyores.util.ArmorInfo
import de.terminatorng.nastyores.util.ToolInfo
import net.minecraft.entity.Entity
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.Items

import net.minecraft.world.World


object NopiumOre: InventoryTickableNastyOre("nopium") {

    override fun hasTools() = true
    override fun hasArmor() = true
    override fun hasItem() = true
    override fun hasBlock() = true

    override fun armorInfo(): ArmorInfo = ArmorInfo(15, intArrayOf(2, 6, 5, 2), 0)
    override fun toolInfo(): ToolInfo = ToolInfo(2, 800, 0.5F, 1.0F, 0)

    override fun inventoryTick(stack: ItemStack?, world: World?, entity: Entity?, slot: Int, selected: Boolean) {
        world ?: return
        stack ?: return
        entity ?: return

        if (!world.isClient && entity is LivingEntity)
            dropRandomly(world, stack, slot, entity)
    }

    private fun dropRandomly(world: World, stack: ItemStack, slot: Int, entity: LivingEntity) {
        if (world.random.nextInt(200) == 0) {
            entity.dropStack(stack)

            if (entity is PlayerEntity)
                entity.inventory.setStack(slot, Items.AIR.defaultStack)
            else
                entity.setStackInHand(entity.activeHand, Items.AIR.defaultStack)
        }
    }
}