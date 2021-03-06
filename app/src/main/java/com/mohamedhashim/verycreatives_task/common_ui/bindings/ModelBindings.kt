package com.mohamedhashim.verycreatives_task.common_ui.bindings

import android.annotation.SuppressLint
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.bumptech.glide.Glide
import com.mohamedhashim.verycreatives_task.R
import com.mohamedhashim.verycreatives_task.common_ui.PosterPath.getBackdropPath
import com.mohamedhashim.verycreatives_task.data.entities.Movie
import com.mohamedhashim.verycreatives_task.mvvm.ui.details.MovieDetailsViewModel
import com.mohamedhashim.verycreatives_task.mvvm.ui.main.sort.SortMoviesFragmentDirections
import com.skydoves.whatif.whatIfNotNull

/**
 * Created by Mohamed Hashim on 9/8/2020.
 */

@BindingAdapter("bindBackDrop")
fun bindBackDrop(view: ImageView, movie: Movie) {
    bindBackDrop(view, movie.backdrop_path, movie.poster_path)
}

private fun bindBackDrop(view: ImageView, path: String?, posterPath: String?) {
    path.whatIfNotNull(
        whatIf = {
            Glide.with(view.context)
                .load(getBackdropPath(it))
                .error(ContextCompat.getDrawable(view.context, R.drawable.ic_not_found))
                .into(view)
        },
        whatIfNot = {
            Glide.with(view.context)
                .load(getBackdropPath(posterPath))
                .error(ContextCompat.getDrawable(view.context, R.drawable.ic_not_found))
                .into(view)
        }
    )
}

@SuppressLint("SetTextI18n")
@BindingAdapter("bindReleaseDate")
fun bindReleaseDate(view: TextView, movie: Movie) {
    view.text = "Release Date : ${movie.release_date}"
}

@BindingAdapter("bindFavourite")
fun bindFavourite(imageView: ImageView, favourite: Boolean) {
    if (favourite) {
        imageView.setImageDrawable(
            ContextCompat.getDrawable(
                imageView.context,
                R.drawable.ic_favourited
            )
        )
    } else {
        imageView.setImageDrawable(
            ContextCompat.getDrawable(imageView.context, R.drawable.ic_favourite)
        )
    }
}

@BindingAdapter("observeFavourite")
fun observeFavourite(imageView: ImageView, favourite: Boolean) {
    bindFavourite(imageView, favourite)
}

@BindingAdapter("clickListener", "updateDB")
fun clickListener(imageView: ImageView, movie: Movie, viewModel: MovieDetailsViewModel) {
    imageView.setOnClickListener {
        bindFavourite(imageView, !movie.favourite)
        viewModel.onClickedFavourite(movie)
    }
}

@BindingAdapter("showMovies", "idx")
fun showMovies(btn: Button, fragment: Fragment, idx: Int) {
    btn.setOnClickListener {
        val action = SortMoviesFragmentDirections.actionSortMoviesFragmentToMoviesListFragment3(idx)
        findNavController(fragment).navigate(action)
    }
}