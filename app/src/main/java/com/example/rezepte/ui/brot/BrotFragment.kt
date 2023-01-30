package com.example.rezepte.ui.brot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rezepte.adapters.BroteAdapter
import com.example.rezepte.data.broteList
import com.example.rezepte.databinding.FragmentBrotBinding

class BrotFragment : Fragment() {

    private var _binding: FragmentBrotBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentBrotBinding.inflate(inflater, container, false)
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
        val rezepte = broteList(resources)

        val recyclerView = binding.brotRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = BroteAdapter(rezepte)
    }
}