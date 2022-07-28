package de.terminatorng.nastyores.init

import de.terminatorng.nastyores.ore.*

enum class ModOres(val nastyOre: NastyOre) {

    AMADEUM_ORE(NastyOre("amadeum", AmadeumOre)),
    APPETITE_ORE(NastyOre("appetite", AppetiteOre)),
    BALANCIUM_ORE(NastyOre("balancium", BalanciumOre)),
    BARELY_GENERITE_ORE(NastyOre("barely_generite", BarelyGeneriteOre)),
    BREAKIUM_ORE(NastyOre("breakium", BreakiumOre)),
    CRAPPIUM_ORE(NastyOre("crappium", CrappiumOre)),
    CRASHIUM_ORE(NastyOre("crashium", CrashiumOre)),
    ENDERITE_ORE(NastyOre("enderite", EnderiteOre)),
    EXPLODEMITE_ORE(NastyOre("explodemite", ExplodemiteOre)),
    GHOSTIUM_ORE(NastyOre("ghostium", GhostiumOre)),
    IDLIKEABITE_ORE(NastyOre("idlikeabite", IdlikeabiteOre)),
    IWONTFITE_ORE(NastyOre("iwontfite", IwontfiteOre)),
    KAKKARITE_ORE(NastyOre("kakkarite", KakkariteOre)),
    KILLIUM_ORE(NastyOre("killium", KilliumOre)),
    LITE_ORE(NastyOre("lite", LiteOre)),
    LOOKSLIKEDIAMONDIUM_ORE(NastyOre("lookslikediamondium", LookslikediamondiumOre)),
    MARMITE_ORE(NastyOre("marmite", MarmiteOre)),
    METEORITE_ORE(NastyOre("meteorite", MeteoriteOre)),
    MISLEADIUM_ORE(NastyOre("misleadium", MisleadiumOre)),
    MOVIUM_ORE(NastyOre("movium", MoviumOre)),
    NOPIUM_ORE(NastyOre("nopium", NopiumOre)),
    NOSLEEPTONITE_ORE(NastyOre("nosleeptonite", NosleeptoniteOre)),
    PAINTITWHITE_ORE(NastyOre("paintitwhite", PaintitwhiteOre)),
    PANDAEMONIUM_ORE(NastyOre("pandaemonium", PandaemoniumOre)),
    POLITE_ORE(NastyOre("polite", PoliteOre)),
    SHIFTIUM_ORE(NastyOre("shiftium", ShiftiumOre)),
    SMITE_ORE(NastyOre("smite", SmiteOre)),
    STONIUM_ORE(NastyOre("stonium", StoniumOre)),
    STREETSCUM_ORE(NastyOre("streetscum", StreetscumOre)),
    TAUNTUM_ORE(NastyOre("tauntum", TauntumOre)),
    UNOBTAINIUM_ORE(NastyOre("unobtainium", UnobtainiumOre)),
    USELESSIUM_ORE(NastyOre("uselessium", UselessiumOre)),
    WANNAFITE_ORE(NastyOre("wannafite", WannafiteOre)),
    WANNARITE_ORE(NastyOre("wantarite", WantariteOre)),
    WEBSITE_ORE(NastyOre("website", WebsiteOre)),
    ZOMBIEUNITE_ORE(NastyOre("zombieunite", ZombieuniteOre));

    companion object {
        fun init() {
            values().forEach { it.nastyOre.register() }
        }
    }
}