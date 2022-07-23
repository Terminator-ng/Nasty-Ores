package de.terminatorng.nastyores.datagen

import de.terminatorng.nastyores.MOD_LOGGER
import de.terminatorng.nastyores.init.ModOres
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.Model
import net.minecraft.data.server.recipe.RecipeJsonProvider
import java.util.function.Consumer

class ModDatagen: DataGeneratorEntrypoint {

    override fun onInitializeDataGenerator(dataGenerator: FabricDataGenerator) {
        MOD_LOGGER.info("Starting Nasty Ore Datagen")
        dataGenerator.addProvider(::ModModelProvider)
        dataGenerator.addProvider(::ModRecipeProvider)
        dataGenerator.addProvider(::ModBlockLootTableProvider)
        MOD_LOGGER.info("Done With Nasty Ore Datagen")
    }

    class ModModelProvider(dataGenerator: FabricDataGenerator): FabricModelProvider(dataGenerator) {
        override fun generateBlockStateModels(generator: BlockStateModelGenerator) {
            ModOres.values().forEach { it.nastyOre.generateBlockModels(generator)}
        }

        override fun generateItemModels(generator: ItemModelGenerator) {
            ModOres.values().forEach { it.nastyOre.generateItemModels(generator)}
        }

    }

    class ModRecipeProvider(dataGenerator: FabricDataGenerator): FabricRecipeProvider(dataGenerator) {
        override fun generateRecipes(exporter: Consumer<RecipeJsonProvider>?) {
            ModOres.values().forEach { it.nastyOre.generateRecipes(exporter)}
        }
    }

    class ModBlockLootTableProvider(dataGenerator: FabricDataGenerator?) : FabricBlockLootTableProvider(dataGenerator) {
        override fun generateBlockLootTables() {
            ModOres.values().forEach { it.nastyOre.generateBlockLootTables(this)}
        }

    }
}