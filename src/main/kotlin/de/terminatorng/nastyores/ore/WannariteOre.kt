package de.terminatorng.nastyores.ore

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.entity.EntityType
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTable
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.function.SetDamageLootFunction
import net.minecraft.loot.provider.number.UniformLootNumberProvider
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World




object WannariteOre: INastyOreSettings {

    override fun drops(ore: Block, item: Item?): LootTable.Builder =
        LootTable.builder()
            .pool(LootPool.builder()
                .with(ItemEntry.builder(Items.CARROT_ON_A_STICK)
                    .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.0F, Items.CARROT_ON_A_STICK.maxDamage / 2.0F)))))

    override fun oreFactory(settings: FabricBlockSettings) = object: OreBlock(settings) {
        override fun onBreak(world: World?, pos: BlockPos?, state: BlockState?, player: PlayerEntity?) {
            super.onBreak(world, pos, state, player)
            world ?: return
            pos ?: return

            val pig = EntityType.PIG.create(world)!!
            pig.refreshPositionAfterTeleport(
                pos.x + 0.5,
                pos.y + 0.5,
                pos.z + 0.5)
            pig.saddle(null)
            world.spawnEntity(pig)
            pig.playAmbientSound()
        }
    }
}