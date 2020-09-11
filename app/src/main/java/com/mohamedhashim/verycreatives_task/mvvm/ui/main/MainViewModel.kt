package com.mohamedhashim.verycreatives_task.mvvm.ui.main

import android.os.Bundle
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

    var moviesListLiveData: LiveData<List<Movie>>
    var topRatedMoviesListLiveData: LiveData<List<Movie>>
    val favouriteMoviesLiveData: LiveData<List<Movie>>
    val popularMoviesLiveData: LiveData<List<Movie>>
    private var moviePageLiveData: MutableLiveData<Int> = MutableLiveData()
    val toastLiveData: MutableLiveData<String> = MutableLiveData()

    init {

        this.moviesListLiveData = this.moviePageLiveData.switchMap { page ->
            launchOnViewModelScope {
                this.moviesRepository.loadPopularMovies(page) { this.toastLiveData.postValue(it) }
            }
        }
        this.topRatedMoviesListLiveData = this.moviePageLiveData.switchMap { page ->
            launchOnViewModelScope {
                this.moviesRepository.loadTopRatedMovies(page) { this.toastLiveData.postValue(it) }
            }
        }

        this.popularMoviesLiveData = this.moviesListLiveData
        this.favouriteMoviesLiveData = this.moviesRepository.getFavouriteMoviesLiveData()
    }

    fun postMoviePage(page: Int) = this.moviePageLiveData.postValue(page)
    fun getFavouriteMovieList() = this.moviesRepository.getFavouriteMoviesList()

    companion object {
        private const val movieKey = "movie"
        fun createArguments(movie: Movie): Bundle {
            val bundle = Bundle()
            bundle.putParcelable(movieKey, movie)
            return bundle
        }
    }
}