package com.mohamedhashim.verycreatives_task.data.response

import com.mohamedhashim.verycreatives_task.data.entities.PopularMovie

/**
 * Created by Mohamed Hashim on 9/7/2020.
 */

class PopularMoviesResponse(
    val page: Int,
    val results: List<PopularMovie>,
    val total_results: Int,
    val total_pages: Int
)