package com.mohamedhashim.verycreatives_task.mvvm.repository

import androidx.lifecycle.MutableLiveData
import com.mohamedhashim.verycreatives_task.ApiResponse
import com.mohamedhashim.verycreatives_task.data.entities.Movie
import com.mohamedhashim.verycreatives_task.network.client.MoviesClient
import com.mohamedhashim.verycreatives_task.network.message
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by Mohamed Hashim on 9/7/2020.
 */

class MoviesRepository constructor(
    private val movieClient: MoviesClient
) {
    suspend fun loadPopularMovies(page: Int, error: (String) -> Unit) =
        withContext(Dispatchers.IO) {
            val liveData = MutableLiveData<List<Movie>>()
            var movies = emptyList<Movie>()
            movieClient.fetchPopularMovies(page) { response ->
                when (response) {
                    is ApiResponse.Success -> {
                        response.data?.let { data ->
                            movies = data.results
                            movies.forEach { it.page = page }
                            liveData.apply { postValue(movies) }
                        }
                    }
                    is ApiResponse.Failure.Error -> error(response.message())
                    is ApiResponse.Failure.Exception -> error(response.message())
                }
            }
            liveData.apply { postValue(movies) }
        }
}