package de.terminatorng.nastyores.block

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.block.entity.BlockEntity
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.enchantment.Enchantments
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import java.awt.Desktop
import java.net.URI

class WebsiteOreBlock(settings: Settings): OreBlock(settings) {

    private val RANDOM_URLS = listOf(
        "http://www.minecraft.net",
        "http://www.minecraftforge.net",
        "http://www.google.com",
        "http://www.minecraftforum.net",
        "http://www.minecraftwiki.net",
        "http://mcp.ocean-labs.de/modjam/"
    )

    override fun afterBreak(
        world: World?,
        player: PlayerEntity?,
        pos: BlockPos?,
        state: BlockState?,
        blockEntity: BlockEntity?,
        stack: ItemStack?
    ) {
        super.afterBreak(world, player, pos, state, blockEntity, stack)
        world!!

        if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) > 0) return

        if (world.isClient && Desktop.isDesktopSupported())
            Desktop.getDesktop().browse(URI(RANDOM_URLS.random()))
    }

}