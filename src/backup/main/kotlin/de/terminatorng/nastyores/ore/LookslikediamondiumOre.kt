package de.terminatorng.nastyores.ore

import de.terminatorng.nastyores.datagen.ModDatagen
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.data.client.*
import net.minecraft.item.Item
import net.minecraft.item.Items


object LookslikediamondiumOre: NastyOre("lookslikediamondium") {

    override fun dropsItemDirectly() = true
    override fun hasItem() = true
    override fun hasBlock() = true
    override fun hasTools() = true
    override fun hasArmor() = true

    private val DIAMOND_BLOCK_PARENT_MODEL_FACTORY: TexturedModel.Factory =
        TexturedModel.makeFactory({ block -> TextureMap.all(block) }, ModDatagen.createParentModel(ModelIds.getBlockModelId(Blocks.DIAMOND_BLOCK)))

    override fun genBlockModel(generator: BlockStateModelGenerator) =
        generator.registerSingleton(block!!.block, DIAMOND_BLOCK_PARENT_MODEL_FACTORY)

    override fun genItemModel(generator: ItemModelGenerator) =
        generator.register(item, ModDatagen.createParentModel(ModelIds.getItemModelId(Items.DIAMOND)))

    // fun getToolInfo(): ToolInfo? {
    //     return ToolInfo(0, 1, 2.0f, 0.0f, 0)
    // }

    // fun getArmorInfo(): ArmorInfo? {
    //     return ArmorInfo(1, intArrayOf(1, 1, 1, 1), 0)
    // }
}