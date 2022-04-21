package com.example.zistpardazeshnasir.ui

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.zistpardazeshnasir.R
import com.example.zistpardazeshnasir.base.BaseFragment
import com.example.zistpardazeshnasir.databinding.FragmentLoginBinding

class LoginFragment :BaseFragment() {

    lateinit var phoneNumber:String

    private lateinit var fragmentLoginBinding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentLoginBinding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_login,container,false)
        getPhoneNumber()
        showDialog()

        fragmentLoginBinding.tvHaveAccount.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        return fragmentLoginBinding.root
    }

    private fun showDialog(){
        fragmentLoginBinding.btnInput.setOnClickListener {
            if (checkNetwork()){
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }else{
                findNavController().navigate(R.id.action_loginFragment_to_noInternetFragment)
            }
        }
    }

    private fun getPhoneNumber() {
        phoneNumber = fragmentLoginBinding.etPhone.text.toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // when we are in home fragment and back pressed button , finish fragment
        requireActivity().onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigate(R.id.action_loginFragment_to_viewPagerFragment)
            }
        })
    }

}
