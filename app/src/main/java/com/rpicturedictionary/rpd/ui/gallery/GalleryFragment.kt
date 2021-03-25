package com.rpicturedictionary.rpd.ui.gallery

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.rpicturedictionary.rpd.R
import com.rpicturedictionary.rpd.databinding.FragmentGalleryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryFragment : Fragment(R.layout.fragment_gallery) {
    private val viewModel by viewModels<GalleryViewModel>()
    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       _binding = FragmentGalleryBinding.bind(view)
        val adapter = UnsplashPhotoAdapter()
         binding.apply {
           recyclerView.setHasFixedSize(true)
             recyclerView.adapter = adapter
        }
        viewModel.photos.observe(viewLifecycleOwner) {
            // adapter.submitData(viewLifecycleOwner.lifecycle, it)
            Toast.makeText(activity,"$it",Toast.LENGTH_LONG).show()
        }
    }

    /*override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/
}