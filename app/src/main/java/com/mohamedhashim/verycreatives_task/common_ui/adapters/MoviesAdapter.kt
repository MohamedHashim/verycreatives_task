package com.mohamedhashim.verycreatives_task.common_ui.adapters

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import com.mohamedhashim.verycreatives_task.R
import com.mohamedhashim.verycreatives_task.common_ui.viewholders.MoviesViewHolder
import com.mohamedhashim.verycreatives_task.data.entities.Movie
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.SectionRow

/**
 * Created by Mohamed Hashim on 9/8/2020.
 */
class MoviesAdapter(
    private val delegate: MoviesViewHolder.Delegate
) : BaseAdapter() {

    init {
        addSection(ArrayList<Movie>())
    }

    fun addMovieList(movies: List<Movie>) {
        val section = sections()[0]
        val callback = MovieDiffCallback(section as List<Movie>, movies)
        val result = DiffUtil.calculateDiff(callback)
        section.clear()
        section.addAll(movies)
        result.dispatchUpdatesTo(this)
    }

    override fun layout(sectionRow: SectionRow) = R.layout.item_movie

    override fun viewHolder(layout: Int, view: View) = MoviesViewHolder(view, delegate)
}