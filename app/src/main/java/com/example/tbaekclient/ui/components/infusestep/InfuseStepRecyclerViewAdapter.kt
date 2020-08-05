package com.example.tbaekclient.ui.components.infusestep

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.tbaekclient.R

import com.example.tbaekclient.ui.components.infusestep.dummy.DummyContent.DummyItem

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class InfuseStepRecyclerViewAdapter(
    private val values: List<String>
) : RecyclerView.Adapter<InfuseStepRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_infuse_step, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.stepTextView.text = (position + 1).toString() + ". " + item
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val stepTextView: TextView = view.findViewById(R.id.infuse_step_text)

        override fun toString(): String {
            return super.toString() + " '" + stepTextView.text + "'"
        }
    }
}