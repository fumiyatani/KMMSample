package com.example.myfirstkmmsample.shared

import io.ktor.client.*
import io.ktor.client.request.*

class RandomUserApi {
    /**
     * Ktorで使用するHTTPエンジンを選択する必要があるらしい
     * 以下のようにからのコンストラクタを渡すと勝手にエンジンの一つを洗濯してくれるらしい
     * CIO, OkHttp etc
     */
    private val httpClient: HttpClient = HttpClient()

    suspend fun getUser(callback: (String) -> Unit) {
        // Client.リクエストメソッド(URL)
        val response: String = httpClient.get("https://randomuser.me/api/")
        print(response)
        callback(response)
    }
}