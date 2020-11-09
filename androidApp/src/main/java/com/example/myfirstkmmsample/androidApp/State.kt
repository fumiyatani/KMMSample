package com.example.myfirstkmmsample.androidApp

sealed class State<out T> {
    class Success<T>(val data: T) : State<T>()
    class Failure(val throwable: Throwable): State<Nothing>()
    object Loading: State<Nothing>()
}