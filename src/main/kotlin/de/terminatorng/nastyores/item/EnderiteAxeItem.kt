package de.terminatorng.nastyores.item

import de.terminatorng.nastyores.item.NastyOresAxeItem
import de.terminatorng.nastyores.ore.CrashiumOre
import de.terminatorng.nastyores.ore.EnderiteOre
import net.minecraft.block.BlockState
import net.minecraft.entity.LivingEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.ToolMaterial
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class EnderiteAxeItem(material: ToolMaterial, settings: Settings) : NastyOresAxeItem(material, settings) {

    override fun postHit(stack: ItemStack?, target: LivingEntity?, attacker: LivingEntity?): Boolean {
        EnderiteOre.teleportEntity(target)

        return super.postHit(stack, target, attacker)
    }

    override fun postMine(
        stack: ItemStack?,
        world: World?,
        state: BlockState?,
        pos: BlockPos?,
        miner: LivingEntity?
    ): Boolean {
        if (world!!.random.nextInt(5) == 0) EnderiteOre.teleportEntity(miner, pos)

        return super.postMine(stack, world, state, pos, miner)
    }
}