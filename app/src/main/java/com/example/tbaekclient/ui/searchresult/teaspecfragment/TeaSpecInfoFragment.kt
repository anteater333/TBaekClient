package com.example.tbaekclient.ui.searchresult.teaspecfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tbaekclient.R
import com.example.tbaekclient.model.TeaDataModel
import com.example.tbaekclient.ui.components.infusestep.InfuseStepRecyclerViewAdapter
import com.example.tbaekclient.ui.components.tagitem.TagItemRecyclerViewAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_TEA_DATA = "TEA_DATA"

/**
 * A simple [Fragment] subclass.
 * Use the [TeaSpecInfoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TeaSpecInfoFragment(
    val teaData: TeaDataModel
) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_tea_spec_info, container, false)

        /******************* Initialize with TeaDataModel *********************/
        setGraph(teaData.popular, teaData.recommend, root)      // 그래프 작성
        root.findViewById<TextView>(R.id.tea_spec_info_caffeine_value).text = teaData.caffeine.toString() + "mg"   // 카페인 표시

        /* RecyclerView Adapter 설정 *************************************************/
        val infuseStepRecyclerView = root?.findViewById<RecyclerView>(R.id.tea_spec_info_infuse_step_list) // 우리는 법 단계 담아두는 RecyclerView
        val tagRecyclerView = root?.findViewById<RecyclerView>(R.id.tea_spec_info_tag_list) // 효능 태그 담아두는 RecyclerView

        if (infuseStepRecyclerView is RecyclerView) {
            with(infuseStepRecyclerView) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = teaData.infuseSteps?.let { InfuseStepRecyclerViewAdapter(it) }
            }
        }

        if (tagRecyclerView is RecyclerView) {
            with(tagRecyclerView) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = teaData.effectList?.let { TagItemRecyclerViewAdapter(it) }
            }
        }
        /*****************************************************************************/

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setGraph(popular : Float, recommend : Float, view: View) {
        val containerWidth = view.findViewById<View>(R.id.tea_spec_info_popular_graph_container).layoutParams.width.toFloat()

        var popRatio = popular
        var recRatio = recommend

        if (popRatio < 0.1f) {
            popRatio = 0.1f
        } else if (popRatio > 1.0f) {
            popRatio = 1.0f
        }
        if (recRatio < 0.1f) {
            recRatio = 0.1f
        } else if (recRatio > 1.0f) {
            recRatio = 1.0f
        }

        popRatio *= containerWidth
        recRatio *= containerWidth

        view.findViewById<View>(R.id.tea_spec_info_popular_graph_bar).layoutParams.width = popRatio.toInt()
        view.findViewById<View>(R.id.tea_spec_info_recommend_graph_bar).layoutParams.width = recRatio.toInt()
    }
}