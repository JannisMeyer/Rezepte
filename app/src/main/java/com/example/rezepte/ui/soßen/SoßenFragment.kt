package com.example.rezepte.ui.soßen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.rezepte.databinding.FragmentSossenBinding

class SoßenFragment : Fragment() {

    private var _binding: FragmentSossenBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(SoßenViewModel::class.java)

        _binding = FragmentSossenBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSossen
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}