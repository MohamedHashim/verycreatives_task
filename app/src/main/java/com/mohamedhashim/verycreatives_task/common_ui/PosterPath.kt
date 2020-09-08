package com.mohamedhashim.verycreatives_task.common_ui

/**
 * Created by Mohamed Hashim on 9/8/2020.
 */
object PosterPath {
    private const val BASE_POSTER_PATH = "https://image.tmdb.org/t/p/w342"
    fun getPosterPath(posterPath: String) = BASE_POSTER_PATH + posterPath
}