package de.terminatorng.nastyores.init

import de.terminatorng.nastyores.blockentity.AmadeumBlockEntity
import de.terminatorng.nastyores.id
import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.util.registry.Registry

object ModBlockEntities {
    val AMADEUM_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create(::AmadeumBlockEntity, ModOres.AMADEUM_ORE.nastyOre.oreBlock.block).build(null)!!

    fun <T: BlockEntity> registerBlockEntityType(name: String, type: BlockEntityType<T>): BlockEntityType<T> = Registry.register(Registry.BLOCK_ENTITY_TYPE, id(name), type)

    fun init() {
        registerBlockEntityType("amadeum", AMADEUM_BLOCK_ENTITY)
    }
}