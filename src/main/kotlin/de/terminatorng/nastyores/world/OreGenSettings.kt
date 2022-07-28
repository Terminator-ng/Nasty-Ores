package de.terminatorng.nastyores.world

import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.minecraft.block.Block
import net.minecraft.structure.rule.BlockMatchRuleTest
import net.minecraft.structure.rule.RuleTest
import net.minecraft.world.gen.YOffset
import net.minecraft.world.gen.feature.OreConfiguredFeatures
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier
import java.util.function.Predicate

class OreGenSettings {

    var veinSize = 8
    var countPlacement: CountPlacementModifier = CountPlacementModifier.of(64)
    var heightPlacement: HeightRangePlacementModifier = HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))
    var ruleTest: RuleTest = OreConfiguredFeatures.STONE_ORE_REPLACEABLES
    var selectedBiomes: Predicate<BiomeSelectionContext> = BiomeSelectors.foundInOverworld()

    fun veinSize(size: Int) = this.also { it.veinSize = size }

    fun countPlacement(countPlacement: CountPlacementModifier) =
        this.also { it.countPlacement = countPlacement }

    fun heightPlacement(heightPlacement: HeightRangePlacementModifier) =
        this.also { it.heightPlacement = heightPlacement }

    fun ruleTest(ruleTest: RuleTest) = this.also { it.ruleTest = ruleTest }

    fun selectedBiomes(predicate: Predicate<BiomeSelectionContext>) =
        this.also { it.selectedBiomes = selectedBiomes }

    fun range(min: Int, max: Int) = range(
        if (min == Int.MIN_VALUE) YOffset.getBottom() else YOffset.fixed(min),
        if (min == Int.MAX_VALUE) YOffset.getTop() else YOffset.fixed(max),
    )

    fun range(min: YOffset, max: YOffset) =
        this. also { it.heightPlacement = HeightRangePlacementModifier.uniform(min, max) }

    fun veinsPerChunk(amount: Int) = this.also { it.countPlacement = CountPlacementModifier.of(amount) }

    fun replace(block: Block) = this.also { it.ruleTest = BlockMatchRuleTest(block) }
}