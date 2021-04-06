package com.rpicturedictionary.rpd.api

import com.rpicturedictionary.rpd.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashApi { // the interface would be implemented by retrofit
    companion object {   // base url will be used in paging source where we use retrofit
        const val BASE_URL = "https://api.unsplash.com/"
        const val CLIENT_ID = BuildConfig.UNSPLASH_ACCESS_KEY
    }
    // api key or CLIENT_ID needs to be sent in the header
    @Headers("Accept-Version: v1", "Authorization: Client-ID $CLIENT_ID")
    @GET("search/photos") // the call method is GET and the second part of URL is search/photos
    suspend fun searchPhotos(  // suspend keyword is here to use coroutines
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): UnsplashResponse
}