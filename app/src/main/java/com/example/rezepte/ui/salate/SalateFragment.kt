package com.example.rezepte.ui.salate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rezepte.adapters.SalateAdapter
import com.example.rezepte.data.salateList
import com.example.rezepte.databinding.FragmentSalateBinding

class SalateFragment : Fragment() {

    private var _binding: FragmentSalateBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentSalateBinding.inflate(inflater, container, false)
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
        val rezepte = salateList(resources)

        val recyclerView = binding.salateRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = SalateAdapter(rezepte)
    }
}

