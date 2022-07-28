package de.terminatorng.nastyores.ore

import net.minecraft.block.Block
import net.minecraft.data.server.BlockLootTableGenerator
import net.minecraft.enchantment.Enchantments
import net.minecraft.item.Item
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTable
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.function.ApplyBonusLootFunction
import net.minecraft.loot.function.SetCountLootFunction
import net.minecraft.loot.provider.number.ConstantLootNumberProvider
import net.minecraft.loot.provider.number.LootNumberProviderTypes


object KakkariteOre: NastyOre("kakkarite") {

    override fun hasItem() = true
    override fun hasBlock() = true
    override fun dropsItemDirectly() = true

    override fun drops(): LootTable.Builder =
        LootTable.builder()
            .pool(LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(9000.0F))
                .with(BlockLootTableGenerator.applyExplosionDecay(oreBlock.block, ItemEntry.builder(item)
                    .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE)))))

    // fun addOreDrops(world: World?, x: Int, y: Int, z: Int, meta: Int, fortune: Int, drops: MutableList<ItemStack?>) {
    //     var items = 9001
    //     while (items > 0) {
    //         val stack: ItemStack = ItemBOIngot.createIngot(this)
    //         stack.stackSize = Math.min(64, items)
    //         items -= stack.stackSize
    //         drops.add(stack)
    //     }
    // }


}