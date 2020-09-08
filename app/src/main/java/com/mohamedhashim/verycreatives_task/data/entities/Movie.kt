package com.mohamedhashim.verycreatives_task.data.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Mohamed Hashim on 9/7/2020.
 */
@Parcelize
class Movie(
    var page: Int,
    var poster_path: String,
    var adult: Boolean,
    var overview: String,
    var release_date: String,
    var genre_ids: Array<Int>,
    var id: Int,
    var original_title: String,
    var original_language: String,
    var title: String,
    var backdrop_path: String?,
    var popularity: Float,
    var vote_count: Int,
    var video: Boolean,
    var vote_average: Float
):Parcelable