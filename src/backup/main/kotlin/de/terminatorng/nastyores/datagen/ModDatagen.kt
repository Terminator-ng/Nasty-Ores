package de.terminatorng.nastyores.datagen

import de.terminatorng.nastyores.MOD_LOGGER
import de.terminatorng.nastyores.id
import de.terminatorng.nastyores.init.ModItems
import de.terminatorng.nastyores.init.ModOres
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.block.Block
import net.minecraft.data.client.*
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
import net.minecraft.item.Item
import net.minecraft.tag.BlockTags
import net.minecraft.tag.TagKey
import net.minecraft.util.Identifier
import java.util.*
import java.util.function.Consumer

class ModDatagen: DataGeneratorEntrypoint {

    override fun onInitializeDataGenerator(dataGenerator: FabricDataGenerator) {
        MOD_LOGGER.info("Starting Nasty Ore Datagen")
        dataGenerator.addProvider(::ModModelProvider)
        dataGenerator.addProvider(::ModRecipeProvider)
        dataGenerator.addProvider(::ModBlockLootTableProvider)
        dataGenerator.addProvider(::ModBlockTagProvider)
        dataGenerator.addProvider(::ModBlockTagProvider)
        MOD_LOGGER.info("Done With Nasty Ore Datagen")
    }

    class ModModelProvider(dataGenerator: FabricDataGenerator): FabricModelProvider(dataGenerator) {
        override fun generateBlockStateModels(generator: BlockStateModelGenerator) {
            ModOres.values().forEach { it.nastyOre.generateBlockModels(generator)}
        }

        override fun generateItemModels(generator: ItemModelGenerator) {
            ModOres.values().forEach { it.nastyOre.generateItemModels(generator)}

            generator.register(ModItems.MARMITE_BREAD_ITEM, Models.GENERATED)

            val oreBookId = id("item/ore_manual")
            Models.GENERATED.upload(oreBookId, TextureMap().put(TextureKey.LAYER0, oreBookId), generator.writer)
        }
    }

    class ModRecipeProvider(dataGenerator: FabricDataGenerator): FabricRecipeProvider(dataGenerator) {
        override fun generateRecipes(exporter: Consumer<RecipeJsonProvider>?) {
            ModOres.values().forEach { it.nastyOre.generateRecipes(exporter)}
        }
    }

    class ModBlockLootTableProvider(dataGenerator: FabricDataGenerator?): FabricBlockLootTableProvider(dataGenerator) {
        override fun generateBlockLootTables() {
            ModOres.values().forEach { it.nastyOre.generateBlockLootTables(this)}
        }

    }

    class ModBlockTagProvider(dataGenerator: FabricDataGenerator?): FabricTagProvider.BlockTagProvider(dataGenerator) {
        override fun generateTags() {
            ModOres.values().forEach { it.nastyOre.generateBlockTags {
                    tag: TagKey<Block> -> getOrCreateTagBuilder(tag)
            } }
        }

    }

    companion object {
        fun createParentModel(id: Identifier) = Model(
            Optional.of(id),
            Optional.empty(),
        )
    }
}