package com.mohamedhashim.verycreatives_task.common_ui.extensions

import android.content.Context
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.mohamedhashim.verycreatives_task.common_ui.adapters.MovieFavouriteAdapter
import com.mohamedhashim.verycreatives_task.common_ui.adapters.MoviesAdapter
import com.mohamedhashim.verycreatives_task.common_ui.bindings.bindAdapterMovieList
import com.mohamedhashim.verycreatives_task.mvvm.ui.main.MainViewModel

/**
 * Created by Mohamed Hashim on 9/8/2020.
 */
fun Context.toast(message: String) =
    Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()

fun hidActionBar(activity: AppCompatActivity) {
    activity.requestWindowFeature(Window.FEATURE_NO_TITLE)
    activity.supportActionBar?.hide()
}

fun initToolbar(toolbar: Toolbar, activity: AppCompatActivity) {
    activity.setSupportActionBar(toolbar)
    activity.supportActionBar?.title = ""
    activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
}

fun showPopularMovies(
    recyclerView: RecyclerView,
    viewModel: MainViewModel,
    adapterMovieList: MoviesAdapter
) {
    recyclerView.removeAllViewsInLayout()
    viewModel.moviesListLiveData = viewModel.popularMoviesLiveData
    viewModel.popularMoviesLiveData.value?.let {
        adapterMovieList.addMovieList(it)
    }
    bindAdapterMovieList(recyclerView, viewModel.popularMoviesLiveData.value)
}

fun showTopRatedMovies(
    recyclerView: RecyclerView,
    viewModel: MainViewModel,
    adapterMovieList: MoviesAdapter
) {
    recyclerView.removeAllViewsInLayout()
    viewModel.moviesListLiveData = viewModel.topRatedMoviesListLiveData
    viewModel.topRatedMoviesListLiveData.value?.let {
        adapterMovieList.addMovieList(it)
    }
    bindAdapterMovieList(recyclerView, viewModel.topRatedMoviesListLiveData.value)
}

fun showFavMovies(
    recyclerView: RecyclerView,
    viewModel: MainViewModel,
    adapterMovieList: MoviesAdapter
) {
    recyclerView.removeAllViewsInLayout()
    viewModel.moviesListLiveData = viewModel.favouriteMoviesLiveData
    adapterMovieList.addMovieList(viewModel.getFavouriteMovieList())
    bindAdapterMovieList(recyclerView, viewModel.getFavouriteMovieList())
}

fun showFavouriteMovies(
    recyclerView: RecyclerView,
    viewModel: MainViewModel,
    adapterMovieList: MovieFavouriteAdapter
) {
    adapterMovieList.addMovieList(viewModel.getFavouriteMovieList())
    bindAdapterMovieList(recyclerView, viewModel.getFavouriteMovieList())
}