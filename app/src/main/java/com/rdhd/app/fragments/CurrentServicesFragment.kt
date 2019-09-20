package com.rdhd.app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.rdhd.app.R
import com.rdhd.app.adapters.CurrentServiceAdapter
import com.rdhd.app.adapters.PassedServiceAdapter
import kotlinx.android.synthetic.main.fragment_current_services.*

class CurrentServicesFragment  : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_current_services, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(context!!)
        recyclerView.adapter = CurrentServiceAdapter()
    }

}