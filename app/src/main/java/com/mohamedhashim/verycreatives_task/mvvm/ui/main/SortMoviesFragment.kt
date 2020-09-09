package com.mohamedhashim.verycreatives_task.mvvm.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mohamedhashim.verycreatives_task.R
import com.mohamedhashim.verycreatives_task.databinding.FragmentSortMoviesBinding
import com.mohamedhashim.verycreatives_task.mvvm.base.DatabindingDialogFragment
import kotlinx.android.synthetic.main.fragment_sort_movies.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Mohamed Hashim on 9/9/2020.
 */
class SortMoviesFragment : DatabindingDialogFragment() {
    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentSortMoviesBinding>(
            inflater, R.layout.fragment_sort_movies, container
        ).apply {
            viewModel = this@SortMoviesFragment.viewModel
            lifecycleOwner = this@SortMoviesFragment
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.setOnShowListener {
            dialog?.window?.setLayout(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog?.window?.setBackgroundDrawableResource(R.drawable.background_white_rounded_shape)
        }
    }
}
