package de.terminatorng.nastyores.util

import de.terminatorng.nastyores.IRegistrable
import de.terminatorng.nastyores.init.ModItems
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.mininglevel.v1.FabricMineableTags
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.Models
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
import net.minecraft.item.*
import net.minecraft.recipe.Ingredient
import net.minecraft.tag.TagKey
import java.util.function.Consumer

class NastyOresTools(private val name: String, private val material: Item, private val info: ToolInfo, settings: FabricItemSettings): ToolMaterial, IRegistrable {

    val axeItem = AxeItem(this, 6.0F, -3.1F, settings)
    val hoeItem = HoeItem(this, 2, -1.0F, settings)
    val pickaxeItem = PickaxeItem(this, 1, -2.8F, settings)
    val shovelItem = ShovelItem(this, 1.5F, -3.0F, settings)
    val swordItem = SwordItem(this, 3, -2.4F, settings)

    override fun getDurability(): Int = info.durability
    override fun getMiningSpeedMultiplier(): Float = info.miningSpeedMultiplier
    override fun getAttackDamage(): Float = info.damage
    override fun getMiningLevel(): Int = info.miningLevel
    override fun getEnchantability(): Int = info.enchantability
    override fun getRepairIngredient(): Ingredient = Ingredient.ofItems(material)

    override fun register() {
        ModItems.registerItem("${name}_axe", axeItem)
        ModItems.registerItem("${name}_hoe", hoeItem)
        ModItems.registerItem("${name}_pickaxe", pickaxeItem)
        ModItems.registerItem("${name}_shovel", shovelItem)
        ModItems.registerItem("${name}_sword", swordItem)
    }

    fun generateItemModels(generator: ItemModelGenerator) {
        generator.register(axeItem, Models.GENERATED)
        generator.register(hoeItem, Models.GENERATED)
        generator.register(pickaxeItem, Models.GENERATED)
        generator.register(shovelItem, Models.GENERATED)
        generator.register(swordItem, Models.GENERATED)
    }

    private fun createRecipe(builder: ShapedRecipeJsonBuilder, exporter: Consumer<RecipeJsonProvider>?) =
        builder
            .input(Character.valueOf('X'), material)
            .input(Character.valueOf('#'), Items.STICK)

    fun generateRecipes(exporter: Consumer<RecipeJsonProvider>?) {
        createRecipe(
            ShapedRecipeJsonBuilder
                .create(axeItem)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #"),
            exporter)

        createRecipe(
            ShapedRecipeJsonBuilder
                .create(hoeItem)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #"),
            exporter)

        createRecipe(
            ShapedRecipeJsonBuilder
                .create(pickaxeItem)
                .pattern("XXX")
                .pattern(" #")
                .pattern(" #"),
            exporter)

        createRecipe(
            ShapedRecipeJsonBuilder
                .create(shovelItem)
                .pattern("X")
                .pattern("#")
                .pattern("#"),
            exporter)

        createRecipe(
            ShapedRecipeJsonBuilder
                .create(swordItem)
                .pattern("X")
                .pattern("X")
                .pattern("#"),
            exporter)
    }
}