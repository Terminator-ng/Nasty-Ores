package de.terminatorng.nastyores.ore

import de.terminatorng.nastyores.util.ArmorInfo
import de.terminatorng.nastyores.util.ToolInfo
import net.minecraft.world.World
import net.minecraft.world.gen.YOffset


object CrappiumOre: NastyOre("crappium") {

    override fun hasItem() = true
    override fun hasTools() = true
    override fun hasArmor() = true
    override fun hasBlock() = true

    override fun toolInfo(): ToolInfo = ToolInfo(0, 1, 2.0F, 0.0F, 15)
    override fun armorInfo(): ArmorInfo = ArmorInfo(1, intArrayOf(1, 1, 1, 1), 0)

    override fun veinsPerChunk() = 8
    override fun genMin(): YOffset = YOffset.fixed(40)
    override fun genMax(): YOffset = YOffset.fixed(128)
    override fun veinSize() = 8
}