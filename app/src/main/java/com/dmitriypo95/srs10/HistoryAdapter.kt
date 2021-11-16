package com.dmitriypo95.srs10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class HistoryAdapter(private val historyList: List<History>) :
    RecyclerView.Adapter<HistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val historyListItemView =
            LayoutInflater.from(parent.context).inflate(R.layout.history_list_item, parent, false)
        return HistoryViewHolder(historyListItemView)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val history = historyList[position]
        holder.bind(history)
    }

    override fun getItemCount(): Int {
        return historyList.size
    }
}




