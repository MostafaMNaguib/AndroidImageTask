package com.example.myapplication.base

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseFragment : Fragment() {

    val navController: NavController by lazy {
        findNavController()
    }

    val mFragmentManager: FragmentManager by lazy {
        parentFragmentManager
    }

    val mContext: Context by lazy {
        requireContext()
    }

    val mActivity: FragmentActivity by lazy {
        requireActivity()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}