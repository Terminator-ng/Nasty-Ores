package de.terminatorng.nastyores.init

import de.terminatorng.nastyores.ITEM_GROUP
import de.terminatorng.nastyores.id
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.FoodComponent
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.util.registry.Registry

object ModItems {

    val MARMITE_BREAD_ITEM = Item(createDefaultSettings().food(FoodComponent.Builder()
        .hunger(6)
        .saturationModifier(0.8F)
        .snack()
        .build()))

    fun createDefaultSettings(): FabricItemSettings = FabricItemSettings().group(ITEM_GROUP)

    fun registerItem(name: String, item: Item): Item = Registry.register(Registry.ITEM, id(name), item)

    fun init() {
        registerItem("marmite_bread", MARMITE_BREAD_ITEM)
    }
}