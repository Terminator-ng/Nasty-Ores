package de.terminatorng.nastyores.world

import de.terminatorng.nastyores.id
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.minecraft.block.BlockState
import net.minecraft.util.registry.BuiltinRegistries
import net.minecraft.util.registry.Registry
import net.minecraft.util.registry.RegistryEntry
import net.minecraft.util.registry.RegistryKey
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.feature.ConfiguredFeature
import net.minecraft.world.gen.feature.Feature
import net.minecraft.world.gen.feature.OreFeatureConfig
import net.minecraft.world.gen.feature.PlacedFeature
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier

object OreGen {
    fun registerOreGen(name: String, state: BlockState, settings: IOreGenSettings) {
        val id = id(name)

        val configuredFeature = Registry.register(
            BuiltinRegistries.CONFIGURED_FEATURE,
            id,
            ConfiguredFeature(
                Feature.ORE,
                OreFeatureConfig(
                    settings.ruleTest(),
                    state,
                    settings.veinSize(),
                )
            )
        )

        Registry.register(
            BuiltinRegistries.PLACED_FEATURE,
            id,
            PlacedFeature(
                RegistryEntry.of(configuredFeature),
                listOf(
                    settings.countPlacement(),
                    SquarePlacementModifier.of(),
                    settings.heightPlacement(),
                )
            )
        )

        BiomeModifications.addFeature(
            settings.selectedBiomes(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            RegistryKey.of(Registry.PLACED_FEATURE_KEY, id)
        )

    }
}