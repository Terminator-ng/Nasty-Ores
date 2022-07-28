package de.terminatorng.nastyores.datagen

import de.terminatorng.nastyores.init.ModBlocks
import de.terminatorng.nastyores.init.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder
import net.minecraft.item.Item
import net.minecraft.item.ItemConvertible
import net.minecraft.item.Items
import java.util.function.Consumer

class ModRecipeProvider(dataGenerator: FabricDataGenerator?) : FabricRecipeProvider(dataGenerator) {

    override fun generateRecipes(exporter: Consumer<RecipeJsonProvider>?) {
        offerSimpleOreToIngot(exporter, ModBlocks.AMADEUM_ORE, ModItems.AMADEUM_INGOT)
        offerToolsAndArmor(exporter, ModItems.AMADEUM_INGOT, arrayOf(
            ModItems.AMADEUM_HELMET,
            ModItems.AMADEUM_CHESTPLATE,
            ModItems.AMADEUM_LEGGINGS,
            ModItems.AMADEUM_BOOTS,
            ModItems.AMADEUM_AXE,
            ModItems.AMADEUM_HOE,
            ModItems.AMADEUM_PICKAXE,
            ModItems.AMADEUM_SHOVEL,
            ModItems.AMADEUM_SWORD,
        ))
        offerReversibleCompactingRecipes(exporter, ModItems.AMADEUM_INGOT, ModBlocks.AMADEUM_BLOCK)

        offerSimpleOreToIngot(exporter, ModBlocks.BARELY_GENERITE_ORE, ModItems.BARELY_GENERITE_INGOT)
        offerReversibleCompactingRecipes(exporter, ModItems.BARELY_GENERITE_INGOT, ModBlocks.BARELY_GENERITE_BLOCK)

        offerSimpleOreToIngot(exporter, ModBlocks.CRAPPIUM_ORE, ModItems.CRAPPIUM_INGOT)
        offerToolsAndArmor(exporter, ModItems.CRAPPIUM_INGOT, arrayOf(
            ModItems.CRAPPIUM_HELMET,
            ModItems.CRAPPIUM_CHESTPLATE,
            ModItems.CRAPPIUM_LEGGINGS,
            ModItems.CRAPPIUM_BOOTS,
            ModItems.CRAPPIUM_AXE,
            ModItems.CRAPPIUM_HOE,
            ModItems.CRAPPIUM_PICKAXE,
            ModItems.CRAPPIUM_SHOVEL,
            ModItems.CRAPPIUM_SWORD,
        ))
        offerReversibleCompactingRecipes(exporter, ModItems.CRAPPIUM_INGOT, ModBlocks.CRAPPIUM_BLOCK)

        offerToolsAndArmor(exporter, ModItems.CRASHIUM, arrayOf(
            ModItems.CRASHIUM_HELMET,
            ModItems.CRASHIUM_CHESTPLATE,
            ModItems.CRASHIUM_LEGGINGS,
            ModItems.CRASHIUM_BOOTS,
            ModItems.CRASHIUM_AXE,
            ModItems.CRASHIUM_HOE,
            ModItems.CRASHIUM_PICKAXE,
            ModItems.CRASHIUM_SHOVEL,
            ModItems.CRASHIUM_SWORD,
        ))
        offerReversibleCompactingRecipes(exporter, ModItems.CRASHIUM, ModBlocks.CRASHIUM_BLOCK)

        offerSimpleOreToIngot(exporter, ModBlocks.ENDERITE_ORE, ModItems.ENDERITE_INGOT)
        offerToolsAndArmor(exporter, ModItems.ENDERITE_INGOT, arrayOf(
            ModItems.ENDERITE_HELMET,
            ModItems.ENDERITE_CHESTPLATE,
            ModItems.ENDERITE_LEGGINGS,
            ModItems.ENDERITE_BOOTS,
            ModItems.ENDERITE_AXE,
            ModItems.ENDERITE_HOE,
            ModItems.ENDERITE_PICKAXE,
            ModItems.ENDERITE_SHOVEL,
            ModItems.ENDERITE_SWORD,
        ))
        offerReversibleCompactingRecipes(exporter, ModItems.ENDERITE_INGOT, ModBlocks.ENDERITE_BLOCK)

        offerReversibleCompactingRecipes(exporter, ModItems.KAKKARITE, ModBlocks.KAKKARITE_BLOCK)

        offerToolsAndArmor(exporter, ModItems.DIAMOND, arrayOf(
            ModItems.DIAMOND_HELMET,
            ModItems.DIAMOND_CHESTPLATE,
            ModItems.DIAMOND_LEGGINGS,
            ModItems.DIAMOND_BOOTS,
            ModItems.DIAMOND_AXE,
            ModItems.DIAMOND_HOE,
            ModItems.DIAMOND_PICKAXE,
            ModItems.DIAMOND_SHOVEL,
            ModItems.DIAMOND_SWORD,
        ))
        offerReversibleCompactingRecipes(exporter, ModItems.DIAMOND, ModBlocks.DIAMOND_BLOCK)

        offerSimpleOreToIngot(exporter, ModBlocks.MARMITE_ORE, ModItems.MARMITE_INGOT)
        offerReversibleCompactingRecipes(exporter, ModItems.MARMITE_INGOT, ModBlocks.MARMITE_BLOCK)
        ShapelessRecipeJsonBuilder.create(ModItems.MARMITE_BREAD)
            .input(ModItems.MARMITE_INGOT)
            .criterion("has_${ModItems.MARMITE_INGOT.registryEntry.registryKey().value.path}", conditionsFromItem(Items.DIAMOND))
            .offerTo(exporter)

        offerSimpleOreToIngot(exporter, ModBlocks.NOPIUM_ORE, ModItems.NOPIUM_INGOT)
        offerToolsAndArmor(exporter, ModItems.NOPIUM_INGOT, arrayOf(
            ModItems.NOPIUM_HELMET,
            ModItems.NOPIUM_CHESTPLATE,
            ModItems.NOPIUM_LEGGINGS,
            ModItems.NOPIUM_BOOTS,
            ModItems.NOPIUM_AXE,
            ModItems.NOPIUM_HOE,
            ModItems.NOPIUM_PICKAXE,
            ModItems.NOPIUM_SHOVEL,
            ModItems.NOPIUM_SWORD,
        ))
        offerReversibleCompactingRecipes(exporter, ModItems.NOPIUM_INGOT, ModBlocks.NOPIUM_BLOCK)

        offerSimpleOreToIngot(exporter, ModBlocks.NOSLEEPTONITE_ORE, ModItems.NOSLEEPTONITE_INGOT)
        offerReversibleCompactingRecipes(exporter, ModItems.NOSLEEPTONITE_INGOT, ModBlocks.NOSLEEPTONITE_BLOCK)

        offerSimpleOreToIngot(exporter, ModBlocks.POLITE_ORE, ModItems.POLITE_INGOT)
        offerToolsAndArmor(exporter, ModItems.POLITE_INGOT, arrayOf(
            ModItems.POLITE_HELMET,
            ModItems.POLITE_CHESTPLATE,
            ModItems.POLITE_LEGGINGS,
            ModItems.POLITE_BOOTS,
            ModItems.POLITE_AXE,
            ModItems.POLITE_HOE,
            ModItems.POLITE_PICKAXE,
            ModItems.POLITE_SHOVEL,
            ModItems.POLITE_SWORD,
        ))
        offerReversibleCompactingRecipes(exporter, ModItems.POLITE_INGOT, ModBlocks.POLITE_BLOCK)

        offerToolsAndArmor(exporter, ModItems.SMITE, arrayOf(
            ModItems.SMITE_HELMET,
            ModItems.SMITE_CHESTPLATE,
            ModItems.SMITE_LEGGINGS,
            ModItems.SMITE_BOOTS,
            ModItems.SMITE_AXE,
            ModItems.SMITE_HOE,
            ModItems.SMITE_PICKAXE,
            ModItems.SMITE_SHOVEL,
            ModItems.SMITE_SWORD,
        ))
        offerReversibleCompactingRecipes(exporter, ModItems.SMITE, ModBlocks.SMITE_BLOCK)

        offerSimpleOreToIngot(exporter, ModBlocks.USELESSIUM_ORE, ModItems.USELESSIUM_INGOT)
    }

    private fun offerSimpleOreToIngot(exporter: Consumer<RecipeJsonProvider>?, ingot: ItemConvertible, output: ItemConvertible) {
        val ingotList = listOf(ingot)
        val group = output.asItem().registryEntry.registryKey().value.path

        offerSmelting(exporter, ingotList, output, 0.7f, 200, group)
        offerBlasting(exporter, ingotList, output, 0.7f, 100, group)
    }

    private fun offerToolsAndArmor(exporter: Consumer<RecipeJsonProvider>?, material: ItemConvertible, items: Array<ItemConvertible>) {
        if (items.size < 9) return

        offerHelmet(exporter, material, items[0])
        offerChestplate(exporter, material, items[1])
        offerLeggings(exporter, material, items[2])
        offerBoots(exporter, material, items[3])
        offerAxe(exporter, material, items[4])
        offerHoe(exporter, material, items[5])
        offerPickaxe(exporter, material, items[6])
        offerShovel(exporter, material, items[7])
        offerSword(exporter, material, items[8])

    }

    private fun offerAxe(exporter: Consumer<RecipeJsonProvider>?, material: ItemConvertible, axe: ItemConvertible) {
        ShapedRecipeJsonBuilder.create(axe)
            .input('X', material)
            .input('#', Items.STICK)
            .pattern("XX")
            .pattern("X#")
            .pattern(" #")
            .criterion("has_${material.asItem().registryEntry.registryKey().value.path}", conditionsFromItem(Items.DIAMOND))
            .offerTo(exporter)
    }

    private fun offerHoe(exporter: Consumer<RecipeJsonProvider>?, material: ItemConvertible, hoe: ItemConvertible) {
        ShapedRecipeJsonBuilder.create(hoe)
            .input('X', material)
            .input('#', Items.STICK)
            .pattern("XX")
            .pattern(" #")
            .pattern(" #")
            .criterion("has_${material.asItem().registryEntry.registryKey().value.path}", conditionsFromItem(Items.DIAMOND))
            .offerTo(exporter)
    }

    private fun offerPickaxe(exporter: Consumer<RecipeJsonProvider>?, material: ItemConvertible, pickaxe: ItemConvertible) {
        ShapedRecipeJsonBuilder.create(pickaxe)
            .input('X', material)
            .input('#', Items.STICK)
            .pattern("XXX")
            .pattern(" # ")
            .pattern(" # ")
            .criterion("has_${material.asItem().registryEntry.registryKey().value.path}", conditionsFromItem(Items.DIAMOND))
            .offerTo(exporter)
    }

    private fun offerShovel(exporter: Consumer<RecipeJsonProvider>?, material: ItemConvertible, shovel: ItemConvertible) {
        ShapedRecipeJsonBuilder.create(shovel)
            .input('X', material)
            .input('#', Items.STICK)
            .pattern("X")
            .pattern("#")
            .pattern("#")
            .criterion("has_${material.asItem().registryEntry.registryKey().value.path}", conditionsFromItem(Items.DIAMOND))
            .offerTo(exporter)
    }

    private fun offerSword(exporter: Consumer<RecipeJsonProvider>?, material: ItemConvertible, sword: ItemConvertible) {
        ShapedRecipeJsonBuilder.create(sword)
            .input('X', material)
            .input('#', Items.STICK)
            .pattern("X")
            .pattern("X")
            .pattern("#")
            .criterion("has_${material.asItem().registryEntry.registryKey().value.path}", conditionsFromItem(Items.DIAMOND))
            .offerTo(exporter)
    }

    private fun offerHelmet(exporter: Consumer<RecipeJsonProvider>?, material: ItemConvertible, helmet: ItemConvertible) {
        ShapedRecipeJsonBuilder.create(helmet)
            .input('X', material)
            .pattern("XXX")
            .pattern("X X")
            .criterion("has_${material.asItem().registryEntry.registryKey().value.path}", conditionsFromItem(Items.DIAMOND))
            .offerTo(exporter)
    }

    private fun offerChestplate(exporter: Consumer<RecipeJsonProvider>?, material: ItemConvertible, chestplate: ItemConvertible) {
        ShapedRecipeJsonBuilder.create(chestplate)
            .input('X', material)
            .pattern("X X")
            .pattern("XXX")
            .pattern("XXX")
            .criterion("has_${material.asItem().registryEntry.registryKey().value.path}", conditionsFromItem(Items.DIAMOND))
            .offerTo(exporter)
    }

    private fun offerLeggings(exporter: Consumer<RecipeJsonProvider>?, material: ItemConvertible, leggings: ItemConvertible) {
        ShapedRecipeJsonBuilder.create(leggings)
            .input('X', material)
            .pattern("XXX")
            .pattern("X X")
            .pattern("X X")
            .criterion("has_${material.asItem().registryEntry.registryKey().value.path}", conditionsFromItem(Items.DIAMOND))
            .offerTo(exporter)
    }

    private fun offerBoots(exporter: Consumer<RecipeJsonProvider>?, material: ItemConvertible, boots: ItemConvertible) {
        ShapedRecipeJsonBuilder.create(boots)
            .input('X', material)
            .pattern("X X")
            .pattern("X X")
            .criterion("has_${material.asItem().registryEntry.registryKey().value.path}", conditionsFromItem(Items.DIAMOND))
            .offerTo(exporter)
    }

}