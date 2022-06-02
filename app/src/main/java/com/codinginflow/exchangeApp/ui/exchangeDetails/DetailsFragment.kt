package com.codinginflow.exchangeApp.ui.exchangeDetails

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.codinginflow.exchangeApp.R
import com.codinginflow.exchangeApp.databinding.FragmentDetailsBinding
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_details.*


@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {
    private val viewModel by viewModels<DetailsViewModel>()
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<DetailsFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentDetailsBinding.bind(view)
        binding.apply {
            val currency = args.selectedCurrency
            Log.i("checkkk", "arg is here ${currency.name} ")
            viewModel.loadCurrencyInfo(currency.name)
            viewModel.currencyInfo.observe(viewLifecycleOwner) { response ->
                Log.i("checkkk", "no data ? ${response.data} ")
                if (response.data != null) {
                    //  Log.i("checkkk", "${response.data.prices} ")
                    Glide.with(this@DetailsFragment)
                        .load(currency.image)
                        .error(R.drawable.ic_error)
//                        .listener(object : RequestListener<Drawable> {
//                            override fun onLoadFailed(
//                                e: GlideException?,
//                                model: Any?,
//                                target: com.bumptech.glide.request.target.Target<Drawable>?,
//                                isFirstResource: Boolean
//                            ): Boolean {
//                                TODO("Not yet implemented")
//                            }
//                            override fun onResourceReady(
//                                resource: Drawable?,
//                                model: Any?,
//                                target: Target<Drawable>?,
//                                dataSource: DataSource?,
//                                isFirstResource: Boolean
//                            ): Boolean {
//                                TODO("Not yet implemented")
//                            }
//                        }
//                        )
                        .into(imageView)
                    textViewDescription.text = currency.name
                    textViewPrice.text = currency.price.toString()
                    // on below line we are adding data to our graph view.

                    // on below line we are adding data to our graph view.
                    var dataPoints = arrayOf(
                        // each point on our x and y axis.
                        DataPoint(0.0, response.data[0]),
                        DataPoint(1.0, response.data[1]),
                        DataPoint(2.0, response.data[2])
                    )

                    val series = LineGraphSeries(
                        dataPoints
                    )
                    idGraphView.addSeries(series)
                }
            }
            viewModel.isLoading.observe(viewLifecycleOwner) { response ->
                when (response) {
                    true -> {
                        progress_bar.visibility = View.VISIBLE
                    }
                    false -> {
                        progress_bar.visibility = View.INVISIBLE
                    }
                }

            }
            viewModel.loadError.observe(viewLifecycleOwner) {
                if (it.isNotEmpty()) {
                    Toast.makeText(requireContext(), "$it", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}