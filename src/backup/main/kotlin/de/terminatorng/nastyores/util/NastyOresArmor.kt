package de.terminatorng.nastyores.util

import de.terminatorng.nastyores.IRegistrable
import de.terminatorng.nastyores.init.ModItems
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.Models
import net.minecraft.data.server.RecipeProvider
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
import net.minecraft.entity.Entity
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.*
import net.minecraft.recipe.Ingredient
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import net.minecraft.world.World
import java.util.function.Consumer

class NastyOresArmor(private val name: String, private val material: Item, private val info: ArmorInfo, val settings: FabricItemSettings): ArmorMaterial, IRegistrable {

    private val BASE_DURABILITY = intArrayOf(13, 15, 16, 11)

    private fun itemFactory(equipmentSlot: EquipmentSlot) = object: ArmorItem(this, equipmentSlot, settings) {
        override fun inventoryTick(stack: ItemStack?, world: World?, entity: Entity?, slot: Int, selected: Boolean) {
            super.inventoryTick(stack, world, entity, slot, selected)
        }
    }

    val helmetItem = itemFactory(EquipmentSlot.HEAD)
    val chestplateItem = itemFactory(EquipmentSlot.CHEST)
    val leggingsItem = itemFactory(EquipmentSlot.LEGS)
    val bootsItem = itemFactory(EquipmentSlot.FEET)

    override fun getDurability(slot: EquipmentSlot?): Int =
        (slot?.let { BASE_DURABILITY[slot.entitySlotId] } ?: 1) * info.durability
    override fun getProtectionAmount(slot: EquipmentSlot?): Int =
        slot?.let { info.protectionValues[slot.entitySlotId] } ?: 0
    override fun getEnchantability(): Int = info.enchantability
    override fun getEquipSound(): SoundEvent = SoundEvents.ITEM_ARMOR_EQUIP_IRON
    override fun getRepairIngredient(): Ingredient = Ingredient.ofItems(material)
    override fun getName(): String = name
    override fun getToughness(): Float = 0.0F
    override fun getKnockbackResistance(): Float = 0.0F

    override fun register() {
        ModItems.registerItem("${name}_helmet", helmetItem)
        ModItems.registerItem("${name}_chestplate", chestplateItem)
        ModItems.registerItem("${name}_leggings", leggingsItem)
        ModItems.registerItem("${name}_boots", bootsItem)
    }

    fun generateItemModels(generator: ItemModelGenerator) {
        generator.register(helmetItem, Models.GENERATED)
        generator.register(chestplateItem, Models.GENERATED)
        generator.register(leggingsItem, Models.GENERATED)
        generator.register(bootsItem, Models.GENERATED)
    }

    private fun createRecipe(builder: ShapedRecipeJsonBuilder, exporter: Consumer<RecipeJsonProvider>?) =
        builder
            .input(Character.valueOf('X'), material)
            // .criterion("has_$name", RecipeProvider.conditionsFromItem(material))

    fun generateRecipes(exporter: Consumer<RecipeJsonProvider>?) {
        createRecipe(
            ShapedRecipeJsonBuilder
                .create(helmetItem)
                .pattern("XXX")
                .pattern("X X"),
            exporter)

        createRecipe(
            ShapedRecipeJsonBuilder
                .create(chestplateItem)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX"),
            exporter)

        createRecipe(
            ShapedRecipeJsonBuilder
                .create(helmetItem)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X"),
            exporter)

        createRecipe(
            ShapedRecipeJsonBuilder
                .create(helmetItem)
                .pattern("X X")
                .pattern("X X"),
            exporter)
    }
}