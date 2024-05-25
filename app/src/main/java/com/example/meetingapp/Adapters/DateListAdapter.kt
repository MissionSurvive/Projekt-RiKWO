package com.example.meetingapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.meetingapp.Items.DateItem
import com.example.meetingapp.Items.MeetingItem
import com.example.meetingapp.R

class DateListAdapter(private val dateItems: List<DateItem>) : RecyclerView.Adapter<DateListAdapter.DateViewHolder>() {
    private lateinit var meetingListAdapter: MeetingListAdapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.meetings_list_view, parent, false)
        return DateViewHolder(view)
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        val dateItem = dateItems[position]
        holder.bind(dateItem)
    }

    override fun getItemCount(): Int = dateItems.size

    inner class DateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.text)
        val meetingRecyclerView: RecyclerView = itemView.findViewById(R.id.meeting_list_item)

        fun bind(dateItem: DateItem) {
            textView.text = "${dateItem.day} ${dateItem.month}"
            // The MeetingListAdapter will be set in the MainActivity
        }
    }
}