package de.terminatorng.nastyores.datagen

import de.terminatorng.nastyores.id
import de.terminatorng.nastyores.init.ModBlocks
import de.terminatorng.nastyores.init.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.block.Blocks
import net.minecraft.data.client.*
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.util.Identifier

class ModModelProvider(dataGenerator: FabricDataGenerator): FabricModelProvider(dataGenerator) {
    override fun generateBlockStateModels(generator: BlockStateModelGenerator) {
        generator.registerSimpleCubeAll(ModBlocks.AMADEUM_ORE)
        generator.registerSimpleCubeAll(ModBlocks.AMADEUM_BLOCK)

        generator.registerSimpleCubeAll(ModBlocks.APPETITE_ORE)

        generator.registerSimpleCubeAll(ModBlocks.BALANCIUM_ORE)

        generator.registerSimpleCubeAll(ModBlocks.BARELY_GENERITE_ORE)
        generator.registerSimpleCubeAll(ModBlocks.BARELY_GENERITE_BLOCK)

        generator.registerSimpleCubeAll(ModBlocks.BREAKIUM_ORE)

        generator.registerSimpleCubeAll(ModBlocks.CRAPPIUM_ORE)
        generator.registerSimpleCubeAll(ModBlocks.CRAPPIUM_BLOCK)

        generator.registerSimpleCubeAll(ModBlocks.CRASHIUM_ORE)
        generator.registerSimpleCubeAll(ModBlocks.CRASHIUM_BLOCK)

        generator.registerSimpleCubeAll(ModBlocks.ENDERITE_ORE)
        generator.registerSimpleCubeAll(ModBlocks.ENDERITE_BLOCK)

        generator.registerSimpleCubeAll(ModBlocks.EXPLODEMITE_ORE)

        generator.registerSimpleCubeAll(ModBlocks.GHOSTIUM_ORE)

        generator.registerSimpleCubeAll(ModBlocks.IDLIKEABITE_ORE)

        generator.registerSimpleCubeAll(ModBlocks.KAKKARITE_ORE)
        generator.registerSimpleCubeAll(ModBlocks.KAKKARITE_BLOCK)

        generator.registerSimpleCubeAll(ModBlocks.KILLIUM_ORE)

        generator.registerSimpleCubeAll(ModBlocks.LITE_ORE)

        generator.registerParented(Blocks.DIAMOND_ORE, ModBlocks.DIAMOND_ORE)
        generator.registerParented(Blocks.DIAMOND_BLOCK, ModBlocks.DIAMOND_BLOCK)

        generator.registerSimpleCubeAll(ModBlocks.MARMITE_ORE)
        generator.registerSimpleCubeAll(ModBlocks.MARMITE_BLOCK)

        generator.registerSimpleCubeAll(ModBlocks.METEORITE_ORE)

        generator.registerSimpleCubeAll(ModBlocks.MISLEADIUM_ORE)

        generator.registerSimpleCubeAll(ModBlocks.MOVIUM_ORE)

        generator.registerSimpleCubeAll(ModBlocks.NOPIUM_ORE)
        generator.registerSimpleCubeAll(ModBlocks.NOPIUM_BLOCK)

        generator.registerSimpleCubeAll(ModBlocks.NOSLEEPTONITE_ORE)
        generator.registerSimpleCubeAll(ModBlocks.NOSLEEPTONITE_BLOCK)

        generator.registerSimpleCubeAll(ModBlocks.PAINTITWHITE_ORE)

        generator.registerSimpleCubeAll(ModBlocks.PANDAEMONIUM_ORE)

        generator.registerSimpleCubeAll(ModBlocks.POLITE_ORE)
        generator.registerSimpleCubeAll(ModBlocks.POLITE_BLOCK)

        generator.registerSimpleCubeAll(ModBlocks.SHIFTIUM_ORE)

        generator.registerSimpleCubeAll(ModBlocks.SMITE_ORE)
        generator.registerSimpleCubeAll(ModBlocks.SMITE_BLOCK)

        generator.registerSimpleCubeAll(ModBlocks.STONIUM_ORE)

        generator.registerSimpleCubeAll(ModBlocks.STREETSCUM_ORE)

        generator.registerSimpleCubeAll(ModBlocks.TAUNTUM_ORE)

        generator.registerSimpleCubeAll(ModBlocks.UNOBTAINIUM_ORE)

        generator.registerSimpleCubeAll(ModBlocks.USELESSIUM_ORE)

        generator.registerSimpleCubeAll(ModBlocks.WANNAFITE_ORE)

        generator.registerSimpleCubeAll(ModBlocks.WANTARITE_ORE)

        generator.registerSimpleCubeAll(ModBlocks.WEBSITE_ORE)

        generator.registerSimpleCubeAll(ModBlocks.ZOMBIEUNITE_ORE)

        generator.registerItemModels(
            ModItems.AMADEUM_INGOT,
            ModItems.AMADEUM_HELMET,
            ModItems.AMADEUM_CHESTPLATE,
            ModItems.AMADEUM_LEGGINGS,
            ModItems.AMADEUM_BOOTS,
            ModItems.AMADEUM_AXE,
            ModItems.AMADEUM_HOE,
            ModItems.AMADEUM_PICKAXE,
            ModItems.AMADEUM_SHOVEL,
            ModItems.AMADEUM_SWORD,

            ModItems.BARELY_GENERITE_INGOT,

            ModItems.CRAPPIUM_INGOT,
            ModItems.CRAPPIUM_HELMET,
            ModItems.CRAPPIUM_CHESTPLATE,
            ModItems.CRAPPIUM_LEGGINGS,
            ModItems.CRAPPIUM_BOOTS,
            ModItems.CRAPPIUM_AXE,
            ModItems.CRAPPIUM_HOE,
            ModItems.CRAPPIUM_PICKAXE,
            ModItems.CRAPPIUM_SHOVEL,
            ModItems.CRAPPIUM_SWORD,

            ModItems.CRASHIUM,
            ModItems.CRASHIUM_HELMET,
            ModItems.CRASHIUM_CHESTPLATE,
            ModItems.CRASHIUM_LEGGINGS,
            ModItems.CRASHIUM_BOOTS,
            ModItems.CRASHIUM_AXE,
            ModItems.CRASHIUM_HOE,
            ModItems.CRASHIUM_PICKAXE,
            ModItems.CRASHIUM_SHOVEL,
            ModItems.CRASHIUM_SWORD,

            ModItems.ENDERITE_INGOT,
            ModItems.ENDERITE_HELMET,
            ModItems.ENDERITE_CHESTPLATE,
            ModItems.ENDERITE_LEGGINGS,
            ModItems.ENDERITE_BOOTS,
            ModItems.ENDERITE_AXE,
            ModItems.ENDERITE_HOE,
            ModItems.ENDERITE_PICKAXE,
            ModItems.ENDERITE_SHOVEL,
            ModItems.ENDERITE_SWORD,

            ModItems.KAKKARITE,

            ModItems.MARMITE_INGOT,
            ModItems.MARMITE_BREAD,

            ModItems.NOPIUM_INGOT,
            ModItems.NOPIUM_HELMET,
            ModItems.NOPIUM_CHESTPLATE,
            ModItems.NOPIUM_LEGGINGS,
            ModItems.NOPIUM_BOOTS,
            ModItems.NOPIUM_AXE,
            ModItems.NOPIUM_HOE,
            ModItems.NOPIUM_PICKAXE,
            ModItems.NOPIUM_SHOVEL,
            ModItems.NOPIUM_SWORD,

            ModItems.NOSLEEPTONITE_INGOT,

            ModItems.POLITE_INGOT,
            ModItems.POLITE_HELMET,
            ModItems.POLITE_CHESTPLATE,
            ModItems.POLITE_LEGGINGS,
            ModItems.POLITE_BOOTS,
            ModItems.POLITE_AXE,
            ModItems.POLITE_HOE,
            ModItems.POLITE_PICKAXE,
            ModItems.POLITE_SHOVEL,
            ModItems.POLITE_SWORD,

            ModItems.SMITE,
            ModItems.SMITE_HELMET,
            ModItems.SMITE_CHESTPLATE,
            ModItems.SMITE_LEGGINGS,
            ModItems.SMITE_BOOTS,
            ModItems.SMITE_AXE,
            ModItems.SMITE_HOE,
            ModItems.SMITE_PICKAXE,
            ModItems.SMITE_SHOVEL,
            ModItems.SMITE_SWORD,

            ModItems.USELESSIUM_INGOT,
        )

        generator.registerParentedItemModel(Items.DIAMOND, ModItems.DIAMOND)
        generator.registerParentedItemModel(Items.DIAMOND_HELMET, ModItems.DIAMOND_HELMET)
        generator.registerParentedItemModel(Items.DIAMOND_CHESTPLATE, ModItems.DIAMOND_CHESTPLATE)
        generator.registerParentedItemModel(Items.DIAMOND_LEGGINGS, ModItems.DIAMOND_LEGGINGS)
        generator.registerParentedItemModel(Items.DIAMOND_BOOTS, ModItems.DIAMOND_BOOTS)
        generator.registerParentedItemModel(Items.DIAMOND_AXE, ModItems.DIAMOND_AXE)
        generator.registerParentedItemModel(Items.DIAMOND_HOE, ModItems.DIAMOND_HOE)
        generator.registerParentedItemModel(Items.DIAMOND_PICKAXE, ModItems.DIAMOND_PICKAXE)
        generator.registerParentedItemModel(Items.DIAMOND_SHOVEL, ModItems.DIAMOND_SHOVEL)
        generator.registerParentedItemModel(Items.DIAMOND_SWORD, ModItems.DIAMOND_SWORD)
        
        val oreManual = id("item/ore_manual")
        Models.GENERATED.upload(oreManual, TextureMap.layer0(oreManual), generator.modelCollector)
    }

    override fun generateItemModels(generator: ItemModelGenerator) {}

    companion object {
        fun BlockStateModelGenerator.registerItemModels(vararg items: Item) =
            items.forEach { registerItemModel(it) }

        fun BlockStateModelGenerator.registerParentedItemModel(parent: Item, child: Item) =
            registerParentedItemModel(child, ModelIds.getItemModelId(parent))
    }

}