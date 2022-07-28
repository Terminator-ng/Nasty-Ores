package de.terminatorng.nastyores.ore

import de.terminatorng.nastyores.util.WeightedOneIntProvider
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier

object BarelyGeneriteOre: NastyOre("barely_generite") {

    override fun hasItem() = true
    override fun hasBlock() = true

    override fun veinSize() = 1
    override fun countPlacement(): CountPlacementModifier =
        CountPlacementModifier.of(WeightedOneIntProvider(10000))
}