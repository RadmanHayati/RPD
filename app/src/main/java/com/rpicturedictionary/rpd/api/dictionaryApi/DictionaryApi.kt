package com.rpicturedictionary.rpd.api.dictionaryApi

import com.rpicturedictionary.rpd.BuildConfig
import com.rpicturedictionary.rpd.api.UnsplashResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface DictionaryApi {
    companion object {
        const val BASE_URL = "https://api.dictionaryapi.dev/api/v2/entries/en/"
    }

    @GET
    suspend fun searchWord(
        @Url() url: String,
    ): DictionaryResponse
}