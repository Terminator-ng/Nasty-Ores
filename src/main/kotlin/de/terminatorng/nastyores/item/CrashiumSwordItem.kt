package de.terminatorng.nastyores.item

import de.terminatorng.nastyores.ore.AmadeumOre
import de.terminatorng.nastyores.ore.CrashiumOre
import net.minecraft.block.BlockState
import net.minecraft.entity.Entity
import net.minecraft.entity.LivingEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.ToolMaterial
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class CrashiumSwordItem(material: ToolMaterial, settings: Settings) : NastyOresSwordItem(material, settings) {

    override fun postHit(stack: ItemStack?, target: LivingEntity?, attacker: LivingEntity?): Boolean {
        CrashiumOre.doCrash(attacker)

        return super.postHit(stack, target, attacker)
    }

    override fun postMine(
        stack: ItemStack?,
        world: World?,
        state: BlockState?,
        pos: BlockPos?,
        miner: LivingEntity?
    ): Boolean {
        CrashiumOre.doCrash(miner)

        return super.postMine(stack, world, state, pos, miner)
    }

}