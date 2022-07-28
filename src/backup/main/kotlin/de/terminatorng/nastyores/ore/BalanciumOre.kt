package de.terminatorng.nastyores.ore

import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTable
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.provider.number.UniformLootNumberProvider

object BalanciumOre: NastyOre("balancium") {
    override fun veinSize() = 3

    override fun drops(): LootTable.Builder {
        return LootTable.builder()
            .pool(LootPool.builder()
                .rolls(UniformLootNumberProvider.create(5.0F, 55.0F))
                .with(ItemEntry.builder(Items.DIAMOND))
                .with(ItemEntry.builder(Items.EMERALD))
                .with(ItemEntry.builder(Items.GOLD_INGOT))
                .with(ItemEntry.builder(Items.IRON_INGOT))
                .with(ItemEntry.builder(Items.COAL))
                .with(ItemEntry.builder(Items.QUARTZ))
                .with(ItemEntry.builder(Items.GOLDEN_APPLE)))
    }
}