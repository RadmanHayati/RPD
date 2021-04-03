package com.rpicturedictionary.rpd.api

import com.rpicturedictionary.rpd.data.UnsplashPhoto

data class UnsplashResponse(  // unsplash API data class which is a list of UnsplashPhoto data class
    val results: List<UnsplashPhoto>
)