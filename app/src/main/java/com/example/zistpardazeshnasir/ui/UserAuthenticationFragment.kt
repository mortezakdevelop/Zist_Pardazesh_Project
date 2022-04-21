package com.example.zistpardazeshnasir.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.zistpardazeshnasir.R
import com.example.zistpardazeshnasir.databinding.FragmentUserAuthenticationBinding


class UserAuthenticationFragment : Fragment() {

    lateinit var fragmentUserAuthenticationBinding: FragmentUserAuthenticationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentUserAuthenticationBinding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_user_authentication, container, false)

        fragmentUserAuthenticationBinding.back.setOnClickListener {
            findNavController().popBackStack()
        }


        return fragmentUserAuthenticationBinding.root
    }
}