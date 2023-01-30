package com.example.rezepte.ui.zusaetze

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rezepte.adapters.ZusaetzeAdapter
import com.example.rezepte.data.zusaetzeList
import com.example.rezepte.databinding.FragmentZusaetzeBinding

class ZusaetzeFragment : Fragment() {

    private var _binding: FragmentZusaetzeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentZusaetzeBinding.inflate(inflater, container, false)
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
        val rezepte = zusaetzeList(resources)

        val recyclerView = binding.zusaetzeRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ZusaetzeAdapter(rezepte)
    }
}
