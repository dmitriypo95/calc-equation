package com.dmitriypo95.srs10

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistoryViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(history: History) {
        val equationTextView: TextView = itemView.findViewById(R.id.equation_text_view)
        val resultTextView:TextView = itemView.findViewById(R.id.result_text_view)

        equationTextView.text = history.equation
        resultTextView.text = "Результат: ${history.result}"
    }
}