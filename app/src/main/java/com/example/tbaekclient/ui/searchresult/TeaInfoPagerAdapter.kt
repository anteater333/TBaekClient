package com.example.tbaekclient.ui.searchresult

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TeaInfoPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private var fragments : ArrayList<Fragment> = ArrayList()
    private var tabTitles : ArrayList<String> = ArrayList()

    /**
     * Return the Fragment associated with a specified position.
     */
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    /**
     * Return the CharSequence that indicates a selected tab page's title.
     */
    override fun getPageTitle(position: Int): CharSequence? = tabTitles[position]

    /**
     * Return the number of views available.
     */
    override fun getCount(): Int = fragments.size

    fun addItems(fragment : Fragment, tabTitle : String) {
        fragments.add(fragment)
        tabTitles.add(tabTitle)
    }
}