package com.example.myfirstkmmsample.androidApp

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.myfirstkmmsample.shared.UserRepositoryImpl

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userImageView: ImageView = findViewById(R.id.user_image_view)
        val fullNameTextView: TextView = findViewById(R.id.full_name_text_view)
        val progressBar: ProgressBar = findViewById(R.id.progress_bar)

        val viewModel: MainViewModel = ViewModelProvider(this, MainViewModelFactory(
            UserRepositoryImpl()
        ))[MainViewModel::class.java]

        viewModel.userDataLiveData.observe(this) { state ->
            when (state) {
                is State.Success -> {
                    with(state) {
                        userImageView.load(data.picture.large)
                        fullNameTextView.text = state.data.name.getFullName()
                    }
                    progressBar.visibility = View.GONE
                }
                is State.Failure -> {
                    Toast.makeText(this,"エラーが発生しました。", Toast.LENGTH_LONG).show()
                    progressBar.visibility = View.GONE
                }
                State.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }
            }
        }
    }

    companion object {
        @Suppress("unused")
        const val TAG = "MainActivity"
    }
}
