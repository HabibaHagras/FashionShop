package com.example.fashionshop

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fashionshop.databinding.FragmentSettingBinding

class SettingFragment : Fragment(), OnBackPressedListener  {

    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Access your views using binding
        binding.AddressButton.setOnClickListener {
            val secondFragment = AddressFragment()
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.nav_host_fragment, secondFragment)
                addToBackStack(null)
                commit()
            }
        }

        binding.CurrencyButton.setOnClickListener {
            showCurrencyDialog()
        }

        binding.AboutUsButton.setOnClickListener {
            val secondFragment = AboutFragment()
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.nav_host_fragment, secondFragment)
                addToBackStack(null)
                commit()
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onBackPressed() {
        parentFragmentManager.popBackStack()
    }
    private fun showCurrencyDialog() {
        val options = arrayOf("EGY", "USD")
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Choose Currency")
            .setItems(options) { dialog, which ->
                val selectedCurrency = options[which]
                Toast.makeText(requireContext(), "Selected: $selectedCurrency", Toast.LENGTH_SHORT).show()
                // Handle the selection (e.g., store the selected currency or update the UI)
            }
        builder.create().show()
    }
}
