package com.rpicturedictionary.rpd.ui.gallery

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.rpicturedictionary.rpd.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryFragment : Fragment(R.layout.fragment_gallery) {
    private val viewModel by viewModels<GalleryViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      viewModel.photos.observe(viewLifecycleOwner){

      }
    }

}