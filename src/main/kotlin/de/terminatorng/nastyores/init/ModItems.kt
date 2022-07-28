package de.terminatorng.nastyores.init

import de.terminatorng.nastyores.ITEM_GROUP
import de.terminatorng.nastyores.item.PoliteArmorItem
import de.terminatorng.nastyores.id
import de.terminatorng.nastyores.item.*
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.ArmorItem
import net.minecraft.item.FoodComponent
import net.minecraft.item.Item
import net.minecraft.util.registry.Registry

object ModItems {

    lateinit var AMADEUM_INGOT: Item
    lateinit var AMADEUM_HELMET: Item
    lateinit var AMADEUM_CHESTPLATE: Item
    lateinit var AMADEUM_LEGGINGS: Item
    lateinit var AMADEUM_BOOTS: Item
    lateinit var AMADEUM_AXE: Item
    lateinit var AMADEUM_HOE: Item
    lateinit var AMADEUM_PICKAXE: Item
    lateinit var AMADEUM_SHOVEL: Item
    lateinit var AMADEUM_SWORD: Item

    lateinit var BARELY_GENERITE_INGOT: Item

    lateinit var CRAPPIUM_INGOT: Item
    lateinit var CRAPPIUM_HELMET: Item
    lateinit var CRAPPIUM_CHESTPLATE: Item
    lateinit var CRAPPIUM_LEGGINGS: Item
    lateinit var CRAPPIUM_BOOTS: Item
    lateinit var CRAPPIUM_AXE: Item
    lateinit var CRAPPIUM_HOE: Item
    lateinit var CRAPPIUM_PICKAXE: Item
    lateinit var CRAPPIUM_SHOVEL: Item
    lateinit var CRAPPIUM_SWORD: Item

    lateinit var CRASHIUM: Item
    lateinit var CRASHIUM_HELMET: Item
    lateinit var CRASHIUM_CHESTPLATE: Item
    lateinit var CRASHIUM_LEGGINGS: Item
    lateinit var CRASHIUM_BOOTS: Item
    lateinit var CRASHIUM_AXE: Item
    lateinit var CRASHIUM_HOE: Item
    lateinit var CRASHIUM_PICKAXE: Item
    lateinit var CRASHIUM_SHOVEL: Item
    lateinit var CRASHIUM_SWORD: Item

    lateinit var ENDERITE_INGOT: Item
    lateinit var ENDERITE_HELMET: Item
    lateinit var ENDERITE_CHESTPLATE: Item
    lateinit var ENDERITE_LEGGINGS: Item
    lateinit var ENDERITE_BOOTS: Item
    lateinit var ENDERITE_AXE: Item
    lateinit var ENDERITE_HOE: Item
    lateinit var ENDERITE_PICKAXE: Item
    lateinit var ENDERITE_SHOVEL: Item
    lateinit var ENDERITE_SWORD: Item

    lateinit var KAKKARITE: Item

    lateinit var DIAMOND: Item
    lateinit var DIAMOND_HELMET: Item
    lateinit var DIAMOND_CHESTPLATE: Item
    lateinit var DIAMOND_LEGGINGS: Item
    lateinit var DIAMOND_BOOTS: Item
    lateinit var DIAMOND_AXE: Item
    lateinit var DIAMOND_HOE: Item
    lateinit var DIAMOND_PICKAXE: Item
    lateinit var DIAMOND_SHOVEL: Item
    lateinit var DIAMOND_SWORD: Item

    lateinit var MARMITE_INGOT: Item
    lateinit var MARMITE_BREAD: Item

    lateinit var NOPIUM_INGOT: Item
    lateinit var NOPIUM_HELMET: Item
    lateinit var NOPIUM_CHESTPLATE: Item
    lateinit var NOPIUM_LEGGINGS: Item
    lateinit var NOPIUM_BOOTS: Item
    lateinit var NOPIUM_AXE: Item
    lateinit var NOPIUM_HOE: Item
    lateinit var NOPIUM_PICKAXE: Item
    lateinit var NOPIUM_SHOVEL: Item
    lateinit var NOPIUM_SWORD: Item

    lateinit var NOSLEEPTONITE_INGOT: Item

    lateinit var POLITE_INGOT: Item
    lateinit var POLITE_HELMET: Item
    lateinit var POLITE_CHESTPLATE: Item
    lateinit var POLITE_LEGGINGS: Item
    lateinit var POLITE_BOOTS: Item
    lateinit var POLITE_AXE: Item
    lateinit var POLITE_HOE: Item
    lateinit var POLITE_PICKAXE: Item
    lateinit var POLITE_SHOVEL: Item
    lateinit var POLITE_SWORD: Item

    lateinit var SMITE: Item
    lateinit var SMITE_HELMET: Item
    lateinit var SMITE_CHESTPLATE: Item
    lateinit var SMITE_LEGGINGS: Item
    lateinit var SMITE_BOOTS: Item
    lateinit var SMITE_AXE: Item
    lateinit var SMITE_HOE: Item
    lateinit var SMITE_PICKAXE: Item
    lateinit var SMITE_SHOVEL: Item
    lateinit var SMITE_SWORD: Item

    lateinit var USELESSIUM_INGOT: Item


    fun createDefaultSettings(): FabricItemSettings = FabricItemSettings().group(ITEM_GROUP)

    fun registerItem(name: String, item: Item): Item = Registry.register(Registry.ITEM, id(name), item)

    fun init() {
        val defaultItems = createDefaultSettings()

        AMADEUM_INGOT = registerItem("amadeum_ingot", AmadeumItem(createDefaultSettings()))
        AMADEUM_HELMET = registerItem("amadeum_helmet", AmadeumArmorItem(ModArmorMaterials.AMADEUM, EquipmentSlot.HEAD, defaultItems))
        AMADEUM_CHESTPLATE = registerItem("amadeum_chestplate", AmadeumArmorItem(ModArmorMaterials.AMADEUM, EquipmentSlot.CHEST, defaultItems))
        AMADEUM_LEGGINGS = registerItem("amadeum_leggings", AmadeumArmorItem(ModArmorMaterials.AMADEUM, EquipmentSlot.LEGS, defaultItems))
        AMADEUM_BOOTS = registerItem("amadeum_boots", AmadeumArmorItem(ModArmorMaterials.AMADEUM, EquipmentSlot.FEET, defaultItems))
        AMADEUM_AXE = registerItem("amadeum_axe", AmadeumAxeItem(ModToolMaterials.AMADEUM, defaultItems))
        AMADEUM_HOE = registerItem("amadeum_hoe", AmadeumHoeItem(ModToolMaterials.AMADEUM, defaultItems))
        AMADEUM_PICKAXE = registerItem("amadeum_pickaxe", AmadeumPickaxeItem(ModToolMaterials.AMADEUM, defaultItems))
        AMADEUM_SHOVEL = registerItem("amadeum_shovel", AmadeumShovelItem(ModToolMaterials.AMADEUM, defaultItems))
        AMADEUM_SWORD = registerItem("amadeum_sword", AmadeumSwordItem(ModToolMaterials.AMADEUM, defaultItems))

        BARELY_GENERITE_INGOT = registerItem("barely_generite_ingot", Item(defaultItems))

        CRAPPIUM_INGOT = registerItem("crappium_ingot", Item(defaultItems))
        CRAPPIUM_HELMET = registerItem("crappium_helmet", ArmorItem(ModArmorMaterials.CRAPPIUM, EquipmentSlot.HEAD, defaultItems))
        CRAPPIUM_CHESTPLATE = registerItem("crappium_chestplate", ArmorItem(ModArmorMaterials.CRAPPIUM, EquipmentSlot.CHEST, defaultItems))
        CRAPPIUM_LEGGINGS = registerItem("crappium_leggings", ArmorItem(ModArmorMaterials.CRAPPIUM, EquipmentSlot.LEGS, defaultItems))
        CRAPPIUM_BOOTS = registerItem("crappium_boots", ArmorItem(ModArmorMaterials.CRAPPIUM, EquipmentSlot.FEET, defaultItems))
        CRAPPIUM_AXE = registerItem("crappium_axe", NastyOresAxeItem(ModToolMaterials.CRAPPIUM, defaultItems))
        CRAPPIUM_HOE = registerItem("crappium_hoe", NastyOresHoeItem(ModToolMaterials.CRAPPIUM, defaultItems))
        CRAPPIUM_PICKAXE = registerItem("crappium_pickaxe", NastyOresPickaxeItem(ModToolMaterials.CRAPPIUM, defaultItems))
        CRAPPIUM_SHOVEL = registerItem("crappium_shovel", NastyOresShovelItem(ModToolMaterials.CRAPPIUM, defaultItems))
        CRAPPIUM_SWORD = registerItem("crappium_sword", NastyOresSwordItem(ModToolMaterials.CRAPPIUM, defaultItems))

        CRASHIUM = registerItem("crashium", Item(defaultItems))
        CRASHIUM_HELMET = registerItem("crashium_helmet", CrashiumArmorItem(ModArmorMaterials.CRASHIUM, EquipmentSlot.HEAD, defaultItems))
        CRASHIUM_CHESTPLATE = registerItem("crashium_chestplate", CrashiumArmorItem(ModArmorMaterials.CRASHIUM, EquipmentSlot.CHEST, defaultItems))
        CRASHIUM_LEGGINGS = registerItem("crashium_leggings", CrashiumArmorItem(ModArmorMaterials.CRASHIUM, EquipmentSlot.LEGS, defaultItems))
        CRASHIUM_BOOTS = registerItem("crashium_boots", CrashiumArmorItem(ModArmorMaterials.CRASHIUM, EquipmentSlot.FEET, defaultItems))
        CRASHIUM_AXE = registerItem("crashium_axe", CrashiumAxeItem(ModToolMaterials.CRASHIUM, defaultItems))
        CRASHIUM_HOE = registerItem("crashium_hoe", CrashiumHoeItem(ModToolMaterials.CRASHIUM, defaultItems))
        CRASHIUM_PICKAXE = registerItem("crashium_pickaxe", CrashiumPickaxeItem(ModToolMaterials.CRASHIUM, defaultItems))
        CRASHIUM_SHOVEL = registerItem("crashium_shovel", CrashiumShovelItem(ModToolMaterials.CRASHIUM, defaultItems))
        CRASHIUM_SWORD = registerItem("crashium_sword", CrashiumSwordItem(ModToolMaterials.CRASHIUM, defaultItems))

        ENDERITE_INGOT = registerItem("enderite_ingot", Item(defaultItems))
        ENDERITE_HELMET = registerItem("enderite_helmet", EnderiteArmorItem(ModArmorMaterials.ENDERITE, EquipmentSlot.HEAD, defaultItems))
        ENDERITE_CHESTPLATE = registerItem("enderite_chestplate", EnderiteArmorItem(ModArmorMaterials.ENDERITE, EquipmentSlot.CHEST, defaultItems))
        ENDERITE_LEGGINGS = registerItem("enderite_leggings", EnderiteArmorItem(ModArmorMaterials.ENDERITE, EquipmentSlot.LEGS, defaultItems))
        ENDERITE_BOOTS = registerItem("enderite_boots", EnderiteArmorItem(ModArmorMaterials.ENDERITE, EquipmentSlot.FEET, defaultItems))
        ENDERITE_AXE = registerItem("enderite_axe", EnderiteAxeItem(ModToolMaterials.ENDERITE, defaultItems))
        ENDERITE_HOE = registerItem("enderite_hoe", EnderiteHoeItem(ModToolMaterials.ENDERITE, defaultItems))
        ENDERITE_PICKAXE = registerItem("enderite_pickaxe", EnderitePickaxeItem(ModToolMaterials.ENDERITE, defaultItems))
        ENDERITE_SHOVEL = registerItem("enderite_shovel", EnderiteShovelItem(ModToolMaterials.ENDERITE, defaultItems))
        ENDERITE_SWORD = registerItem("enderite_sword", EnderiteSwordItem(ModToolMaterials.ENDERITE, defaultItems))

        KAKKARITE = registerItem("kakkarite", Item(defaultItems))

        DIAMOND = registerItem("diamond", Item(defaultItems))
        DIAMOND_HELMET = registerItem("diamond_helmet", ArmorItem(ModArmorMaterials.DIAMOND, EquipmentSlot.HEAD, defaultItems))
        DIAMOND_CHESTPLATE = registerItem("diamond_chestplate", ArmorItem(ModArmorMaterials.DIAMOND, EquipmentSlot.CHEST, defaultItems))
        DIAMOND_LEGGINGS = registerItem("diamond_leggings", ArmorItem(ModArmorMaterials.DIAMOND, EquipmentSlot.LEGS, defaultItems))
        DIAMOND_BOOTS = registerItem("diamond_boots", ArmorItem(ModArmorMaterials.DIAMOND, EquipmentSlot.FEET, defaultItems))
        DIAMOND_AXE = registerItem("diamond_axe", NastyOresAxeItem(ModToolMaterials.DIAMOND, defaultItems))
        DIAMOND_HOE = registerItem("diamond_hoe", NastyOresHoeItem(ModToolMaterials.DIAMOND, defaultItems))
        DIAMOND_PICKAXE = registerItem("diamond_pickaxe", NastyOresPickaxeItem(ModToolMaterials.DIAMOND, defaultItems))
        DIAMOND_SHOVEL = registerItem("diamond_shovel", NastyOresShovelItem(ModToolMaterials.DIAMOND, defaultItems))
        DIAMOND_SWORD = registerItem("diamond_sword", NastyOresSwordItem(ModToolMaterials.CRAPPIUM, defaultItems))

        MARMITE_INGOT = registerItem("marmite_ingot", Item(defaultItems))
        MARMITE_BREAD = registerItem("marmite_bread", Item(createDefaultSettings().food(FoodComponent.Builder()
            .hunger(6)
            .saturationModifier(0.8F)
            .snack()
            .build())))

        NOPIUM_INGOT = registerItem("nopium_ingot", NopiumItem(defaultItems))
        NOPIUM_HELMET = registerItem("nopium_helmet", NopiumArmorItem(ModArmorMaterials.NOPIUM, EquipmentSlot.HEAD, defaultItems))
        NOPIUM_CHESTPLATE = registerItem("nopium_chestplate", NopiumArmorItem(ModArmorMaterials.NOPIUM, EquipmentSlot.CHEST, defaultItems))
        NOPIUM_LEGGINGS = registerItem("nopium_leggings", NopiumArmorItem(ModArmorMaterials.NOPIUM, EquipmentSlot.LEGS, defaultItems))
        NOPIUM_BOOTS = registerItem("nopium_boots", NopiumArmorItem(ModArmorMaterials.NOPIUM, EquipmentSlot.FEET, defaultItems))
        NOPIUM_AXE = registerItem("nopium_axe", NopiumAxeItem(ModToolMaterials.NOPIUM, defaultItems))
        NOPIUM_HOE = registerItem("nopium_hoe", NopiumHoeItem(ModToolMaterials.NOPIUM, defaultItems))
        NOPIUM_PICKAXE = registerItem("nopium_pickaxe", NopiumPickaxeItem(ModToolMaterials.NOPIUM, defaultItems))
        NOPIUM_SHOVEL = registerItem("nopium_shovel", NopiumShovelItem(ModToolMaterials.NOPIUM, defaultItems))
        NOPIUM_SWORD = registerItem("nopium_sword", NopiumSwordItem(ModToolMaterials.NOPIUM, defaultItems))

        NOSLEEPTONITE_INGOT = registerItem("nosleeptonite_ingot", Item(defaultItems))

        POLITE_INGOT = registerItem("polite_ingot", Item(defaultItems))
        POLITE_HELMET = registerItem("polite_helmet", PoliteArmorItem(ModArmorMaterials.POLITE, EquipmentSlot.HEAD, defaultItems))
        POLITE_CHESTPLATE = registerItem("polite_chestplate", PoliteArmorItem(ModArmorMaterials.POLITE, EquipmentSlot.CHEST, defaultItems))
        POLITE_LEGGINGS = registerItem("polite_leggings", PoliteArmorItem(ModArmorMaterials.POLITE, EquipmentSlot.LEGS, defaultItems))
        POLITE_BOOTS = registerItem("polite_boots", PoliteArmorItem(ModArmorMaterials.POLITE, EquipmentSlot.FEET, defaultItems))
        POLITE_AXE = registerItem("polite_axe", PoliteAxeItem(ModToolMaterials.POLITE, defaultItems))
        POLITE_HOE = registerItem("polite_hoe", PoliteHoeItem(ModToolMaterials.POLITE, defaultItems))
        POLITE_PICKAXE = registerItem("polite_pickaxe", PolitePickaxeItem(ModToolMaterials.POLITE, defaultItems))
        POLITE_SHOVEL = registerItem("polite_shovel", PoliteShovelItem(ModToolMaterials.POLITE, defaultItems))
        POLITE_SWORD = registerItem("polite_sword", PoliteSwordItem(ModToolMaterials.POLITE, defaultItems))

        SMITE = registerItem("smite", Item(defaultItems))
        SMITE_HELMET = registerItem("smite_helmet", SmiteArmorItem(ModArmorMaterials.SMITE, EquipmentSlot.HEAD, defaultItems))
        SMITE_CHESTPLATE = registerItem("smite_chestplate", SmiteArmorItem(ModArmorMaterials.SMITE, EquipmentSlot.CHEST, defaultItems))
        SMITE_LEGGINGS = registerItem("smite_leggings", SmiteArmorItem(ModArmorMaterials.SMITE, EquipmentSlot.LEGS, defaultItems))
        SMITE_BOOTS = registerItem("smite_boots", SmiteArmorItem(ModArmorMaterials.SMITE, EquipmentSlot.FEET, defaultItems))
        SMITE_AXE = registerItem("smite_axe", SmiteAxeItem(ModToolMaterials.SMITE, defaultItems))
        SMITE_HOE = registerItem("smite_hoe", SmiteHoeItem(ModToolMaterials.SMITE, defaultItems))
        SMITE_PICKAXE = registerItem("smite_pickaxe", SmitePickaxeItem(ModToolMaterials.SMITE, defaultItems))
        SMITE_SHOVEL = registerItem("smite_shovel", SmiteShovelItem(ModToolMaterials.SMITE, defaultItems))
        SMITE_SWORD = registerItem("smite_sword", SmiteSwordItem(ModToolMaterials.SMITE, defaultItems))

        USELESSIUM_INGOT = registerItem("uselessium_ingot", Item(defaultItems))


    }
}