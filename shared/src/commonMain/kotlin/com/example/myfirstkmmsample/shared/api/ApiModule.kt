package com.example.myfirstkmmsample.shared.api

import io.ktor.client.HttpClient
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import kotlinx.serialization.json.Json

class ApiModule private constructor() {
    object Client {
        fun getInstance(): HttpClient {
            val jsonConf = Json {
                isLenient = true
                ignoreUnknownKeys = true
            }
            return HttpClient {
                install(JsonFeature) {
                    serializer = KotlinxSerializer(jsonConf)
                }
            }
        }
    }
}