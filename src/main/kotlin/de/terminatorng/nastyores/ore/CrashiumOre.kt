package de.terminatorng.nastyores.ore

import de.terminatorng.nastyores.id
import net.minecraft.entity.Entity
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.server.MinecraftServer
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.Text
import net.minecraft.world.World


object CrashiumOre {
    private const val CRASH_PROBABILITY = 5

    private fun schedule(server: MinecraftServer?, ticks: Long, callback: () -> Unit) =
        server
            ?.saveProperties
            ?.mainWorldProperties
            ?.scheduledEvents
            ?.setEvent(id("crashium").toString(), ticks) { _, _, _ -> callback() }

    fun doCrash(player: Entity?) {
        player!!

        if (player !is ServerPlayerEntity) return

        player.sendMessage(Text.translatable("nastyores.crashium.precrash"))

        schedule(player.server, 80 * 20) {
            if (player.random.nextInt(CRASH_PROBABILITY) == 0) {
                player.sendMessage(Text.translatable("nastyores.crashium.crash"))

                schedule(player.server, 5 * 20) {
                    throw RuntimeException("Crashium!")
                }
            } else {
                player.sendMessage(Text.translatable("nastyores.crashium.nocrash"))
            }
        }
    }

    fun onArmorAttacked(
        // type: ArmorType?,
        player: PlayerEntity,
        damageSource: DamageSource?,
        amount: Float,
        world: World?,
        // side: Side
    ) {
        //doCrash(player, Random.create())
    }
}