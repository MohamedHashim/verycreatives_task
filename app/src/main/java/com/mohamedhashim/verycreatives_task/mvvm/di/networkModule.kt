package com.mohamedhashim.verycreatives_task.mvvm.di

import com.mohamedhashim.verycreatives_task.network.EndPoint
import com.mohamedhashim.verycreatives_task.network.RequestInterceptor
import com.mohamedhashim.verycreatives_task.network.client.MoviesClient
import com.mohamedhashim.verycreatives_task.network.service.MoviesService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Mohamed Hashim on 9/7/2020.
 */
val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .baseUrl(EndPoint.TheMovieDB)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(MoviesService::class.java) }

    single { MoviesClient(get()) }
}
