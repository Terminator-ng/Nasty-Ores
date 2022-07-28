package de.terminatorng.nastyores.world

import de.terminatorng.nastyores.init.ModBlocks
import de.terminatorng.nastyores.ore.PoliteOre
import de.terminatorng.nastyores.util.WeightedOneIntProvider
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.util.math.intprovider.UniformIntProvider
import net.minecraft.util.registry.BuiltinRegistries
import net.minecraft.util.registry.Registry
import net.minecraft.util.registry.RegistryEntry
import net.minecraft.util.registry.RegistryKey
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.feature.ConfiguredFeature
import net.minecraft.world.gen.feature.Feature
import net.minecraft.world.gen.feature.OreFeatureConfig
import net.minecraft.world.gen.feature.PlacedFeature
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier

object ModOreGen {

    fun init() {
        /*
        registerOreGen(ModBlocks.AMADEUM_ORE, OreGenSettings()
            .countPlacement(CountPlacementModifier.of(WeightedOneIntProvider(100))))

        registerOreGen(ModBlocks.APPETITE_ORE, OreGenSettings()
            .range(64, 128)
            .replace(Blocks.SAND))

        registerOreGen(ModBlocks.BALANCIUM_ORE, OreGenSettings()
            .veinSize(3))

        registerOreGen(ModBlocks.BARELY_GENERITE_ORE, OreGenSettings()
            .veinSize(1)
            .countPlacement(CountPlacementModifier.of(WeightedOneIntProvider(10000))))

        registerOreGen(ModBlocks.CRAPPIUM_ORE, OreGenSettings()
            .veinsPerChunk(8)
            .range(40, 128))

        registerOreGen(ModBlocks.CRASHIUM_ORE, OreGenSettings())

        registerOreGen(ModBlocks.ENDERITE_ORE, OreGenSettings())

        registerOreGen(ModBlocks.EXPLODEMITE_ORE, OreGenSettings()
            .countPlacement(CountPlacementModifier.of(WeightedOneIntProvider(10))))

        registerOreGen(ModBlocks.GHOSTIUM_ORE, OreGenSettings())

        registerOreGen(ModBlocks.IDLIKEABITE_ORE, OreGenSettings()
            .replace(Blocks.DIRT)
            .range(64, 128))

        registerOreGen(ModBlocks.KAKKARITE_ORE, OreGenSettings())

        registerOreGen(ModBlocks.KILLIUM_ORE, OreGenSettings())

        registerOreGen(ModBlocks.LITE_ORE, OreGenSettings()
            .veinSize(4)
            .countPlacement(CountPlacementModifier.of(UniformIntProvider.create(4, 12))))

        registerOreGen(ModBlocks.DIAMOND_ORE, OreGenSettings())

        registerOreGen(ModBlocks.MARMITE_ORE, OreGenSettings()
            .replace(Blocks.CLAY)
            .range(64, 128))

        registerOreGen(ModBlocks.METEORITE_ORE, OreGenSettings()
            .range(90, Int.MAX_VALUE))

        registerOreGen(ModBlocks.MISLEADIUM_ORE, OreGenSettings())

        registerOreGen(ModBlocks.MOVIUM_ORE, OreGenSettings())

        registerOreGen(ModBlocks.NOPIUM_ORE, OreGenSettings())

        registerOreGen(ModBlocks.NOSLEEPTONITE_ORE, OreGenSettings()
            .veinSize(1)
            .range(5, 40)
            .countPlacement(CountPlacementModifier.of(WeightedOneIntProvider(40))))

        registerOreGen(ModBlocks.PAINTITWHITE_ORE, OreGenSettings()
            .range(32, 128)
            .replace(Blocks.GRAVEL)
            .countPlacement(CountPlacementModifier.of(UniformIntProvider.create(2, 7))))

        registerOreGen(ModBlocks.PANDAEMONIUM_ORE, OreGenSettings()
            .range(Int.MIN_VALUE, 10))

        registerOreGen(ModBlocks.POLITE_ORE, OreGenSettings()
            .selectedBiomes(BiomeSelectors.includeByKey(PoliteOre.SPAWN_BIOMES))
            .countPlacement(CountPlacementModifier.of(UniformIntProvider.create(4, 8))))

        registerOreGen(ModBlocks.SMITE_ORE, OreGenSettings())

        registerOreGen(ModBlocks.STONIUM_ORE, OreGenSettings()
            .veinSize(10)
            .countPlacement(CountPlacementModifier.of(UniformIntProvider.create(0, 20))))

        registerOreGen(ModBlocks.TAUNTUM_ORE, OreGenSettings()
            .veinSize(3)
            .countPlacement(CountPlacementModifier.of(WeightedOneIntProvider(100))))

        registerOreGen(ModBlocks.USELESSIUM_ORE, OreGenSettings())

        registerOreGen(ModBlocks.WANNAFITE_ORE, OreGenSettings())

        registerOreGen(ModBlocks.WANTARITE_ORE, OreGenSettings())

        registerOreGen(ModBlocks.WEBSITE_ORE, OreGenSettings())

        registerOreGen(ModBlocks.ZOMBIEUNITE_ORE, OreGenSettings())
        */
    }

    fun registerOreGen(block: Block, settings: OreGenSettings) {
        val id  = block.registryEntry.registryKey().value

        val configuredFeature = Registry.register(
            BuiltinRegistries.CONFIGURED_FEATURE,
            id,
            ConfiguredFeature(
                Feature.ORE,
                OreFeatureConfig(
                    settings.ruleTest,
                    block.defaultState,
                    settings.veinSize,
                )
            )
        )

        Registry.register(
            BuiltinRegistries.PLACED_FEATURE,
            id,
            PlacedFeature(
                RegistryEntry.of(configuredFeature),
                listOf(
                    settings.countPlacement,
                    SquarePlacementModifier.of(),
                    settings.heightPlacement,
                )
            )
        )

        BiomeModifications.addFeature(
            settings.selectedBiomes,
            GenerationStep.Feature.UNDERGROUND_ORES,
            RegistryKey.of(Registry.PLACED_FEATURE_KEY, id)
        )
    }
}