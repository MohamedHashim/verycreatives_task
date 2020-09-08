package com.mohamedhashim.verycreatives_task.data.entities

/**
 * Created by Mohamed Hashim on 9/7/2020.
 */
class Movie(
    val poster_path: String,
    val adult: Boolean,
    val overview: String,
    val release_date: String,
    val genre_ids: Array<Int>,
    val id: Int,
    val original_title: String,
    val original_language: String,
    val title: String,
    val backdrop_path: String?,
    val popularity: Float,
    val vote_count: Int,
    val video: Boolean,
    val vote_average: Float
)