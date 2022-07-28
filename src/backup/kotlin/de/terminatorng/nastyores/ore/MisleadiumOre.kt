package de.terminatorng.nastyores.ore

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.entity.player.PlayerEntity

import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.util.math.BlockPos
import net.minecraft.util.registry.Registry

import net.minecraft.world.World




object MisleadiumOre: INastyOreSettings {
    private const val SIDE_RANGE = 500
    private var cache: List<ItemStack>? = null

    override fun oreFactory(settings: FabricBlockSettings) = object: OreBlock(settings) {
        override fun onBreak(world: World?, pos: BlockPos?, state: BlockState?, player: PlayerEntity?) {
            super.onBreak(world, pos, state, player)
            world ?: return
            pos ?: return
            player ?: return

            if (!world.isClient) {
                val stack = Registry.ITEM.get(Registry.ITEM.keys.random())?.defaultStack ?: return
                val fX: Int = pos.x + world.random.nextInt(SIDE_RANGE) - world.random.nextInt(SIDE_RANGE)
                val fY: Int = world.random.nextInt(100) + 10
                val fZ: Int = pos.z + world.random.nextInt(SIDE_RANGE) - world.random.nextInt(SIDE_RANGE)
                player.sendMessage(Text.translatable(
                    "badores.misleadium.baseMessage",
                    stack,
                    fX.toString(),
                    fY.toString(),
                    fZ.toString()
                ))
            }
        }
    }
}