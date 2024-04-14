package com.parsuomash

import com.parsuomash.plugins.configureHTTP
import com.parsuomash.plugins.configureMonitoring
import com.parsuomash.plugins.configureRouting
import com.parsuomash.plugins.configureSerialization
import com.redis.lettucemod.RedisModulesClient
import io.ktor.server.application.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.lettuce.core.ExperimentalLettuceCoroutinesApi
import io.lettuce.core.api.coroutines
import kotlinx.coroutines.flow.collectLatest

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureMonitoring()
    configureHTTP()
    configureRouting()
    redis()
}

@OptIn(ExperimentalLettuceCoroutinesApi::class)
private fun Application.redis() {
    val redisClient = RedisModulesClient.create("redis://localhost:6379")
    val redisConnection = redisClient.connect()

    val redisSyncCommand = redisConnection.sync()
    val redisCoroutineCommand = redisConnection.coroutines()

    routing {
        route("/redis") {
            get("/keys") {
                val keys = mutableListOf<String>()
                val keysObservable = redisCoroutineCommand.keys("*")
                keysObservable.collectLatest { keys += it }
                call.respondText(keys.toString())
            }
            get("/get") {
                val key = call.parameters["key"] ?: return@get
                val value = redisCoroutineCommand.get(key)
                call.respondText(value.toString())
            }
        }
    }
}
