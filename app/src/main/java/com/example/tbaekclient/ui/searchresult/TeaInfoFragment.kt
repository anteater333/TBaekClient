package com.example.tbaekclient.ui.searchresult

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.example.tbaekclient.R
import com.example.tbaekclient.model.TeaDataModel
import com.example.tbaekclient.ui.searchresult.teaspecfragment.TeaSpecInfoFragment
import com.example.tbaekclient.ui.searchresult.teaspecfragment.TeaSpecLogFragment
import com.example.tbaekclient.ui.searchresult.teaspecfragment.TeaSpecProductFragment
import com.google.android.material.tabs.TabLayout

/**
 * A simple [Fragment] subclass.
 * Use the [TeaInfoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TeaInfoFragment(
    val teaData: TeaDataModel
) : Fragment() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_tea_info, container, false)

        /******************* Initialize with TeaDataModel *********************/
        root.findViewById<TextView>(R.id.tea_sum_name).text = teaData.name
        root.findViewById<TextView>(R.id.tea_sum_name).setTextColor(ContextCompat.getColor(root.context, teaData.themeColor))
        root.findViewById<TextView>(R.id.tea_sum_category).text = teaData.category
        root.findViewById<TextView>(R.id.tea_sum_category).setTextColor(ContextCompat.getColor(root.context, teaData.themeColor))
        root.findViewById<TextView>(R.id.tea_sum_description).text = teaData.description

        // set bookmarked state
        if (teaData.isBookmarked) {
            root.findViewById<Button>(R.id.tea_sum_bookmark).background = root.context.getDrawable(android.R.drawable.star_on)
        }
        else {
            root.findViewById<Button>(R.id.tea_sum_bookmark).background = root.context.getDrawable(android.R.drawable.star_off)
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* Tablayout 설정 ************************************************************/
        val tabLayout = view.findViewById<TabLayout>(R.id.tea_spec_tab_layout)

        val pagerAdapter = TeaInfoPagerAdapter(childFragmentManager)

        // pagerAdapter에 Fragment 등록
        pagerAdapter.addItems(TeaSpecInfoFragment(teaData), "정보")
        pagerAdapter.addItems(TeaSpecLogFragment(), "기록")
        pagerAdapter.addItems(TeaSpecProductFragment(), "제품")

        val pager = view.findViewById<ViewPager>(R.id.tea_spec_container)
        pager.adapter = pagerAdapter

        tabLayout.setupWithViewPager(pager)
        tabLayout.getTabAt(0)?.select()

        pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) { }
            override fun onTabUnselected(tab: TabLayout.Tab?) { }
            override fun onTabSelected(tab: TabLayout.Tab) {
                Log.d("MyDbg", tab.position.toString())
                pager.currentItem = tab.position
            }
        })
        /*****************************************************************************/

    }
}