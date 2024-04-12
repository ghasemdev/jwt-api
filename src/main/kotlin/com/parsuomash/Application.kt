package com.parsuomash

import com.parsuomash.plugins.configureHTTP
import com.parsuomash.plugins.configureMonitoring
import com.parsuomash.plugins.configureRouting
import com.parsuomash.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureMonitoring()
    configureHTTP()
    configureRouting()
}
