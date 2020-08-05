package com.example.tbaekclient.ui.components.teacard

import android.graphics.drawable.Drawable
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tbaekclient.R
import com.example.tbaekclient.model.TeaDataModel
import com.example.tbaekclient.ui.components.tagitem.TagItemRecyclerViewAdapter

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class TeaCardRecyclerViewAdapter(
    private val values: List<TeaDataModel>
) : RecyclerView.Adapter<TeaCardRecyclerViewAdapter.ViewHolder>() {

    interface OnItemClick {
        fun onItemClick(view: View, clickItem: TeaDataModel)
    }

    var onItemClick: OnItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tea_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.dataBind(item)

        if(onItemClick != null) {
            holder.view.setOnClickListener {
                onItemClick!!.onItemClick(it, holder.teaData)
            }
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var teaData: TeaDataModel

        val nameView: TextView = view.findViewById(R.id.tea_card_name)
        val categoryView: TextView = view.findViewById(R.id.tea_card_category)
        val bookmarkView: Button = view.findViewById(R.id.tea_card_bookmark)
        val descriptionView: TextView = view.findViewById(R.id.tea_card_description)
        val graphContainer: ConstraintLayout = view.findViewById(R.id.tea_card_popular_graph_container)
        val popularGraphBar: View = view.findViewById(R.id.tea_card_popular_graph_bar)
        val recommendGraphBar: View = view.findViewById(R.id.tea_card_recommend_graph_bar)
        val tagList: RecyclerView = view.findViewById(R.id.tea_card_tag_list)
        val view: View = view

        fun dataBind(data: TeaDataModel) {
            teaData = data

            // set text
            nameView.text = teaData.name
            categoryView.text = teaData.category
            descriptionView.text = teaData.description

            // set text color
            nameView.setTextColor(ContextCompat.getColor(view.context, teaData.themeColor))
            categoryView.setTextColor(ContextCompat.getColor(view.context, teaData.themeColor))

            // set bookmarked state
            if (teaData.isBookmarked) {
                bookmarkView.background = view.context.getDrawable(android.R.drawable.star_on)
            }
            else {
                bookmarkView.background = view.context.getDrawable(android.R.drawable.star_off)
            }

            // set graph
            setGraph(teaData.popular, teaData.recommend)

            // set tag
            if (tagList is RecyclerView) {
                with(tagList) {
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    adapter = teaData.tagList?.let { TagItemRecyclerViewAdapter(it) }
                    (adapter as TagItemRecyclerViewAdapter).setItemViewType(TagItemRecyclerViewAdapter.TAG_SMALL)
                }
            }
        }

        private fun setGraph(popular : Float, recommend : Float) {
            val containerWidth = graphContainer.layoutParams.width.toFloat()

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

            popularGraphBar.layoutParams.width = popRatio.toInt()
            recommendGraphBar.layoutParams.width = recRatio.toInt()
        }

        override fun toString(): String {
            return super.toString() + " '" + nameView.text + "'"
        }
    }
}