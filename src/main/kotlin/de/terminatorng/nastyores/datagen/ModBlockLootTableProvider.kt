package de.terminatorng.nastyores.datagen

import de.terminatorng.nastyores.id
import de.terminatorng.nastyores.init.ModBlocks
import de.terminatorng.nastyores.init.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.data.server.BlockLootTableGenerator
import net.minecraft.enchantment.Enchantments
import net.minecraft.item.Item
import net.minecraft.item.ItemConvertible
import net.minecraft.item.Items
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTable
import net.minecraft.loot.condition.SurvivesExplosionLootCondition
import net.minecraft.loot.entry.GroupEntry
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.entry.LeafEntry
import net.minecraft.loot.entry.LootPoolEntry
import net.minecraft.loot.entry.LootPoolEntryType
import net.minecraft.loot.entry.LootTableEntry
import net.minecraft.loot.entry.SequenceEntry
import net.minecraft.loot.function.ApplyBonusLootFunction
import net.minecraft.loot.function.LootFunctionConsumingBuilder
import net.minecraft.loot.function.SetCountLootFunction
import net.minecraft.loot.function.SetDamageLootFunction
import net.minecraft.loot.provider.number.ConstantLootNumberProvider
import net.minecraft.loot.provider.number.LootNumberProviderTypes
import net.minecraft.loot.provider.number.UniformLootNumberProvider
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType

class ModBlockLootTableProvider(dataGenerator: FabricDataGenerator?): FabricBlockLootTableProvider(dataGenerator) {

    override fun generateBlockLootTables() {
        addDrop(ModBlocks.AMADEUM_ORE)
        addDrop(ModBlocks.AMADEUM_BLOCK)

        addDropWithSilkTouch(ModBlocks.APPETITE_ORE)

        val balanciumItems = id("blocks/balancium_items")
        addDrop(ModBlocks.BALANCIUM_ORE, dropsWithSilkTouch(
            ModBlocks.BALANCIUM_ORE,
            applyExplosionDecay(Items.DIAMOND, LootTableEntry.builder(balanciumItems)
                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE)))
        ))
        lootTables[balanciumItems] = LootTable.builder()
            .pool(LootPool.builder()
                .rolls(UniformLootNumberProvider.create(5.0F, 55.0F))
                .conditionally(SurvivesExplosionLootCondition.builder())
                .with(ItemEntry.builder(Items.DIAMOND))
                .with(ItemEntry.builder(Items.EMERALD))
                .with(ItemEntry.builder(Items.GOLD_INGOT))
                .with(ItemEntry.builder(Items.IRON_INGOT))
                .with(ItemEntry.builder(Items.COAL))
                .with(ItemEntry.builder(Items.QUARTZ))
                .with(ItemEntry.builder(Items.GOLDEN_APPLE)))

        addDrop(ModBlocks.BARELY_GENERITE_ORE)
        addDrop(ModBlocks.BARELY_GENERITE_BLOCK)

        addDropWithSilkTouch(ModBlocks.BREAKIUM_ORE)

        addDrop(ModBlocks.CRAPPIUM_ORE)
        addDrop(ModBlocks.CRAPPIUM_BLOCK)

        addOreDrop(ModBlocks.CRASHIUM_ORE, ModItems.CRASHIUM)
        addDrop(ModBlocks.CRASHIUM_BLOCK)

        addDrop(ModBlocks.ENDERITE_ORE)
        addDrop(ModBlocks.ENDERITE_BLOCK)

        addDrop(ModBlocks.EXPLODEMITE_ORE)

        addDrop(ModBlocks.GHOSTIUM_ORE)

        addDrop(ModBlocks.IDLIKEABITE_ORE)

        addDrop(ModBlocks.KAKKARITE_ORE, LootTable.builder()
            .pool(LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(9000.0F))
                .with(ItemEntry.builder(ModItems.KAKKARITE)
                    .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE)))))
        addDrop(ModBlocks.KAKKARITE_BLOCK)

        addDrop(ModBlocks.LITE_ORE)

        addOreDrop(ModBlocks.DIAMOND_ORE, ModItems.DIAMOND)
        addDrop(ModBlocks.DIAMOND_BLOCK)

        addDrop(ModBlocks.MARMITE_ORE)
        addDrop(ModBlocks.MARMITE_BLOCK)

        addDropWithSilkTouch(ModBlocks.METEORITE_ORE)

        addDrop(ModBlocks.MISLEADIUM_ORE)

        addDrop(ModBlocks.NOPIUM_ORE)
        addDrop(ModBlocks.NOPIUM_BLOCK)

        addDrop(ModBlocks.NOSLEEPTONITE_ORE)
        addDrop(ModBlocks.NOSLEEPTONITE_BLOCK)

        addOreDrop(ModBlocks.PAINTITWHITE_ORE, Items.BONE_MEAL)

        addDrop(ModBlocks.TAUNTUM_ORE)

        val pandaemoniumItems = id("blocks/pandaemonium_items")
        addDrop(ModBlocks.PANDAEMONIUM_ORE, dropsWithSilkTouch(
            ModBlocks.PANDAEMONIUM_ORE,
            LootTableEntry.builder(pandaemoniumItems)
                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
        ))
        lootTables[pandaemoniumItems] = LootTable.builder()
            .pool(LootPool.builder()
                .rolls(UniformLootNumberProvider.create(0.0F, 3.0F))
                .with(ItemEntry.builder(Blocks.NETHERRACK))
                .with(ItemEntry.builder(Items.NETHER_WART))
                .with(ItemEntry.builder(Blocks.OBSIDIAN))
                .with(ItemEntry.builder(Blocks.OBSIDIAN))
                .with(ItemEntry.builder(Items.FIRE_CHARGE))
                .with(ItemEntry.builder(Items.BLAZE_ROD))
                .with(ItemEntry.builder(Items.MAGMA_CREAM)))

        addDrop(ModBlocks.POLITE_ORE)
        addDrop(ModBlocks.POLITE_BLOCK)

        addOreDrop(ModBlocks.SMITE_ORE, ModItems.SMITE)
        addDrop(ModBlocks.SMITE_BLOCK)

        addDrop(ModBlocks.STONIUM_ORE, Blocks.COBBLESTONE)

        addDrop(ModBlocks.STREETSCUM_ORE)

        addDrop(ModBlocks.TAUNTUM_ORE)

        addDrop(ModBlocks.USELESSIUM_ORE)

        addDrop(ModBlocks.WANNAFITE_ORE, BlockLootTableGenerator.dropsWithSilkTouch(
            ModBlocks.WANNAFITE_ORE,
            applyExplosionDecay(
                Items.IRON_SWORD,
                ItemEntry.builder(Items.IRON_SWORD)
                    .apply(SetDamageLootFunction.builder(
                        UniformLootNumberProvider.create(
                            0.0F,
                            Items.IRON_SWORD.maxDamage.toFloat()
                        )
                    )))))

        addDrop(ModBlocks.WANTARITE_ORE, BlockLootTableGenerator.dropsWithSilkTouch(
            ModBlocks.WANTARITE_ORE,
            applyExplosionDecay(
                Items.CARROT_ON_A_STICK,
                ItemEntry.builder(Items.CARROT_ON_A_STICK)
                    .apply(SetDamageLootFunction.builder(
                        UniformLootNumberProvider.create(
                            0.0F,
                            Items.CARROT_ON_A_STICK.maxDamage.toFloat()
                        )
                    )))))

        addDrop(ModBlocks.WEBSITE_ORE)

        addDrop(ModBlocks.ZOMBIEUNITE_ORE, dropsWithSilkTouch(
            ModBlocks.ZOMBIEUNITE_ORE,
            ItemEntry.builder(Items.ZOMBIE_HEAD),
        ))
    }

    private fun addOreDrop(dropsWithSilkTouch: Block, drop: Item) =
        addDrop(dropsWithSilkTouch, oreDrops(dropsWithSilkTouch, drop))

}