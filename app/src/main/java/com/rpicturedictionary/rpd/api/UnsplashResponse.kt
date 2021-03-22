package com.rpicturedictionary.rpd.api

import com.rpicturedictionary.rpd.data.UnsplashPhoto

data class UnsplashResponse(
    val result: List<UnsplashPhoto>
)