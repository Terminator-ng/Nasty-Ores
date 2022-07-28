package de.terminatorng.nastyores.ore

import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.data.server.BlockLootTableGenerator
import net.minecraft.entity.mob.ZombieEntity
import net.minecraft.item.Item
import net.minecraft.loot.LootTable
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.predicate.entity.EntityPredicates
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Box
import net.minecraft.util.math.Direction
import net.minecraft.world.World


object ZombieuniteOre: NastyOre("zombieunite") {

    override fun drops(): LootTable.Builder =
        BlockLootTableGenerator.dropsWithSilkTouch(oreBlock.block, ItemEntry.builder(Blocks.ZOMBIE_HEAD))

    fun hardness(world: World, pos: BlockPos): Float {
        val zombies = world.getOtherEntities(null, Box(
            pos.add(10, 0, 10),
            pos.add(-10, 0, -10),
        )) { entity -> entity is ZombieEntity }

        return if (zombies.size < 10) -1.0F else 3.0F
    }
}