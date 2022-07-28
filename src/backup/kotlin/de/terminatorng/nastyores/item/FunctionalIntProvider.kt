package de.terminatorng.nastyores.item

import net.minecraft.util.math.intprovider.IntProvider
import net.minecraft.util.math.intprovider.IntProviderType
import net.minecraft.util.math.intprovider.UniformIntProvider
import net.minecraft.util.math.random.Random

class FunctionalIntProvider(private val min: Int, private val max: Int, private val function: java.util.function.Function<Random?, Int>): IntProvider() {
    override fun get(random: Random?) = function.apply(random)

    override fun getMin() = min

    override fun getMax() = max

    override fun getType(): IntProviderType<UniformIntProvider> = IntProviderType.UNIFORM
}