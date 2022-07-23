package de.terminatorng.nastyores.util

import net.minecraft.util.collection.DataPool
import net.minecraft.util.math.intprovider.ConstantIntProvider
import net.minecraft.util.math.intprovider.IntProvider
import net.minecraft.util.math.intprovider.WeightedListIntProvider

class WeightedOneIntProvider(chance: Int) : WeightedListIntProvider(createWeightedList(chance)) {
    companion object {
        private fun createWeightedList(chance: Int): DataPool<IntProvider> = when {
            chance > 0 -> DataPool.builder<IntProvider>()
                .add(ConstantIntProvider.ZERO, chance - 1)
                .add(ConstantIntProvider.create(1), 1)
                .build()
            chance == 0 -> DataPool.of(ConstantIntProvider.ZERO)
            else -> throw IllegalArgumentException("chance cannot be negative: $chance")
        }

    }
}