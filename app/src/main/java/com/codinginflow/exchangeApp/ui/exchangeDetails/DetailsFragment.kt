package com.codinginflow.exchangeApp.ui.exchangeDetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.codinginflow.exchangeApp.R
import com.codinginflow.exchangeApp.databinding.FragmentDetailsBinding

class DetailsFragment: Fragment(R.layout.fragment_details)  {
    private val viewModel by viewModels<DetailsViewModel>()
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentDetailsBinding.bind(view)
        binding.apply {
            viewModel.currencyInfo.observe(viewLifecycleOwner) { response ->
                if (response.data != null) {
                    //   adapter.submitList(response.data)
                }
            }
            viewModel.isLoading.observe(viewLifecycleOwner) { response ->
                when(response){
                    true -> {  }
                    false -> { }
                }

            }
            viewModel.loadError.observe(viewLifecycleOwner){
                if (it.isNotEmpty()){
                    // txt_error = it
                }
            }
        }

    }
}