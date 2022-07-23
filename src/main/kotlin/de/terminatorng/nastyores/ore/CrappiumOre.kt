package de.terminatorng.nastyores.ore

import net.minecraft.world.World
import net.minecraft.world.gen.YOffset


object CrappiumOre: INastyOreSettings {

    override fun hasItem() = true
    override fun hasTools() = true
    override fun hasArmor() = true

    // fun getToolInfo(): ToolInfo? {
    //     return ToolInfo(0, 1, 2.0f, 0.0f, 15)
    // }

    // fun getArmorInfo(): ArmorInfo? {
    //     return ArmorInfo(1, intArrayOf(1, 1, 1, 1), 0)
    // }

    override fun veinsPerChunk() = 8
    override fun genMin(): YOffset = YOffset.fixed(40)
    override fun genMax(): YOffset = YOffset.fixed(128)
    override fun veinSize() = 8
}