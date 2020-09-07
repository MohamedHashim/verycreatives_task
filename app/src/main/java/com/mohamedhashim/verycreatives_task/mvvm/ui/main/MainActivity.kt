package com.mohamedhashim.verycreatives_task.mvvm.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mohamedhashim.verycreatives_task.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.viewModel.moviesListLiveData.observe(this) {if(it.isNotEmpty()) response.text = it[0].overview }
        this.viewModel.toastLiveData.observe(this) {Toast.makeText(this,it.toString(),Toast.LENGTH_SHORT) }

    }
}