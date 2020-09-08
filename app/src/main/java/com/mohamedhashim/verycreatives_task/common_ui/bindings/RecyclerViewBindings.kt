package com.mohamedhashim.verycreatives_task.common_ui.bindings

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mohamedhashim.verycreatives_task.common_ui.adapters.MoviesAdapter
import com.mohamedhashim.verycreatives_task.data.entities.Movie
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.whatif.whatIfNotNullOrEmpty

/**
 * Created by Mohamed Hashim on 9/8/2020.
 */
@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, baseAdapter: BaseAdapter) {
    view.adapter = baseAdapter
}

@BindingAdapter("adapterMovieList")
fun bindAdapterMovieList(view: RecyclerView, movies: List<Movie>?) {
    movies.whatIfNotNullOrEmpty {
        val adapter = view.adapter as? MoviesAdapter
        adapter?.addMovieList(it)
    }
}