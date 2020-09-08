package com.mohamedhashim.verycreatives_task.mvvm.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mohamedhashim.verycreatives_task.R
import com.mohamedhashim.verycreatives_task.common_ui.extensions.hidActionBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hidActionBar(this)
        setContentView(R.layout.activity_main)
    }
}