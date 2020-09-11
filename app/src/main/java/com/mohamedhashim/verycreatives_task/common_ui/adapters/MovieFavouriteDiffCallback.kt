package com.mohamedhashim.verycreatives_task.common_ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.mohamedhashim.verycreatives_task.data.entities.Movie

/**
 * Created by Mohamed Hashim on 9/9/2020.
 */
class MovieFavouriteDiffCallback(
    private val oldList: List<Movie>,
    private val newList: List<Movie>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        areItemsTheSame(oldItemPosition, newItemPosition)

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size
}
