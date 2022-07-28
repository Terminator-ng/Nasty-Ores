package de.terminatorng.nastyores.ore

import de.terminatorng.nastyores.blockentity.AmadeumBlockEntity
import de.terminatorng.nastyores.init.ModBlockEntities
import de.terminatorng.nastyores.util.WeightedOneIntProvider
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.BlockEntityProvider
import net.minecraft.block.BlockState
import net.minecraft.block.EnchantingTableBlock
import net.minecraft.block.OreBlock
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityTicker
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.block.entity.EnchantingTableBlockEntity
import net.minecraft.block.enums.Instrument
import net.minecraft.entity.Entity
import net.minecraft.item.ItemStack
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvent
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier
import kotlin.math.pow

object AmadeumOre: IInventoryTickableNastyOre {

    const val SOUND_VOLUME = 5.0F

    override fun hasTools() = true
    override fun hasArmor() = true
    override fun hasItem() = true
    override fun hasBlock() = true

    // fun getArmorInfo(): ArmorInfo? {
    //     return ArmorInfo(10, intArrayOf(2, 6, 5, 2), 20)
    // }

    // fun getToolInfo(): ToolInfo? {
    //     return ToolInfo(2, 250, 6.0f, 2.0f, 20)
    // }

    fun getSound(world: World): Pair<Float, SoundEvent>? {
        if (world.random.nextInt(20) != 0) return null

        val i = world.random.nextInt(15)
        val f = 2.0.pow((i - 12).toDouble() / 12.0 ).toFloat()

        return Pair(f, Instrument.values().random().sound)
    }

    override fun inventoryTick(stack: ItemStack?, world: World?, entity: Entity?, slot: Int, selected: Boolean) {
        world ?: return

        if (!world.isClient) {
            val sound = getSound(world) ?: return
            world.playSoundFromEntity(null, entity, sound.second, SoundCategory.MASTER, SOUND_VOLUME, sound.first)
        }
    }

    override fun oreFactory(settings: FabricBlockSettings): OreBlock = object: OreBlock(settings), BlockEntityProvider {
        override fun <T : BlockEntity?> getTicker(
            world: World?,
            state: BlockState?,
            type: BlockEntityType<T>?
        ): BlockEntityTicker<T>? =
            if (type == ModBlockEntities.AMADEUM_BLOCK_ENTITY && world != null && !world.isClient)
                BlockEntityTicker<T> {world: World?, pos: BlockPos?, state: BlockState?, blockEntity: T? ->
                    AmadeumBlockEntity.tick(world, pos, state, blockEntity as AmadeumBlockEntity)
                }
            else
                super.getTicker(world, state, type)

        override fun createBlockEntity(pos: BlockPos?, state: BlockState?) = AmadeumBlockEntity(pos, state)
    }

    override fun countPlacement(): CountPlacementModifier = CountPlacementModifier.of(WeightedOneIntProvider(100))
}