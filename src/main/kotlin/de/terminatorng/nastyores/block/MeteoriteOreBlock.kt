package de.terminatorng.nastyores.block

import de.terminatorng.nastyores.mixin.FallingBlockEntityMixin
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.block.OreBlock
import net.minecraft.block.entity.BlockEntity
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.enchantment.Enchantments
import net.minecraft.entity.EntityType
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3d
import net.minecraft.world.World

class MeteoriteOreBlock(settings: Settings): OreBlock(settings) {

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
        pos!!

        if (world.isClient) return
        if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) > 0) return

        val number = world.random.nextBetween(3, 23)
        val fallingBlock = if (world.random.nextBoolean()) Blocks.STONE else Blocks.NETHERRACK

        for (i in 0 until number) {
            val spawnPos = Vec3d(
                pos.x.toDouble(),
                pos.y + 2.0,
                pos.z.toDouble(),
            )

            Vec3d(
                world.random.nextTriangular(pos.x.toDouble(), METEORITE_SPAWN_SIDE),
                260.0,
                world.random.nextTriangular(pos.y.toDouble(), METEORITE_SPAWN_SIDE),
            )

            val entity = EntityType.FALLING_BLOCK.create(world) ?: return

            (entity as FallingBlockEntityMixin).setBlockState(fallingBlock.defaultState)
            entity.refreshPositionAfterTeleport(spawnPos)
            // entity.addVelocity(
            //     world.random.nextTriangular(0.0, 1.0),
            //     0.0,
            //     world.random.nextTriangular(0.0, 1.0),
            // )
            world.spawnEntity(entity)
        }

    }

    companion object {
        const val METEORITE_SPAWN_SIDE = 50.0
    }

}