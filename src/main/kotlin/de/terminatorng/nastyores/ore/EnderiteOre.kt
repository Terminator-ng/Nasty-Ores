package de.terminatorng.nastyores.ore

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.entity.Entity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.particle.ParticleTypes
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.sound.SoundEvents
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World


object EnderiteOre: INastyOreSettings {
    private const val RADIUS = 40
    private const val RAD_DOUBLE = RADIUS * 2

    override fun hasTools() = true

    // fun getToolInfo(): ToolInfo? {
    //     return ToolInfo(1, 120, 4.0f, 1.0f, 15)
    // }

    override fun hasArmor() = true

    // fun getArmorInfo(): ArmorInfo? {
    //     return ArmorInfo(17, intArrayOf(2, 5, 4, 1), 20)
    // }

    override fun hasItem() = true

    override fun oreFactory(settings: FabricBlockSettings) = object: OreBlock(settings) {
        override fun onBreak(world: World?, pos: BlockPos?, state: BlockState?, player: PlayerEntity?) {
            super.onBreak(world, pos, state, player)
            world ?: return
            player ?: return
            pos ?: return

            teleportTo(world, player, findRandomSpot(world, pos))
        }
    }

    override fun blockFactory(settings: FabricBlockSettings) = object: Block(settings) {
        override fun onBreak(world: World?, pos: BlockPos?, state: BlockState?, player: PlayerEntity?) {
            super.onBreak(world, pos, state, player)
            world ?: return
            player ?: return
            pos ?: return

            teleportTo(world, player, findRandomSpot(world, pos))
        }
    }

    fun onToolMine(/*type: ToolType?, */ player: PlayerEntity, world: World, x: Int, y: Int, z: Int) {
        if (!world.isClient && world.random.nextInt(5) == 0) {
            teleportTo(
                world,
                player,
                findRandomSpot(
                    world,
                    BlockPos(
                        player.x,
                        player.y,
                        player.z,
                    )
                )
            )
        }
    }

    fun onArmorTick(/* type: ArmorType?, */ player: PlayerEntity, world: World, slot: Int, stack: ItemStack?) {
        if (!world.isClient && world.random.nextInt(1000) == 0) {
            teleportTo(
                world,
                player,
                findRandomSpot(
                    world,
                    BlockPos(
                        player.x,
                        player.y,
                        player.z,
                    )
                )
            )
        }
    }

    fun onToolEntityAttack(/* type: ToolType?, */ player: PlayerEntity, target: Entity?, world: World) {
        if (!world.isClient && world.random.nextInt(5) == 0) {
            (if (world.random.nextBoolean()) player else target)?.let {
                teleportTo(
                    world,
                    it,
                    findRandomSpot(
                        world,
                        BlockPos(
                            player.x,
                            player.y,
                            player.z,
                        )
                    )
                )
            }
        }
    }

    private fun findRandomSpot(world: World, pos: BlockPos): BlockPos {
        val rX: Int = pos.x - RADIUS + world.random.nextInt(RAD_DOUBLE)
        val rZ: Int = pos.z - RADIUS + world.random.nextInt(RAD_DOUBLE)
        val rY: Int = 10 + world.random.nextInt(240)
        return BlockPos(rX, rY, rZ)
    }

    private fun teleportTo(world: World, entity: Entity, pos: BlockPos) {
        for (i in 0..31) {
            world.addParticle(
                ParticleTypes.PORTAL,
                pos.x.toDouble(),
                pos.y + world.random.nextDouble() * 2.0,
                pos.z.toDouble(),
                world.random.nextGaussian(),
                0.0,
                world.random.nextGaussian()
            )
        }
        if (!world.isClient) {
            if (entity is ServerPlayerEntity && entity.networkHandler.getConnection().isOpen && entity.world === world && !entity.isSleeping && entity.hasVehicle()) {
                entity.requestTeleportAndDismount(pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble())
            } else {
                entity.requestTeleport(pos.x.toDouble(), pos.y.toDouble(), pos.z.toDouble())
            }
            entity.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 3.0F, 1.0F)
        }
    }
}