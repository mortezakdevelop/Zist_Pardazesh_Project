package com.example.zistpardazeshnasir.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.zistpardazeshnasir.R
import com.example.zistpardazeshnasir.databinding.FragmentPageTwoBinding

class PageTwoFragment : Fragment() {

    lateinit var fragmentPageTwoBinding: FragmentPageTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentPageTwoBinding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_page_two,container,false)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewpagerTwo)
        fragmentPageTwoBinding.btnNext.setOnClickListener{
            viewPager?.currentItem = 2
        }

        fragmentPageTwoBinding.arrow2.setOnClickListener{
            viewPager?.currentItem = 0
        }

        fragmentPageTwoBinding.tvInputTwo.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_loginFragment)
        }
        return fragmentPageTwoBinding.root
    }
}