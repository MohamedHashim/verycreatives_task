package com.mohamedhashim.verycreatives_task.data.response

import com.mohamedhashim.verycreatives_task.data.entities.Movie

/**
 * Created by Mohamed Hashim on 9/7/2020.
 */

class PopularMoviesResponse(
    val page: Int,
    val results: List<Movie>
)