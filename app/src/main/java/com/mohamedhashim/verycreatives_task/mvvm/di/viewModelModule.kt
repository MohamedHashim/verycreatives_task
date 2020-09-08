package com.mohamedhashim.verycreatives_task.mvvm.di

import com.mohamedhashim.verycreatives_task.mvvm.ui.details.MovieDetailsViewModel
import com.mohamedhashim.verycreatives_task.mvvm.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Mohamed Hashim on 9/7/2020.
 */
val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { MovieDetailsViewModel() }
}