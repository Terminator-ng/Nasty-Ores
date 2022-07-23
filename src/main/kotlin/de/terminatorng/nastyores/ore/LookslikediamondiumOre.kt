package de.terminatorng.nastyores.ore


object LookslikediamondiumOre: INastyOreSettings {

    // fun dropsIngotDirectly() = true
    override fun hasItem() = true
    override fun hasBlock() = true
    override fun hasTools() = true
    override fun hasArmor() = true

    // fun getToolInfo(): ToolInfo? {
    //     return ToolInfo(0, 1, 2.0f, 0.0f, 0)
    // }

    // fun getArmorInfo(): ArmorInfo? {
    //     return ArmorInfo(1, intArrayOf(1, 1, 1, 1), 0)
    // }
}