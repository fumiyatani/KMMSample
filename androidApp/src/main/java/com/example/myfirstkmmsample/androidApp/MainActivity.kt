package com.example.myfirstkmmsample.androidApp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstkmmsample.shared.RandomUserApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch(Dispatchers.IO) {
            RandomUserApi().getUser {
                Log.d(TAG, "onCreate: $it")
            }
        }
    }

    companion object {
        const val TAG = "MainActivity"
    }
}
