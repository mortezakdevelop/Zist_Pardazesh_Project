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
import com.example.zistpardazeshnasir.databinding.FragmentPageThreeBinding

class PageThreeFragment : Fragment() {
lateinit var fragmentPageThreeBinding: FragmentPageThreeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentPageThreeBinding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_page_three,container,false)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewpagerTwo)
        fragmentPageThreeBinding.btnNext.setOnClickListener{
            viewPager?.currentItem = 1
        }

        fragmentPageThreeBinding.tvInput.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_loginFragment)
        }
        return fragmentPageThreeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentPageThreeBinding.tvInput.setOnClickListener {
        }
    }
}