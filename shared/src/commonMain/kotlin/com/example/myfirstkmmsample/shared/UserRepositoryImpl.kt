package com.example.myfirstkmmsample.shared

import com.example.myfirstkmmsample.shared.api.RandomUserApi
import com.example.myfirstkmmsample.shared.api.response.UserData

interface UserRepository {
    // todo エラーハンドリング
    suspend fun getUserData(callback: (UserData) -> Unit, error: (String) -> Unit)
}

class UserRepositoryImpl : UserRepository {
    private val randomUserApi: RandomUserApi = RandomUserApi()

    override suspend fun getUserData(callback: (UserData) -> Unit, error: (String) -> Unit) {
        // todo DB確認後通信してユーザー情報を取得する
        randomUserApi.getUser {
            // todo エラーハンドリング
            callback(it)
            // todo DB登録処理
        }
    }
}