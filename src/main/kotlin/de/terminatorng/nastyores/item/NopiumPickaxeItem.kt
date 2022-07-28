package de.terminatorng.nastyores.item

import de.terminatorng.nastyores.item.NastyOresPickaxeItem
import de.terminatorng.nastyores.ore.NopiumOre
import net.minecraft.entity.Entity
import net.minecraft.item.ItemStack
import net.minecraft.item.ToolMaterial
import net.minecraft.world.World

class NopiumPickaxeItem(material: ToolMaterial, settings: Settings) : NastyOresPickaxeItem(material, settings) {

    override fun inventoryTick(stack: ItemStack?, world: World?, entity: Entity?, slot: Int, selected: Boolean) {
        super.inventoryTick(stack, world, entity, slot, selected)

        NopiumOre.dropRandomly(stack, slot, entity)
    }

}