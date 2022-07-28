package de.terminatorng.nastyores

import de.terminatorng.nastyores.init.ModBlocks
import de.terminatorng.nastyores.init.ModItems
import de.terminatorng.nastyores.world.ModOreGen
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory

const val MOD_ID = "nastyores"
val MOD_LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)

val ITEM_GROUP: ItemGroup = FabricItemGroupBuilder.build(id("item_group")) { ItemStack(ModBlocks.POLITE_ORE) }

@Suppress("UNUSED")
fun init() {
    ModItems.init()
    ModBlocks.init()
    ModOreGen.init()

    MOD_LOGGER.info("### Nasty Ores Initialized ###")
}

fun id(path: String) = Identifier.of(MOD_ID, path)!!