package de.terminatorng.nastyores.util

import net.minecraft.item.Item
import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient

class NastyOresToolMaterial(
    private val miningLevelIn: Int,
    private val durabilityIn: Int,
    private val miningSpeedMultiplierIn: Float,
    private val damage: Float,
    private val enchantabilityIn: Int,
    private val material: () -> Item,
): ToolMaterial {

    override fun getDurability(): Int = durabilityIn
    override fun getMiningSpeedMultiplier(): Float = miningSpeedMultiplierIn
    override fun getAttackDamage(): Float = damage
    override fun getMiningLevel(): Int = miningLevelIn
    override fun getEnchantability(): Int = enchantabilityIn
    override fun getRepairIngredient(): Ingredient = Ingredient.ofItems(material())

}