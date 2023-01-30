package com.example.rezepte.ui.kuchen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rezepte.adapters.KuchenAdapter
import com.example.rezepte.data.kuchenList
import com.example.rezepte.databinding.FragmentKuchenBinding

class KuchenFragment : Fragment() {

    private var _binding: FragmentKuchenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentKuchenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showRezepte()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showRezepte() {
        val rezepte = kuchenList(resources)

        val recyclerView = binding.kuchenRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = KuchenAdapter(rezepte)
    }
}