package de.terminatorng.nastyores.init

import de.terminatorng.nastyores.id
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.util.registry.Registry

object ModBlocks {
    fun registerBlock(name: String, block: Block): Block = Registry.register(Registry.BLOCK, id(name), block)

    fun registerBlockItem(name: String, blockItem: BlockItem): Block {
        registerBlock(name, blockItem.block)
        ModItems.registerItem(name, blockItem)
        return blockItem.block
    }
}