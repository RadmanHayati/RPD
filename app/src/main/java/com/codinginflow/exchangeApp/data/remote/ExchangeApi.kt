package com.codinginflow.exchangeApp.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface ExchangeApi {

    @GET("currency")
    suspend fun getCurrenciesList(): Any

    @GET("currency/{name}")
    suspend fun getCurrencyInfo(
        @Path("name") name: String
    ): Any
}