package com.rpicturedictionary.rpd.data

import com.rpicturedictionary.rpd.api.UnsplashApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepository @Inject constructor(private val unsplashApi: UnsplashApi) {

}