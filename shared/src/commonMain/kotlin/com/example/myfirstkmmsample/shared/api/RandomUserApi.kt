package com.example.myfirstkmmsample.shared.api

import com.example.myfirstkmmsample.shared.api.response.UserData
import com.example.myfirstkmmsample.shared.api.response.UserDataResponse
import io.ktor.client.*
import io.ktor.client.request.*

class RandomUserApi {
    private val httpClient: HttpClient = ApiModule.Client.getInstance()

    suspend fun getUser(callback: (UserData) -> Unit) {
        // todo エラーハンドリング
        val response: UserDataResponse = httpClient.get("https://randomuser.me/api/")
        callback(response.users.first())
    }
}