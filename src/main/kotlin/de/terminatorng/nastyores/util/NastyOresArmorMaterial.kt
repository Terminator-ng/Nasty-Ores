package de.terminatorng.nastyores.util

import de.terminatorng.nastyores.id
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.Item
import net.minecraft.recipe.Ingredient
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents

class NastyOresArmorMaterial(private val name: String, private val durabilityIn: Int, private val protectionValuesIn: IntArray, private val enchantabilityIn: Int, private val material: () -> Item): ArmorMaterial {

    private val BASE_DURABILITY = intArrayOf(13, 15, 16, 11)

    override fun getDurability(slot: EquipmentSlot?): Int =
        (slot?.let { BASE_DURABILITY[slot.entitySlotId] } ?: 1) * durabilityIn
    override fun getProtectionAmount(slot: EquipmentSlot?): Int =
        slot?.let { protectionValuesIn[slot.entitySlotId] } ?: 0
    override fun getEnchantability(): Int = enchantabilityIn
    override fun getEquipSound(): SoundEvent = SoundEvents.ITEM_ARMOR_EQUIP_IRON
    override fun getRepairIngredient(): Ingredient = Ingredient.ofItems(material())
    override fun getName(): String = id(name).toUnderscoreSeparatedString()
    override fun getToughness(): Float = 0.0F
    override fun getKnockbackResistance(): Float = 0.0F

}