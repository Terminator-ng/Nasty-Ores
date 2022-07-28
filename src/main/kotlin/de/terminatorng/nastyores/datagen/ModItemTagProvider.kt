package de.terminatorng.nastyores.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags
import net.minecraft.tag.ItemTags

class ModItemTagProvider(dataGenerator: FabricDataGenerator?): FabricTagProvider.ItemTagProvider(dataGenerator) {

    override fun generateTags() {}

}