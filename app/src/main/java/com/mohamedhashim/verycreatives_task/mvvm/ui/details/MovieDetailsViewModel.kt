package com.mohamedhashim.verycreatives_task.mvvm.ui.details

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mohamedhashim.verycreatives_task.R
import com.mohamedhashim.verycreatives_task.data.entities.Movie
import com.mohamedhashim.verycreatives_task.mvvm.repository.MoviesRepository

/**
 * Created by Mohamed Hashim on 9/8/2020.
 */
class MovieDetailsViewModel(
    private val movieRepository: MoviesRepository
) : ViewModel() {
    val toastLiveData: MutableLiveData<Int> = MutableLiveData()

    fun loadArguments(arguments: Bundle?) {
        if (arguments == null) {
            return
        }
    }

    fun onClickedFavourite(movie: Movie) {
        if (movie.favourite) {
            movieRepository.updateMovie(movie)
            this.toastLiveData.postValue(R.string.removed_message)
        } else {
            movieRepository.insertMovie(movie)
            this.toastLiveData.postValue(R.string.added_message)
        }
    }

    fun getUpdatedMovie(movie: Movie) = movieRepository.realMovie(movie)
}
