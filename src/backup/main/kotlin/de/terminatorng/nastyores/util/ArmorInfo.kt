package de.terminatorng.nastyores.util

data class ArmorInfo(val durability: Int, val protectionValues: IntArray, val enchantability: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ArmorInfo

        if (durability != other.durability) return false
        if (!protectionValues.contentEquals(other.protectionValues)) return false
        if (enchantability != other.enchantability) return false

        return true
    }

    override fun hashCode(): Int {
        var result = durability
        result = 31 * result + protectionValues.contentHashCode()
        result = 31 * result + enchantability
        return result
    }

}
