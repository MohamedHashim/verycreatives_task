package com.mohamedhashim.verycreatives_task.mvvm.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mohamedhashim.verycreatives_task.R
import com.mohamedhashim.verycreatives_task.common_ui.adapters.MoviesAdapter
import com.mohamedhashim.verycreatives_task.databinding.FragmentMoviesListBinding
import com.mohamedhashim.verycreatives_task.mvvm.base.DatabindingFragment
import com.skydoves.baserecyclerviewadapter.RecyclerViewPaginator
import kotlinx.android.synthetic.main.fragment_movies_list.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Mohamed Hashim on 9/8/2020.
 */
class MoviesListFragment : DatabindingFragment() {

    private val viewModel: MainViewModel by viewModel()

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
            adapter = MoviesAdapter()
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUI()
//        observeMessages()
    }

    private fun initializeUI() {
        RecyclerViewPaginator(
            recyclerView = recyclerView,
            isLoading = { false },
            loadMore = { null },
            onLast = { false }
        )
    }

//    private fun observeMessages() =
//        this.viewModel.toastLiveData.observe(this) {
//            Toast.makeText(
//                this,
//                it.toString(),
//                Toast.LENGTH_SHORT
//            )
//        }
}
