package com.example.rezepte.ui.hauptgerichte

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rezepte.adapters.HauptgerichteAdapter
import com.example.rezepte.data.hauptgerichteList
import com.example.rezepte.databinding.FragmentHauptgerichteBinding

class HauptgerichteFragment : Fragment() {

    private var _binding: FragmentHauptgerichteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHauptgerichteBinding.inflate(inflater, container, false)
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
        val rezepte = hauptgerichteList(resources)

        val recyclerView = binding.hauptgerichteRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = HauptgerichteAdapter(rezepte)
    }
}