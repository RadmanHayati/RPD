package com.codinginflow.exchangeApp.ui.exchangeDetails

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.codinginflow.exchangeApp.R
import com.codinginflow.exchangeApp.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment: Fragment(R.layout.fragment_details)  {
    private val viewModel by viewModels<DetailsViewModel>()
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<DetailsFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentDetailsBinding.bind(view)
        binding.apply {
            val currency = args.selectedCurrency
            viewModel.loadCurrencyInfo(currency.name)
            viewModel.currencyInfo.observe(viewLifecycleOwner) { response ->
                if (response.data != null) {
                    Log.i("checkkk", "${response.data.history} ")
                    Glide.with(this@DetailsFragment)
                        .load(currency.image)
                        .error(R.drawable.ic_error)
                        .listener(object : RequestListener<Drawable> {
                            override fun onLoadFailed(
                                e: GlideException?,
                                model: Any?,
                                target: com.bumptech.glide.request.target.Target<Drawable>?,
                                isFirstResource: Boolean
                            ): Boolean {
                                TODO("Not yet implemented")
                            }
                            override fun onResourceReady(
                                resource: Drawable?,
                                model: Any?,
                                target: Target<Drawable>?,
                                dataSource: DataSource?,
                                isFirstResource: Boolean
                            ): Boolean {
                                TODO("Not yet implemented")
                            }
                        }
                        )
                        .into(imageView)
                    textViewDescription.text = currency.name
                    textViewPrice.text = currency.price.toString()
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