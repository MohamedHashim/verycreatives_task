package com.mohamedhashim.verycreatives_task.common_ui.extensions

import android.content.Context
import android.net.ConnectivityManager


/**
 * Created by Mohamed Hashim on 9/9/2020.
 */
fun hasInternetConnected(context: Context): Boolean? {
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = cm.activeNetworkInfo
    if (activeNetwork != null)
        return activeNetwork.type == ConnectivityManager.TYPE_WIFI || activeNetwork.type == ConnectivityManager.TYPE_MOBILE
    return false
}