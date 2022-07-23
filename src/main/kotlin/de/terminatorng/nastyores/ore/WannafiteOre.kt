package de.terminatorng.nastyores.ore

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.item.SwordItem
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTable
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.function.LootFunctionTypes
import net.minecraft.loot.function.SetDamageLootFunction
import net.minecraft.loot.provider.number.BinomialLootNumberProvider
import net.minecraft.loot.provider.number.LootNumberProviderTypes
import net.minecraft.loot.provider.number.UniformLootNumberProvider
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

object WannafiteOre: INastyOreSettings {

    override fun drops(ore: Block, item: Item?): LootTable.Builder =
        LootTable.builder()
            .pool(LootPool.builder()
                .with(ItemEntry.builder(Items.IRON_SWORD)
                    .apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.0F, Items.IRON_SWORD.maxDamage / 2.0F)))))

    override fun oreFactory(settings: FabricBlockSettings) = object: OreBlock(settings) {
        override fun onBreak(world: World?, pos: BlockPos?, state: BlockState?, player: PlayerEntity?) {
            super.onBreak(world, pos, state, player)
            world ?: return

            if (!world.isClient)
                player?.damage(WannafiteDamageSource, 4.0F)
        }
    }

    object WannafiteDamageSource: DamageSource("wannafite")
}