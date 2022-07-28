package de.terminatorng.nastyores.item

import de.terminatorng.nastyores.item.NastyOresPickaxeItem
import de.terminatorng.nastyores.ore.EnderiteOre
import de.terminatorng.nastyores.ore.PoliteOre
import net.minecraft.block.BlockState
import net.minecraft.entity.LivingEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.ToolMaterial
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.Text
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class PolitePickaxeItem(material: ToolMaterial, settings: Settings) : NastyOresPickaxeItem(material, settings) {

    override fun postHit(stack: ItemStack?, target: LivingEntity?, attacker: LivingEntity?): Boolean {
        PoliteOre.sendMessage(PoliteOre.TOOL_ATTACK_KEY, target)
        return super.postHit(stack, target, attacker)
    }

    override fun postMine(
        stack: ItemStack?,
        world: World?,
        state: BlockState?,
        pos: BlockPos?,
        miner: LivingEntity?
    ): Boolean {
        PoliteOre.sendMessage(PoliteOre.TOOL_MINE_KEY, miner)
        return super.postMine(stack, world, state, pos, miner)
    }

}