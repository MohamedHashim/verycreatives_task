package com.mohamedhashim.verycreatives_task.mvvm.di

import androidx.room.Room
import com.mohamedhashim.verycreatives_task.R
import com.mohamedhashim.verycreatives_task.data.database.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Created by Mohamed Hashim on 9/8/2020.
 */
val persistenceModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(), AppDatabase::class.java,
            androidApplication().getString(R.string.database)
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().movieDao() }
}
