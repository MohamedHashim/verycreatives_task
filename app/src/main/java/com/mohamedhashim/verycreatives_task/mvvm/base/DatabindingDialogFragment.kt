package com.mohamedhashim.verycreatives_task.mvvm.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment

/**
 * Created by Mohamed Hashim on 9/9/2020.
 */
open class DatabindingDialogFragment : DialogFragment() {

    protected inline fun <reified T : ViewDataBinding> binding(
        inflater: LayoutInflater,
        @LayoutRes resId: Int,
        container: ViewGroup?
    ): T = DataBindingUtil.inflate(inflater, resId, container, false)
}
