package com.mohamedhashim.verycreatives_task.common_ui.viewholders

import android.view.View
import androidx.core.view.ViewCompat
import com.mohamedhashim.verycreatives_task.data.entities.Movie
import com.mohamedhashim.verycreatives_task.databinding.ItemMovieBinding
import com.skydoves.baserecyclerviewadapter.BaseViewHolder

/**
 * Created by Mohamed Hashim on 9/8/2020.
 */
class MoviesViewHolder(view: View) : BaseViewHolder(view) {

    private lateinit var movie: Movie
    private val binding by bindings<ItemMovieBinding>(view)

    override fun bindData(data: Any) {
        if (data is Movie) {
            movie = data
            binding.apply {
                ViewCompat.setTransitionName(binding.itemMovieContainer, data.title)
                movie = data
                executePendingBindings()
            }
        }
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

    override fun onLongClick(v: View?): Boolean {
        TODO("Not yet implemented")
    }
}
