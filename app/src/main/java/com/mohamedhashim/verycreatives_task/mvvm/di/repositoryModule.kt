package com.mohamedhashim.verycreatives_task.mvvm.di

import com.mohamedhashim.verycreatives_task.mvvm.repository.MoviesRepository
import org.koin.dsl.module

/**
 * Created by Mohamed Hashim on 9/7/2020.
 */
val repositoryModule = module {
    single { MoviesRepository(get()) }
}