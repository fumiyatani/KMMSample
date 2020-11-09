package com.example.myfirstkmmsample.shared.api

import io.ktor.client.*
import io.ktor.client.request.*

class RandomUserApi {
    private val httpClient: HttpClient = ApiModule.Client.getInstance()

    suspend fun getUser(callback: (String) -> Unit) {
        val response: String = httpClient.get("https://randomuser.me/api/")
        callback(response)
    }
}