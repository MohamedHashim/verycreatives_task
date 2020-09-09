package com.mohamedhashim.verycreatives_task.data.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * Created by Mohamed Hashim on 9/7/2020.
 */
@Entity
@Parcelize
class Movie(
    var page: Int,
    var poster_path: String,
    var adult: Boolean,
    var overview: String,
    var release_date: String,
    @PrimaryKey var id: Int,
    var original_title: String,
    var original_language: String,
    var title: String,
    var backdrop_path: String?,
    var popularity: Float,
    var vote_count: Int,
    var video: Boolean,
    var vote_average: Float,
    var favourite: Boolean
) : Parcelable