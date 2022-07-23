package de.terminatorng.nastyores.ore

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3d
import net.minecraft.world.World


object SmiteOre: INastyOreSettings {

    override fun hasItem() = true
    override fun hasArmor() = true
    override fun hasTools() = true

    // fun getArmorInfo(): ArmorInfo? {
    //     return ArmorInfo(8, intArrayOf(2, 5, 4, 2), 8)
    // }

    // fun getToolInfo(): ToolInfo? {
    //     return ToolInfo(2, 220, 5.0f, 2.0f, 8)
    // }

    // fun onArmorTick(type: ArmorType?, player: EntityPlayer?, world: World, side: Side, slot: Int, stack: ItemStack?) {
    //     if (side.isServer() && rand.nextInt(200) === 0) {
    //         spawnLightning(world, player)
    //     }
    // }

    override fun oreFactory(settings: FabricBlockSettings) = object: OreBlock(settings) {
        override fun onBreak(world: World?, pos: BlockPos?, state: BlockState?, player: PlayerEntity?) {
            super.onBreak(world, pos, state, player)
            world ?: return
            player ?: return

            if (!world.isClient && world.random.nextInt(3) == 0)
                spawnLightning(world, player)
        }
    }

    fun onToolEntityAttack(

    ) {
        // if (side.isServer() && rand.nextInt(2) === 0) {
        //     spawnLightning(world, if (rand.nextBoolean()) player else target)
        // }
    }

    private fun spawnLightning(world: World, entity: Entity) {
        val lightningEntity = EntityType.LIGHTNING_BOLT.create(world)!!
        lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(entity.blockPos))
        world.spawnEntity(lightningEntity)
    }
}