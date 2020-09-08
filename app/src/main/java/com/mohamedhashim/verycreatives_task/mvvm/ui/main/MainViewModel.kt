package com.mohamedhashim.verycreatives_task.mvvm.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.mohamedhashim.verycreatives_task.data.entities.Movie
import com.mohamedhashim.verycreatives_task.mvvm.base.LiveCoroutinesViewModel
import com.mohamedhashim.verycreatives_task.mvvm.repository.MoviesRepository

/**
 * Created by Mohamed Hashim on 9/7/2020.
 */
class MainViewModel constructor(
    private val moviesRepository: MoviesRepository
) : LiveCoroutinesViewModel() {

    val moviesListLiveData: LiveData<List<Movie>>
    private var moviePageLiveData: MutableLiveData<Int> = MutableLiveData()
    val toastLiveData: MutableLiveData<String> = MutableLiveData()

    init {

        this.moviesListLiveData = this.moviePageLiveData.switchMap { page ->
            launchOnViewModelScope {
                this.moviesRepository.loadPopularMovies(page) { this.toastLiveData.postValue(it) }
            }
        }
    }

    fun postMoviePage(page: Int) = this.moviePageLiveData.postValue(page)
}