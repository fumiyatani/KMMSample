package com.example.myfirstkmmsample.androidApp

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstkmmsample.shared.Greeting
import com.example.myfirstkmmsample.shared.RandomUserApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)

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
