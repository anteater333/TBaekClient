package com.example.tbaekclient.ui.searchresult

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tbaekclient.R
import com.example.tbaekclient.model.TeaDataModel
import com.example.tbaekclient.ui.components.teacard.TeaCardRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_search_result.*

class SearchResultFragment : Fragment() {

    private lateinit var searchResultViewModel: SearchResultViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        searchResultViewModel =
                ViewModelProviders.of(this).get(SearchResultViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_search_result, container, false)

        /* RecyclerView Adapter 설정 *************************************************/
        val teaCardRecyclerView = root?.findViewById<RecyclerView>(R.id.tea_search_card_list) // 검색 결과 카드 리스트

        if (teaCardRecyclerView is RecyclerView) {
            with(teaCardRecyclerView) {
                layoutManager = GridLayoutManager(context, 2)
                adapter = TeaCardRecyclerViewAdapter(searchResultViewModel.searchResultList.value!!)
                (adapter as TeaCardRecyclerViewAdapter).onItemClick = object : TeaCardRecyclerViewAdapter.OnItemClick {
                    override fun onItemClick(view: View, clickItem: TeaDataModel) {
                        searchResultViewModel.selectedItem?.value = clickItem
                    }
                }
            }
        }
        /*****************************************************************************/

        // 이벤트 리스너 및 애니메이션 지정
        root?.findViewById<ConstraintLayout>(R.id.search_result_empty_area)?.setOnClickListener{
            scrollView.animate().translationY(1500f)
                .setDuration(500).withEndAction {
                    scrollView.visibility = View.GONE
                }.start()
        }

        // 기본으로 검색 결과의 첫 번째 아이템 선택
        val teaData = when(searchResultViewModel.searchResultList.value) {
            null -> {
                TeaDataModel()
            }
            else -> {
                searchResultViewModel.searchResultList.value!![0]
            }
        }
        searchResultViewModel.selectedItem?.value = teaData

        // FragmentContainerView에 Fragment 할당.
        var teaInfoFragment = TeaInfoFragment(teaData)
        activity!!.supportFragmentManager.beginTransaction()
            .add(R.id.tea_info_fragment_container, teaInfoFragment).commit()

        searchResultViewModel.selectedItem?.observe(viewLifecycleOwner, Observer<TeaDataModel> {
            teaInfoFragment = TeaInfoFragment(it)
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.tea_info_fragment_container, teaInfoFragment).commit()
        })
        return root
    }
}