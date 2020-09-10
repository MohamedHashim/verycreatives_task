package com.mohamedhashim.verycreatives_task.mvvm.ui.main

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mohamedhashim.verycreatives_task.R
import com.mohamedhashim.verycreatives_task.common_ui.adapters.MoviesAdapter
import com.mohamedhashim.verycreatives_task.common_ui.extensions.*
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
    private val adapterMovieList = MoviesAdapter(this)
    private val args: MoviesListFragmentArgs by navArgs()

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
        sortMoviesHandler()
        if (!hasInternetConnected(view.context)!!)
            showFavMovies(recyclerView, this.viewModel, this.adapterMovieList)
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
        this.viewModel.toastLiveData.observe(viewLifecycleOwner, { context?.toast(it) })

    override fun onItemClick(view: View, movie: Movie) {
        val updatedMovie = this.movieDetailsViewModel.getUpdatedMovie(movie)
        findNavController().navigate(
            R.id.actionMovieDetails,
            MainViewModel.createArguments(updatedMovie)
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(view?.findViewById(R.id.topAppBar))

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.top_app_bar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.more -> {
                findNavController().navigate(R.id.sortMoviesFragment)
                true
            }
            R.id.favourite -> {
                showFavMovies(recyclerView, this.viewModel, this.adapterMovieList)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun sortMoviesHandler() {
        when (args.idx) {
            1 -> {
                showPopularMovies(recyclerView, this.viewModel, this.adapterMovieList)
            }
            2 -> {
                showTopRatedMovies(recyclerView, this.viewModel, this.adapterMovieList)
            }
            3 -> {
                showFavMovies(recyclerView, this.viewModel, this.adapterMovieList)
            }
        }
    }
}