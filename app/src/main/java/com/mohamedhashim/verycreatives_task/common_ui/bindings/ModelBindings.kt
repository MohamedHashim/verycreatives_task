package com.mohamedhashim.verycreatives_task.common_ui.bindings

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.mohamedhashim.verycreatives_task.R
import com.mohamedhashim.verycreatives_task.common_ui.PosterPath.getBackdropPath
import com.mohamedhashim.verycreatives_task.data.entities.Movie
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