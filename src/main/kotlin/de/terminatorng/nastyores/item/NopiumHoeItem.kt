package de.terminatorng.nastyores.item

import de.terminatorng.nastyores.item.NastyOresHoeItem
import de.terminatorng.nastyores.ore.NopiumOre
import net.minecraft.entity.Entity
import net.minecraft.item.ItemStack
import net.minecraft.item.ToolMaterial
import net.minecraft.world.World

class NopiumHoeItem(material: ToolMaterial, settings: Settings) : NastyOresHoeItem(material, settings) {

    override fun inventoryTick(stack: ItemStack?, world: World?, entity: Entity?, slot: Int, selected: Boolean) {
        super.inventoryTick(stack, world, entity, slot, selected)

        NopiumOre.dropRandomly(stack, slot, entity)
    }

}