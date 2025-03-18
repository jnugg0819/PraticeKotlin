plugins {
    kotlin("jvm") version "2.0.20"
}

group = "com.olio.gym.fit"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17)) // Set this to match your Java version
}

kotlin {
    jvmToolchain(17) // Or set to the version you're using
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17" // Match this with the Java target version
    }
}

tasks.test {
    useJUnitPlatform()
}