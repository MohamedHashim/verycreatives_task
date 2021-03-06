package com.mohamedhashim.verycreatives_task.network.client

import com.mohamedhashim.verycreatives_task.ApiResponse
import com.mohamedhashim.verycreatives_task.data.response.PopularMoviesResponse
import com.mohamedhashim.verycreatives_task.network.service.MoviesService
import com.mohamedhashim.verycreatives_task.network.transform

/**
 * Created by Mohamed Hashim on 9/7/2020.
 */
class MoviesClient(private val service: MoviesService) {

    fun fetchPopularMovies(
        page: Int,
        onResult: (response: ApiResponse<PopularMoviesResponse>) -> Unit
    ) {
        this.service.fetchPopularMovies(page).transform(onResult)
    }

    fun fetchTopRatedMovies(
        page: Int,
        onResult: (response: ApiResponse<PopularMoviesResponse>) -> Unit
    ) {
        this.service.fetchTopRatedMovies(page).transform(onResult)
    }
}