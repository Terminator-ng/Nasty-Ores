package de.terminatorng.nastyores.ore

import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.data.server.BlockLootTableGenerator
import net.minecraft.item.Item
import net.minecraft.loot.LootTable
import net.minecraft.util.math.intprovider.UniformIntProvider

import net.minecraft.world.gen.placementmodifier.CountPlacementModifier


object StoniumOre: NastyOre("stonium") {

    override fun requiresTool() = false
    override fun hardness() = 1.0F

    // fun harvestLevelRequired(isIngotBlock: Boolean): Int {
    //     return 0
    // }

    override fun drops(): LootTable.Builder =
        BlockLootTableGenerator.oreDrops(oreBlock.block, Blocks.COBBLESTONE.asItem())

    override fun countPlacement(): CountPlacementModifier = CountPlacementModifier.of(UniformIntProvider.create(0, 20))
    override fun veinSize() = 10
}