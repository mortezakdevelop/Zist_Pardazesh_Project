package com.example.zistpardazeshnasir.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.PagerAdapter
import com.example.zistpardazeshnasir.R
import com.example.zistpardazeshnasir.adaper.ViewPagerAdapter
import com.example.zistpardazeshnasir.databinding.FragmentViewPagerBinding
import com.example.zistpardazeshnasir.ui.PageOneFragment
import com.example.zistpardazeshnasir.ui.PageThreeFragment
import com.example.zistpardazeshnasir.ui.PageTwoFragment
import com.google.android.material.tabs.TabLayoutMediator
import me.relex.circleindicator.CircleIndicator3

class ViewPagerFragment : Fragment() {

    lateinit var fragmentViewPagerBinding: FragmentViewPagerBinding

    private lateinit var adapter: ViewPagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentViewPagerBinding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_view_pager,container,false)


        return fragmentViewPagerBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ViewPagerAdapter(requireActivity())
        adapter.addFrag(PageThreeFragment())
        adapter.addFrag(PageTwoFragment())
        adapter.addFrag(PageOneFragment())
        fragmentViewPagerBinding.viewpagerTwo.adapter = adapter

        TabLayoutMediator(fragmentViewPagerBinding.intoTabLayout,fragmentViewPagerBinding.viewpagerTwo){
                tab,position ->

        }.attach()

        // when we are in home fragment and back pressed button , finish fragment
        requireActivity().onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }
        })
    }
}