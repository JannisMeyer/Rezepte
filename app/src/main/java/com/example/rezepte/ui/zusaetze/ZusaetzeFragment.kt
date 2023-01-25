package com.example.rezepte.ui.zusaetze

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.rezepte.databinding.FragmentZusaetzeBinding


class ZusaetzeFragment : Fragment() {

    private var _binding: FragmentZusaetzeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val zusaetzeViewModel =
            ViewModelProvider(this).get(ZusaetzeViewModel::class.java)

        _binding = FragmentZusaetzeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textZusaetze
        zusaetzeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}