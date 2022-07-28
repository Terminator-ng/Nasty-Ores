package de.terminatorng.nastyores.world

import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext
import net.minecraft.block.BlockState
import net.minecraft.structure.rule.RuleTest
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier
import java.util.function.Predicate

interface IOreGenSettings {
    fun veinSize(): Int
    fun countPlacement(): CountPlacementModifier
    fun heightPlacement(): HeightRangePlacementModifier
    fun ruleTest(): RuleTest
    fun selectedBiomes(): Predicate<BiomeSelectionContext>
}