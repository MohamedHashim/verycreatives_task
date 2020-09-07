package com.mohamedhashim.verycreatives_task.network.service

import com.mohamedhashim.verycreatives_task.data.response.PopularMoviesResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Mohamed Hashim on 9/7/2020.
 */
interface MoviesService {

    @GET("movie/popular")
    fun fetchPopularMovies(): Call<PopularMoviesResponse>
}