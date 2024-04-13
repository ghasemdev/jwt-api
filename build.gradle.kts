plugins {
    alias(libs.plugins.kotlin.jvm)
    application
    alias(libs.plugins.kotlin.serialization)
}

group = "com.parsuomash"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

dependencies {
    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    testImplementation(libs.kotlinx.coroutines.test)

    // Serialization
    implementation(libs.kotlinx.serialization)

    // Exposed
    implementation(libs.bundles.exposed)

    // Database Tools
    implementation(libs.postgresql)
    implementation(libs.flyway)
    implementation(libs.hikari)

    // Redis
    implementation(libs.lettuce.core)
    implementation(libs.lettucemod)

    // Koin
    implementation(libs.koin.ktor)
    testImplementation(libs.koin.test)

    // Ktor
    implementation(libs.bundles.ktor)
    implementation(libs.logback)
    testImplementation(libs.ktor.server.tests)

    testImplementation(libs.kotlin.test.unit)
    testImplementation(libs.truth)
    testImplementation(libs.mockk)
}
