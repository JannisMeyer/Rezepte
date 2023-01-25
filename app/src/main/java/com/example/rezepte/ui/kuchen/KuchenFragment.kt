package com.example.rezepte.ui.kuchen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.rezepte.databinding.FragmentKuchenBinding

class KuchenFragment : Fragment() {

    private var _binding: FragmentKuchenBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val kuchenViewModel =
            ViewModelProvider(this).get(KuchenViewModel::class.java)

        _binding = FragmentKuchenBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textKuchen
        kuchenViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}