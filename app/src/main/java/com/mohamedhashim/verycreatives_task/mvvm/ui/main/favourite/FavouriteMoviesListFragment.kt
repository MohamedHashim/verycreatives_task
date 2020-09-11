package com.mohamedhashim.verycreatives_task.mvvm.ui.main.favourite

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.mohamedhashim.verycreatives_task.R
import com.mohamedhashim.verycreatives_task.common_ui.adapters.MovieFavouriteAdapter
import com.mohamedhashim.verycreatives_task.common_ui.extensions.showFavouriteMovies
import com.mohamedhashim.verycreatives_task.common_ui.extensions.toast
import com.mohamedhashim.verycreatives_task.common_ui.viewholders.MoviesViewHolder
import com.mohamedhashim.verycreatives_task.data.entities.Movie
import com.mohamedhashim.verycreatives_task.databinding.FragmentFavMoviesListBinding
import com.mohamedhashim.verycreatives_task.mvvm.base.DatabindingFragment
import com.mohamedhashim.verycreatives_task.mvvm.ui.details.MovieDetailsViewModel
import com.mohamedhashim.verycreatives_task.mvvm.ui.main.MainViewModel
import com.skydoves.baserecyclerviewadapter.RecyclerViewPaginator
import kotlinx.android.synthetic.main.fragment_fav_movies_list.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Mohamed Hashim on 9/9\/2020.
 */
class FavouriteMoviesListFragment : DatabindingFragment(), MoviesViewHolder.Delegate {
    private val viewModel: MainViewModel by viewModel()
    private val movieDetailsViewModel: MovieDetailsViewModel by viewModel()
    private val adapterMovieList = MovieFavouriteAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentFavMoviesListBinding>(
            inflater, R.layout.fragment_fav_movies_list, container
        ).apply {
            viewModel = this@FavouriteMoviesListFragment.viewModel
            lifecycleOwner = this@FavouriteMoviesListFragment
            adapter = MovieFavouriteAdapter(this@FavouriteMoviesListFragment)
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUI()
        observeMessages()
        showFavouriteMovies(fav_recyclerView, this.viewModel, this.adapterMovieList)
    }

    private fun initializeUI() {
        RecyclerViewPaginator(
            recyclerView = fav_recyclerView,
            isLoading = { false },
            loadMore = { null },
            onLast = { false }
        )
    }

    private fun observeMessages() =
        this.viewModel.toastLiveData.observe(viewLifecycleOwner, { context?.toast(it) })

    override fun onItemClick(view: View, movie: Movie) {
        val updatedMovie = this.movieDetailsViewModel.getUpdatedMovie(movie)
        findNavController().navigate(
            R.id.action_favouriteMoviesListFragment_to_MovieDetailsFragment,
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
        inflater.inflate(R.menu.fav_app_bar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.home -> {
                findNavController().navigate(R.id.movies_list_fragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}