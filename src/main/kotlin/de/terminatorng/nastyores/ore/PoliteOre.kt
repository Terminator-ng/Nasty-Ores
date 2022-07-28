package de.terminatorng.nastyores.ore

import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags
import net.minecraft.entity.LivingEntity
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.Text
import net.minecraft.util.registry.BuiltinRegistries


object PoliteOre {

    const val TOOL_ATTACK_KEY = "nastyores.polite.attack"
    const val TOOL_MINE_KEY = "nastyores.polite.tool"

    val SPAWN_BIOMES = BuiltinRegistries.BIOME
        .iterateEntries(ConventionalBiomeTags.CLIMATE_COLD)
        .map { it.key.orElseThrow() }

    fun sendMessage(key: String, entity: LivingEntity?) {
        entity!!

        if (entity is ServerPlayerEntity) entity.sendMessage(Text.translatable(key))
    }

    fun onArmorAttacked(

    ) {
        // if (side.isServer()) {
            // BadOres.network.sendTo(PacketRandomTranslation("badores.polite.defend"), player as EntityPlayerMP?)
        // }
    }
}