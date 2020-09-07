package com.mohamedhashim.verycreatives_task.mvvm.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mohamedhashim.verycreatives_task.data.entities.PopularMovie
import com.mohamedhashim.verycreatives_task.mvvm.base.LiveCoroutinesViewModel
import com.mohamedhashim.verycreatives_task.mvvm.repository.MoviesRepository

/**
 * Created by Mohamed Hashim on 9/7/2020.
 */
class MainViewModel constructor(
    private val moviesRepository: MoviesRepository
) : LiveCoroutinesViewModel() {

    val moviesListLiveData: LiveData<List<PopularMovie>>
    val toastLiveData: MutableLiveData<String> = MutableLiveData()

    init {

        this.moviesListLiveData =
            launchOnViewModelScope {
                this.moviesRepository.loadPopularMovies { this.toastLiveData.postValue(it) }
            }
    }
}
