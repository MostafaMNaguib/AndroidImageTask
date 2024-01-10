package com.example.myapplication.base

import android.content.Context
import androidx.fragment.app.DialogFragment

open class BaseDialogFragment : DialogFragment() {

    /*val mFragmentManager: FragmentManager by lazy {
        parentFragmentManager
    }
*/
    val mContext: Context by lazy {
        requireContext()
    }

}