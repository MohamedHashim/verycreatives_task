package com.mohamedhashim.verycreatives_task

import android.app.Application
import com.mohamedhashim.verycreatives_task.mvvm.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Mohamed Hashim on 9/7/2020.
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(networkModule)
        }
    }
}
