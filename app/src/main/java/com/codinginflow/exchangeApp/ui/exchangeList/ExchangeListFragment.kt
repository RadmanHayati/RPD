package com.codinginflow.exchangeApp.ui.exchangeList

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.codinginflow.exchangeApp.R
import com.codinginflow.exchangeApp.data.remote.response.Currency
import com.codinginflow.exchangeApp.databinding.FragmentExchangeListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_exchange_list.*

@AndroidEntryPoint
class ExchangeListFragment : Fragment(R.layout.fragment_exchange_list),
    ExchangeListAdapter.OnItemClickListener {
    private val viewModel by viewModels<ExchangeListViewModel>()
    private var _binding: FragmentExchangeListBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentExchangeListBinding.bind(view)
        val adapter = ExchangeListAdapter(this)
        viewModel.loadCurrenciesList()
        binding.apply {
            recycler_view.setHasFixedSize(true)
            recycler_view.adapter = adapter
//            buttonRetry.setOnClickListener {
//                adapter.retry()
//            }
            viewModel.currencies.observe(viewLifecycleOwner) { response ->
                Log.i("checkk", "onViewCreated: ${response.data}")
                if (response.data != null) {
                    adapter.submitList(response.data)
                }
            }
            viewModel.isLoading.observe(viewLifecycleOwner) { response ->
                when (response) {
                    true -> {}
                    false -> {}
                }

            }
            viewModel.loadError.observe(viewLifecycleOwner) {
                if (it.isNotEmpty()) {
                    // txt_error = it
                }
            }
        }

    }

    override fun onItemClick(Currency: Currency) {
        val action = ExchangeListFragmentDirections.actionExchangeListFragment2ToDetailsFragment(Currency)
        findNavController().navigate(action)
    }
}