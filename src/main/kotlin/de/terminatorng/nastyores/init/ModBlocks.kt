package de.terminatorng.nastyores.init

import de.terminatorng.nastyores.block.*
import de.terminatorng.nastyores.id
import de.terminatorng.nastyores.item.AmadeumBlockItem
import de.terminatorng.nastyores.item.NopiumBlockItem
import de.terminatorng.nastyores.item.IdlikeabiteBlockItem
import de.terminatorng.nastyores.item.KilliumBlockItem
import de.terminatorng.nastyores.ore.ZombieuniteOre
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.block.OreBlock
import net.minecraft.item.BlockItem
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.registry.Registry

object ModBlocks {

    lateinit var AMADEUM_ORE: Block
    lateinit var AMADEUM_BLOCK: Block

    lateinit var APPETITE_ORE: Block

    lateinit var BALANCIUM_ORE: Block

    lateinit var BARELY_GENERITE_ORE: Block
    lateinit var BARELY_GENERITE_BLOCK: Block

    lateinit var BREAKIUM_ORE: Block

    lateinit var CRAPPIUM_ORE: Block
    lateinit var CRAPPIUM_BLOCK: Block

    lateinit var CRASHIUM_ORE: Block
    lateinit var CRASHIUM_BLOCK: Block

    lateinit var ENDERITE_ORE: Block
    lateinit var ENDERITE_BLOCK: Block

    lateinit var EXPLODEMITE_ORE: Block

    lateinit var GHOSTIUM_ORE: Block

    lateinit var IDLIKEABITE_ORE: Block

    lateinit var KAKKARITE_ORE: Block
    lateinit var KAKKARITE_BLOCK: Block

    lateinit var KILLIUM_ORE: Block

    lateinit var LITE_ORE: Block

    lateinit var DIAMOND_ORE: Block
    lateinit var DIAMOND_BLOCK: Block

    lateinit var MARMITE_ORE: Block
    lateinit var MARMITE_BLOCK: Block

    lateinit var METEORITE_ORE: Block

    lateinit var MISLEADIUM_ORE: Block

    lateinit var MOVIUM_ORE: Block

    lateinit var NOPIUM_ORE: Block
    lateinit var NOPIUM_BLOCK: Block

    lateinit var NOSLEEPTONITE_ORE: Block
    lateinit var NOSLEEPTONITE_BLOCK: Block

    lateinit var PAINTITWHITE_ORE: Block

    lateinit var PANDAEMONIUM_ORE: Block

    lateinit var POLITE_ORE: Block
    lateinit var POLITE_BLOCK: Block

    lateinit var SHIFTIUM_ORE: Block

    lateinit var SMITE_ORE: Block
    lateinit var SMITE_BLOCK: Block

    lateinit var STONIUM_ORE: Block

    lateinit var STREETSCUM_ORE: Block

    lateinit var TAUNTUM_ORE: Block

    lateinit var UNOBTAINIUM_ORE: Block

    lateinit var USELESSIUM_ORE: Block

    lateinit var WANNAFITE_ORE: Block

    lateinit var WANTARITE_ORE: Block

    lateinit var WEBSITE_ORE: Block

    lateinit var ZOMBIEUNITE_ORE: Block

    fun init() {
        val defaultBlockItems = ModItems.createDefaultSettings()
        fun defaultOres(requiresTool: Boolean, material: Material = Material.STONE) = FabricBlockSettings.of(material).apply {
            if (requiresTool) requiresTool()
            strength(3.0F, 5.0F)
        }
        val defaultBlocks = FabricBlockSettings.of(Material.METAL)
            .requiresTool()
            .strength(6.0F, 6.0F)

        AMADEUM_ORE = registerBlockItem("amadeum_ore", AmadeumBlockItem(AmadeumOreBlock(defaultOres(true)), defaultBlockItems))
        AMADEUM_BLOCK = registerBlockItem("amadeum_block", AmadeumBlockItem(AmadeumBlock(defaultBlocks), defaultBlockItems))

        APPETITE_ORE = registerBlockItem("appetite_ore", BlockItem(AppetiteOreBlock(defaultOres(false, Material.AGGREGATE)
            .hardness(0.5F)
            .sounds(BlockSoundGroup.SAND)
        ), defaultBlockItems))

        BALANCIUM_ORE = registerBlockItem("balancium_ore", BlockItem(OreBlock(defaultOres(true)), defaultBlockItems))

        BARELY_GENERITE_ORE = registerBlockItem("barely_generite_ore", BlockItem(OreBlock(defaultOres(true)), defaultBlockItems))
        BARELY_GENERITE_BLOCK = registerBlockItem("barely_generite_block", BlockItem(Block(defaultBlocks), defaultBlockItems))

        BREAKIUM_ORE = registerBlockItem("breakium_ore", BlockItem(BreakiumOreBlock(defaultOres(true)), defaultBlockItems))

        CRAPPIUM_ORE = registerBlockItem("crappium_ore", BlockItem(OreBlock(defaultOres(true)), defaultBlockItems))
        CRAPPIUM_BLOCK = registerBlockItem("crappium_block", BlockItem(Block(defaultBlocks), defaultBlockItems))

        CRASHIUM_ORE = registerBlockItem("crashium_ore", BlockItem(CrashiumOreBlock(defaultOres(true)), defaultBlockItems))
        CRASHIUM_BLOCK = registerBlockItem("crashium_block", BlockItem(CrashiumBlock(defaultBlocks), defaultBlockItems))

        ENDERITE_ORE = registerBlockItem("enderite_ore", BlockItem(EnderiteOreBlock(defaultOres(true)), defaultBlockItems))
        ENDERITE_BLOCK = registerBlockItem("enderite_block", BlockItem(EnderiteBlock(defaultBlocks), defaultBlockItems))

        EXPLODEMITE_ORE = registerBlockItem("explodemite_ore", BlockItem(ExplodemiteOreBlock(defaultOres(true)
            .strength(8.0F, 10.0F)
        ), defaultBlockItems))

        GHOSTIUM_ORE = registerBlockItem("ghostium_ore", BlockItem(GhostiumOreBlock(defaultOres(true)), defaultBlockItems))

        IDLIKEABITE_ORE = registerBlockItem("idlikeabite_ore", IdlikeabiteBlockItem(IdlikeabiteOreBlock(defaultOres(false, Material.SOIL)
            .sounds(BlockSoundGroup.GRAVEL)
        ), defaultBlockItems))

        KAKKARITE_ORE = registerBlockItem("kakkarite_ore", BlockItem(OreBlock(defaultOres(true)), defaultBlockItems))
        KAKKARITE_BLOCK = registerBlockItem("kakkarite_block", BlockItem(Block(defaultBlocks), defaultBlockItems))

        KILLIUM_ORE = registerBlockItem("killium_ore", KilliumBlockItem(KilliumOreBlock(defaultOres(true)), defaultBlockItems))

        LITE_ORE = registerBlockItem("lite_ore", BlockItem(OreBlock(defaultOres(true)
            .luminance(10)
        ), defaultBlockItems))

        DIAMOND_ORE = registerBlockItem("diamond_ore", BlockItem(OreBlock(defaultOres(true)), defaultBlockItems))
        DIAMOND_BLOCK = registerBlockItem("diamond_block", BlockItem(Block(defaultBlocks), defaultBlockItems))

        MARMITE_ORE = registerBlockItem("marmite_ore", BlockItem(OreBlock(defaultOres(false, Material.ORGANIC_PRODUCT)
            .sounds(BlockSoundGroup.GRAVEL)
        ), defaultBlockItems))
        MARMITE_BLOCK = registerBlockItem("marmite_block", BlockItem(Block(defaultBlocks), defaultBlockItems))

        METEORITE_ORE = registerBlockItem("meteorite_ore", BlockItem(MeteoriteOreBlock(defaultOres(true)), defaultBlockItems))

        MISLEADIUM_ORE = registerBlockItem("misleadium_ore", BlockItem(MisleadiumOreBlock(defaultOres(true)), defaultBlockItems))

        MOVIUM_ORE = registerBlockItem("movium_ore", BlockItem(MoviumOreBlock(defaultOres(true).dropsNothing()), defaultBlockItems))

        NOPIUM_ORE = registerBlockItem("nopium_ore", NopiumBlockItem(OreBlock(defaultOres(true)), defaultBlockItems))
        NOPIUM_BLOCK = registerBlockItem("nopium_block", NopiumBlockItem(Block(defaultBlocks), defaultBlockItems))

        NOSLEEPTONITE_ORE = registerBlockItem("nosleeptonite_ore", BlockItem(NosleeptoniteOreBlock(defaultOres(true)), defaultBlockItems))
        NOSLEEPTONITE_BLOCK = registerBlockItem("nosleeptonite_block", BlockItem(Block(defaultBlocks), defaultBlockItems))

        PAINTITWHITE_ORE = registerBlockItem("paintitwhite_ore", BlockItem(OreBlock(defaultOres(false)), defaultBlockItems))

        PANDAEMONIUM_ORE = registerBlockItem("pandaemonium_ore", BlockItem(PandaemoniumOreBlock(defaultOres(true)), defaultBlockItems))

        POLITE_ORE = registerBlockItem("polite_ore", BlockItem(PoliteOreBlock(defaultOres(true)), defaultBlockItems))
        POLITE_BLOCK = registerBlockItem("polite_block", BlockItem(Block(defaultBlocks), defaultBlockItems))

        SHIFTIUM_ORE = registerBlockItem("shiftium_ore", BlockItem(ShiftiumOreBlock(defaultOres(false).dropsNothing()), defaultBlockItems))

        SMITE_ORE = registerBlockItem("smite_ore", BlockItem(SmiteOreBlock(defaultOres(true)), defaultBlockItems))
        SMITE_BLOCK = registerBlockItem("smite_block", BlockItem(Block(defaultBlocks), defaultBlockItems))

        STONIUM_ORE = registerBlockItem("stonium_ore", BlockItem(OreBlock(defaultOres(false)
            .hardness(1.0F)
        ), defaultBlockItems))

        STREETSCUM_ORE = registerBlockItem("streetscum_ore", BlockItem(StreetscumOreBlock(defaultOres(true)), defaultBlockItems))

        TAUNTUM_ORE = registerBlockItem("tauntum_ore", BlockItem(TauntumOreBlock(defaultOres(true)), defaultBlockItems))

        UNOBTAINIUM_ORE = registerBlockItem("unobtainium_ore", BlockItem(OreBlock(defaultOres(true)
            .strength(-1.0f, 3600000.0f)
            .dropsNothing()
        ), defaultBlockItems))

        USELESSIUM_ORE = registerBlockItem("uselessium_ore", BlockItem(OreBlock(defaultOres(true)), defaultBlockItems))

        WANNAFITE_ORE = registerBlockItem("wannafite_ore", BlockItem(WannafiteOreBlock(defaultOres(true)), defaultBlockItems))

        WANTARITE_ORE = registerBlockItem("wantarite_ore", BlockItem(WantariteOreBlock(defaultOres(true)), defaultBlockItems))

        WEBSITE_ORE = registerBlockItem("website_ore", BlockItem(WebsiteOreBlock(defaultOres(true)), defaultBlockItems))

        ZOMBIEUNITE_ORE = registerBlockItem("zombieunite_ore", BlockItem(OreBlock(defaultOres(true)), defaultBlockItems))
    }

    private fun registerBlock(name: String, block: Block): Block = Registry.register(Registry.BLOCK, id(name), block)

    private fun registerBlockItem(name: String, blockItem: BlockItem): Block {
        registerBlock(name, blockItem.block)
        ModItems.registerItem(name, blockItem)
        return blockItem.block
    }


}