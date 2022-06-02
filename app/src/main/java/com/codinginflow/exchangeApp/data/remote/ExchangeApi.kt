package com.codinginflow.exchangeApp.data.remote

import com.codinginflow.exchangeApp.data.remote.response.Currency
import com.codinginflow.exchangeApp.data.remote.response.History
import retrofit2.http.GET
import retrofit2.http.Path

interface ExchangeApi {

    @GET("currency")
    suspend fun getCurrenciesList(): Currency

    @GET("currency/{name}")
    suspend fun getCurrencyInfo(
        @Path("name") name: String
    ): History
}