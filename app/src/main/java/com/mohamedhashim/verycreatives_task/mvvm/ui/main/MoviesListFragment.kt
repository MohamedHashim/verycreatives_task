package com.mohamedhashim.verycreatives_task.mvvm.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.mohamedhashim.verycreatives_task.R
import com.mohamedhashim.verycreatives_task.common_ui.adapters.MoviesAdapter
import com.mohamedhashim.verycreatives_task.common_ui.extensions.toast
import com.mohamedhashim.verycreatives_task.common_ui.viewholders.MoviesViewHolder
import com.mohamedhashim.verycreatives_task.data.entities.Movie
import com.mohamedhashim.verycreatives_task.databinding.FragmentMoviesListBinding
import com.mohamedhashim.verycreatives_task.mvvm.base.DatabindingFragment
import com.mohamedhashim.verycreatives_task.mvvm.ui.details.MovieDetailsViewModel
import com.skydoves.baserecyclerviewadapter.RecyclerViewPaginator
import kotlinx.android.synthetic.main.fragment_movies_list.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Mohamed Hashim on 9/8/2020.
 */
class MoviesListFragment : DatabindingFragment(), MoviesViewHolder.Delegate {

    private val viewModel: MainViewModel by viewModel()
    private val movieDetailsViewModel: MovieDetailsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentMoviesListBinding>(
            inflater, R.layout.fragment_movies_list, container
        ).apply {
            viewModel = this@MoviesListFragment.viewModel
            lifecycleOwner = this@MoviesListFragment
            adapter = MoviesAdapter(this@MoviesListFragment)
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUI()
        loadMore(page = 1)
        observeMessages()
    }

    private fun initializeUI() {
        RecyclerViewPaginator(
            recyclerView = recyclerView,
            isLoading = { false },
            loadMore = { loadMore(it) },
            onLast = { false }
        ).apply {
            threshold = 4
            currentPage = 1
        }
    }

    private fun loadMore(page: Int) = this.viewModel.postMoviePage(page)

    private fun observeMessages() =
        this.viewModel.toastLiveData.observe(this) { context?.toast(it) }

    override fun onItemClick(view: View, movie: Movie) {
        val updatedMovie = this.movieDetailsViewModel.getUpdatedMovie(movie)

        findNavController().navigate(
            R.id.actionMovieDetails,
            MainViewModel.createArguments(updatedMovie)
        )
    }
}
