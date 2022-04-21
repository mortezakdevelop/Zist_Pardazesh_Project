package com.example.zistpardazeshnasir.adaper

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.zistpardazeshnasir.ui.PageOneFragment
import com.example.zistpardazeshnasir.ui.PageThreeFragment
import com.example.zistpardazeshnasir.ui.PageTwoFragment

class ViewPagerAdapter(manager: FragmentActivity) : FragmentStateAdapter(manager) {

    private val fragmentList:MutableList<Fragment> = ArrayList()

    fun addFrag(fragment: Fragment?) {
        fragmentList.add(fragment!!)
    }
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}
