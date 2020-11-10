package com.example.myfirstkmmsample.shared.api

import com.example.myfirstkmmsample.shared.api.response.UserData
import com.example.myfirstkmmsample.shared.api.response.UserDataResponse
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RandomUserApi {
    private val httpClient: HttpClient = ApiModule.Client.getInstance()

    // todo スレッドの切り替えを行いたい
    suspend fun getUser(callback: (UserData) -> Unit) {
        // todo エラーハンドリング
        val response: UserDataResponse = httpClient.get("https://randomuser.me/api/")
        callback(response.users.first())
    }
}