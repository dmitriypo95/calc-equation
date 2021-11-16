package com.dmitriypo95.srs10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)

        val historyRecyclerView: RecyclerView = view.findViewById(R.id.history_recycler_view)
        historyRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL, false)
        historyRecyclerView.adapter = HistoryAdapter(resultCalcList)

        return view
    }

}