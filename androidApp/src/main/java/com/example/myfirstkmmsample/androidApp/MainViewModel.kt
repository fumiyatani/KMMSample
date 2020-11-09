package com.example.myfirstkmmsample.androidApp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myfirstkmmsample.shared.UserRepository
import com.example.myfirstkmmsample.shared.api.response.UserData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(private val userRepository: UserRepository) : ViewModel() {
    init {
        // todo ViewModelのktxを使う
        GlobalScope.launch(Dispatchers.IO) {
            _userDataLiveData.postValue(State.Loading)
            userRepository.getUserData({
                _userDataLiveData.postValue(State.Success(it))
            }, {
                // todo エラーハンドリング
                _userDataLiveData.postValue(State.Failure(Exception("なんかダメだった")))
            })
        }
    }

    private val _userDataLiveData = MutableLiveData<State<UserData>>()
    val userDataLiveData: LiveData<State<UserData>> = _userDataLiveData
}

class MainViewModelFactory(private val userRepository: UserRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(userRepository) as T
        } else {
            throw IllegalArgumentException("unknown view model")
        }

    }
}