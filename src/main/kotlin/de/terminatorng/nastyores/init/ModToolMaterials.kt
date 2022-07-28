package de.terminatorng.nastyores.init

import de.terminatorng.nastyores.util.NastyOresToolMaterial

object ModToolMaterials {

    val AMADEUM = NastyOresToolMaterial(2, 250, 6.0F, 2.0F, 20) { ModItems.AMADEUM_INGOT }

    val CRAPPIUM = NastyOresToolMaterial(0, 1, 2.0F, 0.0F, 15) { ModItems.CRAPPIUM_INGOT }

    val CRASHIUM = NastyOresToolMaterial(2, 250, 8.0F, 2.0F, 8) { ModItems.CRASHIUM }

    val ENDERITE = NastyOresToolMaterial(1, 120, 4.0F, 1.0F, 15) { ModItems.ENDERITE_INGOT }

    val DIAMOND = NastyOresToolMaterial(0, 1, 2.0f, 0.0f, 0) { ModItems.DIAMOND }

    val NOPIUM = NastyOresToolMaterial(2, 800, 0.5F, 1.0F, 0) { ModItems.NOPIUM_INGOT }

    val POLITE = NastyOresToolMaterial(1, 200, 5.0F, 2.0F, 15) { ModItems.POLITE_INGOT }

    val SMITE = NastyOresToolMaterial(2, 220, 5.0F, 2.0F, 8) { ModItems.SMITE }
}