package com.mohamedhashim.verycreatives_task.common_ui.extensions

import android.content.Context
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Mohamed Hashim on 9/8/2020.
 */
fun Context.toast(message: String) =
    Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()

fun hidActionBar(activity: AppCompatActivity) {
    activity.requestWindowFeature(Window.FEATURE_NO_TITLE)
    activity.supportActionBar?.hide()
}