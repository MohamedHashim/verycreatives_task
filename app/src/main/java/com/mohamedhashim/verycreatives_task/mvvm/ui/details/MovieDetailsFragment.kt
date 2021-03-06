package com.mohamedhashim.verycreatives_task.mvvm.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import com.mohamedhashim.verycreatives_task.R
import com.mohamedhashim.verycreatives_task.common_ui.extensions.initToolbar
import com.mohamedhashim.verycreatives_task.common_ui.extensions.toast
import com.mohamedhashim.verycreatives_task.data.entities.Movie
import com.mohamedhashim.verycreatives_task.databinding.FragmentMovieDetailsBinding
import com.mohamedhashim.verycreatives_task.mvvm.base.DatabindingFragment
import kotlinx.android.synthetic.main.fragment_movie_details.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Mohamed Hashim on 9/8/2020.
 */
class MovieDetailsFragment : DatabindingFragment() {
    private val viewModel: MovieDetailsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentMovieDetailsBinding>(
            inflater, R.layout.fragment_movie_details, container
        ).apply {
            lifecycleOwner = this@MovieDetailsFragment
            viewModel = this@MovieDetailsFragment.viewModel
            movie = requireArguments().get(getString(R.string.movie_key)) as Movie
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(toolbar, activity as AppCompatActivity)
        viewModel.loadArguments(arguments)
        observeMessages()
    }

    private fun observeMessages() =
        this.viewModel.toastLiveData.observe(viewLifecycleOwner, { context?.toast(getString(it)) })
}