package de.terminatorng.nastyores.ore

import de.terminatorng.nastyores.util.ArmorInfo
import de.terminatorng.nastyores.util.ToolInfo
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.tag.BiomeTags
import net.minecraft.text.Text
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.intprovider.UniformIntProvider
import net.minecraft.util.registry.BuiltinRegistries
import net.minecraft.world.World
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier
import java.util.function.Predicate


object PoliteOre : NastyOre("polite") {

    private val SPAWN_BIOMES = BuiltinRegistries.BIOME.entrySet
        .filter { it.value.temperature < 0.15F }
        .map { it.key }

    override fun hasItem() = true
    override fun hasBlock() = true
    override fun hasTools() = true
    override fun hasArmor() = true

    override fun armorInfo(): ArmorInfo = ArmorInfo(8, intArrayOf(2, 4, 3, 1), 8)
    override fun toolInfo(): ToolInfo = ToolInfo(1, 200, 5.0F, 2.0F, 15)

    override fun oreFactory(settings: FabricBlockSettings) = object: OreBlock(settings) {
        override fun onBreak(world: World?, pos: BlockPos?, state: BlockState?, player: PlayerEntity?) {
            super.onBreak(world, pos, state, player)
            world ?: return


            if (!world.isClient)
                player?.sendMessage(Text.translatable("badores.polite.mined"))
        }
    }


    override fun selectedBiomes(): Predicate<BiomeSelectionContext> = BiomeSelectors.includeByKey(SPAWN_BIOMES)
    override fun countPlacement(): CountPlacementModifier = CountPlacementModifier.of(UniformIntProvider.create(4, 8))

    // fun onToolMine(type: ToolType?, player: EntityPlayer?, world: World?, x: Int, y: Int, z: Int, side: Side) {
    //     if (side.isServer()) {
    //         BadOres.network.sendTo(PacketRandomTranslation("badores.polite.tool"), player as EntityPlayerMP?)
    //     }
    // }

    fun onToolEntityAttack(
        world: World,
    ) {

            // BadOres.network.sendTo(PacketRandomTranslation("badores.polite.attack"), player as EntityPlayerMP?)
    }

    fun onArmorAttacked(

    ) {
        // if (side.isServer()) {
            // BadOres.network.sendTo(PacketRandomTranslation("badores.polite.defend"), player as EntityPlayerMP?)
        // }
    }
}