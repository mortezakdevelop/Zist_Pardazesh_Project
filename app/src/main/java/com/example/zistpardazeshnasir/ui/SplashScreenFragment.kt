package com.example.zistpardazeshnasir.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.zistpardazeshnasir.R
import com.example.zistpardazeshnasir.databinding.FragmentSplashScreenBinding
import android.view.animation.Animation
import android.view.animation.AnimationUtils


class SplashScreenFragment : Fragment() {
    lateinit var animation:Animation

    lateinit var fragmentSplashScreenBinding: FragmentSplashScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentSplashScreenBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_splash_screen,
            container,
            false
        )
        setAnimation()
        showSplashScreen()

        return fragmentSplashScreenBinding.root
    }

    private fun showSplashScreen(){
        Handler(Looper.myLooper()!!).postDelayed({
            Navigation.findNavController(fragmentSplashScreenBinding.root)
                .navigate(R.id.action_splashScreenFragment_to_viewPagerFragment)

        }, 3000)
    }

    private fun setAnimation(){
        animation = AnimationUtils.loadAnimation(requireContext(),R.anim.fade_in)
        fragmentSplashScreenBinding.ivNbp.startAnimation(animation)
    }
}