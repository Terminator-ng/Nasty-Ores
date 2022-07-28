package de.terminatorng.nastyores.init

import de.terminatorng.nastyores.util.NastyOresArmorMaterial

object ModArmorMaterials {

    val AMADEUM = NastyOresArmorMaterial("amadeum",10, intArrayOf(2, 6, 5, 2), 20) { ModItems.AMADEUM_INGOT }

    val CRAPPIUM = NastyOresArmorMaterial("crappium",1, intArrayOf(1, 1, 1, 1), 0) { ModItems.CRAPPIUM_INGOT }

    val CRASHIUM = NastyOresArmorMaterial("crashium", 8, intArrayOf(2, 7, 5, 2), 9) { ModItems.CRASHIUM }

    val ENDERITE = NastyOresArmorMaterial("enderite", 17, intArrayOf(2, 5, 4, 1), 20) { ModItems.ENDERITE_INGOT }

    val DIAMOND = NastyOresArmorMaterial("lookslikediamondium", 1, intArrayOf(1, 1, 1, 1), 0) { ModItems.DIAMOND }

    val NOPIUM = NastyOresArmorMaterial("nopium", 15, intArrayOf(2, 6, 5, 2), 0) { ModItems.NOPIUM_INGOT }

    val POLITE = NastyOresArmorMaterial("polite", 8, intArrayOf(2, 4, 3, 1), 8) { ModItems.POLITE_INGOT }

    val SMITE = NastyOresArmorMaterial("smite", 8, intArrayOf(2, 5, 4, 2), 8) { ModItems.SMITE }


}