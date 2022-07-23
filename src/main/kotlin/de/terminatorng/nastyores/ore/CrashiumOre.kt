package de.terminatorng.nastyores.ore

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.OreBlock
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.text.Text
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.random.Random
import net.minecraft.world.World


object CrashiumOre: INastyOreSettings {
    private const val CRASH_PROBABILITY = 5

    override fun hasItem() = true
    override fun hasTools() = true
    override fun hasArmor() = true

    override fun oreFactory(settings: FabricBlockSettings) = object: OreBlock(settings) {
        override fun onBreak(world: World?, pos: BlockPos?, state: BlockState?, player: PlayerEntity?) {
            super.onBreak(world, pos, state, player)
            world?.random ?: return
            player ?: return

            doCrash(player, world.random)
        }
    }

    override fun blockFactory(settings: FabricBlockSettings) = object: Block(settings) {
        override fun onBreak(world: World?, pos: BlockPos?, state: BlockState?, player: PlayerEntity?) {
            super.onBreak(world, pos, state, player)
            world?.random ?: return
            player ?: return

            doCrash(player, world.random)
        }
    }

    // fun onArmorTick(type: ArmorType?, player: EntityPlayer?, world: World?, side: Side?, slot: Int, stack: ItemStack?) {
    //     if (rand.nextInt(800) === 0) doCrash(player, side)
    // }

    // fun onToolMine(type: ToolType?, player: EntityPlayer, world: World?, x: Int, y: Int, z: Int, side: Side) {
    //     doCrash(player, side)
    // }

    fun onToolEntityAttack(
        // type: ToolType?,
        player: PlayerEntity,
        // target: EntityLivingBase?,
        world: World?,
        // side: Side
    ) {
        doCrash(player, Random.create())
    }

    private fun doCrash(player: PlayerEntity, random: Random) {
        player.sendMessage(Text.translatable("badores.crashium.precrash"))

        if (random.nextInt(CRASH_PROBABILITY) == 0) {
            player.sendMessage(Text.translatable("badores.crashium.crash"))
            throw RuntimeException("Crashium!")
        } else {
            player.sendMessage(Text.translatable("badores.crashium.crash"))
        }
    }

    // fun getToolInfo(): ToolInfo? {
    //     return ToolInfo(2, 250, 8.0f, 2.0f, 8)
    // }



    // fun getArmorInfo(): ArmorInfo? {
    //     return ArmorInfo(8, intArrayOf(2, 7, 5, 2), 9)
    // }

     fun onArmorAttacked(
        // type: ArmorType?,
        player: PlayerEntity,
        damageSource: DamageSource?,
        amount: Float,
        world: World?,
        // side: Side
    ) {
        doCrash(player, Random.create())
    }
}