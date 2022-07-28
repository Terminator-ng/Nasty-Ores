package de.terminatorng.nastyores.item

import de.terminatorng.nastyores.ore.CrashiumOre
import de.terminatorng.nastyores.ore.EnderiteOre
import net.minecraft.entity.Entity
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.ItemStack
import net.minecraft.world.World

class EnderiteArmorItem(material: ArmorMaterial, slot: EquipmentSlot, settings: Settings) : ArmorItem(material, slot,
    settings
) {

    override fun inventoryTick(stack: ItemStack?, world: World?, entity: Entity?, slot: Int, selected: Boolean) {
        super.inventoryTick(stack, world, entity, slot, selected)
        world!!

        if (world.random.nextInt(1000) == 0) EnderiteOre.teleportEntity(entity)
    }

}