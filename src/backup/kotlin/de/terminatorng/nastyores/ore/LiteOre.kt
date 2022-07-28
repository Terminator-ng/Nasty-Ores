package de.terminatorng.nastyores.ore

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.OreBlock
import net.minecraft.util.math.intprovider.UniformIntProvider
import net.minecraft.world.World
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier


object LiteOre: INastyOreSettings {

    override fun oreFactory(settings: FabricBlockSettings) = OreBlock(settings.luminance(10))

    override fun veinSize() = 4
    override fun countPlacement(): CountPlacementModifier = CountPlacementModifier.of(UniformIntProvider.create(4, 12))
}