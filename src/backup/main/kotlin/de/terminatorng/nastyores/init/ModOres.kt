package de.terminatorng.nastyores.init

import de.terminatorng.nastyores.ore.*

enum class ModOres(val nastyOre: NastyOre) {

    AMADEUM_ORE(AmadeumOre),
    APPETITE_ORE(AppetiteOre),
    BALANCIUM_ORE(BalanciumOre),
    BARELY_GENERITE_ORE(BarelyGeneriteOre),
    BREAKIUM_ORE(BreakiumOre),
    CRAPPIUM_ORE(CrappiumOre),
    CRASHIUM_ORE(CrashiumOre),
    ENDERITE_ORE(EnderiteOre),
    EXPLODEMITE_ORE(ExplodemiteOre),
    GHOSTIUM_ORE(GhostiumOre),
    IDLIKEABITE_ORE(IdlikeabiteOre),
    IWONTFITE_ORE(IwontfiteOre),
    KAKKARITE_ORE(KakkariteOre),
    KILLIUM_ORE(KilliumOre),
    LITE_ORE(LiteOre),
    LOOKSLIKEDIAMONDIUM_ORE(LookslikediamondiumOre),
    MARMITE_ORE(MarmiteOre),
    METEORITE_ORE(MeteoriteOre),
    MISLEADIUM_ORE(MisleadiumOre),
    MOVIUM_ORE(MoviumOre),
    NOPIUM_ORE(NopiumOre),
    NOSLEEPTONITE_ORE(NosleeptoniteOre),
    PAINTITWHITE_ORE(PaintitwhiteOre),
    PANDAEMONIUM_ORE(PandaemoniumOre),
    POLITE_ORE(PoliteOre),
    SHIFTIUM_ORE(ShiftiumOre),
    SMITE_ORE(SmiteOre),
    STONIUM_ORE(StoniumOre),
    STREETSCUM_ORE(StreetscumOre),
    TAUNTUM_ORE(TauntumOre),
    UNOBTAINIUM_ORE(UnobtainiumOre),
    USELESSIUM_ORE(UselessiumOre),
    WANNAFITE_ORE(WannafiteOre),
    WANNARITE_ORE(WantariteOre),
    WEBSITE_ORE(WebsiteOre),
    ZOMBIEUNITE_ORE(ZombieuniteOre);

    companion object {
        fun init() {
            values().forEach { it.nastyOre.register() }
        }
    }
}