package de.terminatorng.nastyores

import de.terminatorng.nastyores.init.ModItems
import de.terminatorng.nastyores.init.ModOres
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory

const val MOD_ID = "nastyores"
val MOD_LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)

val ITEM_GROUP: ItemGroup = FabricItemGroupBuilder.build(id("item_group")) { ModOres.POLITE_ORE.nastyOre.oreBlock.defaultStack }

@Suppress("UNUSED")
fun init() {
    ModItems.init()
    ModOres.init()

    MOD_LOGGER.info("### Nasty Ores Initialized ###")
}

fun id(path: String) = Identifier.of(MOD_ID, path)!!