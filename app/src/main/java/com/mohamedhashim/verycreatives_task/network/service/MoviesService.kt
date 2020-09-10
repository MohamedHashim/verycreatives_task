package com.mohamedhashim.verycreatives_task.network.service

import com.mohamedhashim.verycreatives_task.data.response.PopularMoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Mohamed Hashim on 9/7/2020.
 */
interface MoviesService {

    @GET("movie/popular")
    fun fetchPopularMovies(@Query("page") page: Int): Call<PopularMoviesResponse>

    @GET("movie/top_rated")
    fun fetchTopRatedMovies(@Query("page") page: Int): Call<PopularMoviesResponse>
}