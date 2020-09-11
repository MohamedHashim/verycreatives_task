package com.mohamedhashim.verycreatives_task.common_ui.bindings

import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.mohamedhashim.verycreatives_task.R
import com.mohamedhashim.verycreatives_task.common_ui.PosterPath


/**
 * Created by Mohamed Hashim on 9/8/2020.
 */
@BindingAdapter("setVoteAverage")
fun setVoteAverage(view: TextView, value: Float) {
    if (value.isNaN()) view.text = ""
    else view.text = value.toString()
}

@BindingAdapter("bindingPosterUrl")
fun bindingPosterUrl(imageView: ImageView, path: String?) {
    path?.let {
        imageView.clipToOutline = true
        Glide.with(imageView.context)
            .load(PosterPath.getPosterPath(it))
            .error(ContextCompat.getDrawable(imageView.context, R.drawable.ic_not_found))
            .into(imageView)
    }
}