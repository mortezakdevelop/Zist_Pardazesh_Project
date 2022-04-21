package com.example.zistpardazeshnasir.dialog

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.zistpardazeshnasir.R
import com.example.zistpardazeshnasir.databinding.FragmentNoInternetBinding
import android.util.DisplayMetrics
import androidx.navigation.fragment.findNavController
import com.example.zistpardazeshnasir.base.BaseFragment


class NoInternetFragment : BaseFragment() {
    lateinit var fragmentNoInternetBinding: FragmentNoInternetBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentNoInternetBinding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_no_internet,container,false)
        defineDialog()

        fragmentNoInternetBinding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        fragmentNoInternetBinding.btnCreateAccount.setOnClickListener {
            findNavController().navigate(R.id.action_noInternetFragment_to_registerFragment)
        }
        return fragmentNoInternetBinding.root
    }

    //portrait orientation method
    fun defineDialog(){
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O){
            requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        //distance from all screen mobile
        val mWidth:ViewGroup.LayoutParams = fragmentNoInternetBinding.clNoInternet.layoutParams
        mWidth.width = getWidthScreen(requireContext())-150
        fragmentNoInternetBinding.clNoInternet.layoutParams
    }
}