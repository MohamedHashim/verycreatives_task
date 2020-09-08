package com.mohamedhashim.verycreatives_task.common_ui.adapters

import android.view.View
import com.mohamedhashim.verycreatives_task.R
import com.mohamedhashim.verycreatives_task.common_ui.viewholders.MoviesViewHolder
import com.mohamedhashim.verycreatives_task.data.entities.Movie
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.SectionRow
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Mohamed Hashim on 9/8/2020.
 */
class MoviesAdapter : BaseAdapter() {

    init {
        addSection(ArrayList<Movie>())
    }

    fun addMovieList(movies: List<Movie>) {
        val section = sections()[0]
        section.addAll(movies)
        notifyItemRangeInserted(section.size - movies.size + 1, movies.size)
    }

    override fun layout(sectionRow: SectionRow) = R.layout.item_movie

    override fun viewHolder(layout: Int, view: View) = MoviesViewHolder(view)
}