package de.terminatorng.nastyores.item

import de.terminatorng.nastyores.item.NastyOresShovelItem
import de.terminatorng.nastyores.ore.PoliteOre
import de.terminatorng.nastyores.ore.SmiteOre
import net.minecraft.block.BlockState
import net.minecraft.entity.LivingEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.ToolMaterial
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class SmiteShovelItem(material: ToolMaterial, settings: Settings) : NastyOresShovelItem(material, settings) {

    override fun postHit(stack: ItemStack?, target: LivingEntity?, attacker: LivingEntity?): Boolean {
        attacker!!

        if (attacker.random.nextInt(2) == 0)
            SmiteOre.spawnLightning(attacker.world, if (attacker.random.nextBoolean()) attacker else target)

        return super.postHit(stack, target, attacker)
    }

}