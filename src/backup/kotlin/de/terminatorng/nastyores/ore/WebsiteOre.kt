package de.terminatorng.nastyores.ore

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import java.awt.Desktop
import java.net.URI

object WebsiteOre: INastyOreSettings {

    private val RANDOM_URLS = listOf(
        "http://www.minecraft.net",
        "http://www.minecraftforge.net",
        "http://www.google.com",
        "http://www.minecraftforum.net",
        "http://www.minecraftwiki.net",
        "http://mcp.ocean-labs.de/modjam/"
    )

    override fun oreFactory(settings: FabricBlockSettings) = object: OreBlock(settings) {
        override fun onBreak(world: World?, pos: BlockPos?, state: BlockState?, player: PlayerEntity?) {
            super.onBreak(world, pos, state, player)
            world ?: return

            if (world.isClient)
                Desktop.getDesktop().browse(URI(RANDOM_URLS.random()))
        }
    }
}