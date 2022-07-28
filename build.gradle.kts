plugins {
    id("fabric-loom")
    val kotlinVersion: String by System.getProperties()
    kotlin("jvm").version(kotlinVersion)
}

base {
    val archivesBaseName: String by project
    archivesName.set(archivesBaseName)
}

val modVersion: String by project
version = modVersion
val mavenGroup: String by project
group = mavenGroup

repositories {
    maven { url = uri("https://maven.shedaniel.me") }
    maven { url = uri("https://maven.wispforest.io") }
    maven { url = uri("https://cursemaven.com") }
    maven { url = uri("https://maven.blamejared.com") }
}

dependencies {
    val minecraftVersion: String by project
    minecraft("com.mojang", "minecraft", minecraftVersion)
    val yarnMappings: String by project
    mappings("net.fabricmc", "yarn", yarnMappings, null, "v2")
    val loaderVersion: String by project
    modImplementation("net.fabricmc", "fabric-loader", loaderVersion)
    val fabricVersion: String by project
    modImplementation("net.fabricmc.fabric-api", "fabric-api", fabricVersion)
    val fabricKotlinVersion: String by project
    modImplementation("net.fabricmc", "fabric-language-kotlin", fabricKotlinVersion)

    val reiVersion: String by project
    modCompileOnly("me.shedaniel", "RoughlyEnoughItems-api-fabric", reiVersion)
    modRuntimeOnly("me.shedaniel", "RoughlyEnoughItems-fabric", reiVersion)
    val topVersion: String by project
    //implementation("mcjty.theoneprobe", "theoneprobe-fabric", topVersion)
    val patchouliVersion: String by project
    modImplementation("vazkii.patchouli", "Patchouli", patchouliVersion)
}

tasks {
    val javaVersion = JavaVersion.VERSION_17
    withType<JavaCompile> {
        options.encoding = "UTF-8"
        sourceCompatibility = javaVersion.toString()
        targetCompatibility = javaVersion.toString()
        options.release.set(javaVersion.toString().toInt())
    }
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions { jvmTarget = javaVersion.toString() }
        sourceCompatibility = javaVersion.toString()
        targetCompatibility = javaVersion.toString()
    }
    jar { from("LICENSE") { rename { "${it}_${base.archivesName}" } } }
    processResources {
        inputs.property("version", project.version)
        filesMatching("fabric.mod.json") { expand(mutableMapOf("version" to project.version)) }
    }
    java {
        toolchain { languageVersion.set(JavaLanguageVersion.of(javaVersion.toString())) }
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
        withSourcesJar()
    }
}

val generatedResources = "src/generated/resources"

sourceSets.main {
    resources {
        srcDir(generatedResources)
    }
}

loom {
    accessWidenerPath.set(file("src/main/resources/nastyores.accesswidener"))

    runs {
        create("Data Generation") {
            server()
            vmArg("-Dfabric-api.datagen")
            vmArg("-Dfabric-api.datagen.output-dir=${file(generatedResources)}")
        }
    }
}

