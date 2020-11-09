package com.example.myfirstkmmsample.shared.api

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import okhttp3.logging.HttpLoggingInterceptor

class ApiModule private constructor() {
    object Client {
        fun getInstance(): HttpClient {
            return HttpClient(OkHttp) {
                engine {
                    // todo BuildCongigで切り替える
                    val loggingInterceptor = HttpLoggingInterceptor()
                    addInterceptor(loggingInterceptor)
                }
            }
        }
    }
}