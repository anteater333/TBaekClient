package com.example.tbaekclient.ui.components.tagitem

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.tbaekclient.R
import com.example.tbaekclient.model.TagDataModel

import com.example.tbaekclient.ui.components.tagitem.dummy.DummyContent.DummyItem

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class TagItemRecyclerViewAdapter(
    private val values: List<TagDataModel>
) : RecyclerView.Adapter<TagItemRecyclerViewAdapter.ViewHolder>() {

    companion object {
        const val TAG_BIG = 0
        const val TAG_SMALL = 1
    }

    private var tagViewType = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = when(tagViewType) {
            TAG_BIG -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_tag_big, parent, false)
            }
            TAG_SMALL -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_tag_small, parent, false)
            }
            else -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_tag_big, parent, false)
            }
        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.tagTextView.text = item.text
        holder.setBackgroundTint(item.backgroundColor)
    }

    override fun getItemCount(): Int = values.size

    fun setItemViewType(viewType: Int) {
        tagViewType = viewType
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val view = view
        val tagTextView: TextView = view.findViewById(R.id.tag_name)
        private val tagContainerView: FrameLayout = view.findViewById(R.id.tag_container)

        fun setBackgroundTint(color: Int) {
            tagContainerView.backgroundTintList = ContextCompat.getColorStateList(view.context, color)
        }

        override fun toString(): String {
            return super.toString() + " '" + tagTextView.text + "'"
        }
    }
}