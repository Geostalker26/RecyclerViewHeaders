package com.brent26.smith.stickyheaderpractice

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.shuhart.stickyheader.StickyAdapter

import java.util.ArrayList

class SectionAdapter (
    private val sectionArrayList: ArrayList<Section>
)// inflater = LayoutInflater.from(context);
// this.context = context;
    : StickyAdapter<RecyclerView.ViewHolder, RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return if (viewType == LAYOUT_HEADER) {
            HeaderViewholder(inflater.inflate(R.layout.header, parent, false))
        } else {
            ItemViewHolder(inflater.inflate(R.layout.recycler_view_item, parent, false))
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (sectionArrayList[position].isHeader) {
            (holder as HeaderViewholder).textView.text = sectionArrayList[position].name
        } else {
            (holder as ItemViewHolder).textView.text = sectionArrayList[position].name
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (sectionArrayList[position].isHeader) {
            LAYOUT_HEADER
        } else
            LAYOUT_CHILD
    }

    override fun getItemCount(): Int {
        return sectionArrayList.size
    }

    override fun getHeaderPositionForItem(itemPosition: Int): Int {
        Log.d("seeee", "" + itemPosition + "......" + sectionArrayList[itemPosition].sectionPosition())
        return sectionArrayList[itemPosition].sectionPosition()
    }

    @SuppressLint("SetTextI18n")
    override fun onBindHeaderViewHolder(holder: RecyclerView.ViewHolder, headerPosition: Int) {
        (holder as HeaderViewholder).textView.text = sectionArrayList[headerPosition].name
    }

    override fun onCreateHeaderViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return createViewHolder(parent, LAYOUT_HEADER)
    }

    class HeaderViewholder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var textView: TextView = itemView.findViewById(R.id.text_view)

    }

    class ItemViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var textView: TextView = itemView.findViewById(R.id.text_view)
    }

    companion object {
        private const val LAYOUT_HEADER = 0
        private const val LAYOUT_CHILD = 1
    }
}
