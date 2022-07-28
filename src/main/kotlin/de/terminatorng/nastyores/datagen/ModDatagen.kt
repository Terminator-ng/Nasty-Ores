package de.terminatorng.nastyores.datagen

import de.terminatorng.nastyores.MOD_LOGGER
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator

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

}