package com.codinginflow.exchangeApp.repository

import com.codinginflow.exchangeApp.data.remote.ExchangeApi
import com.codinginflow.exchangeApp.data.remote.response.History
import com.codinginflow.exchangeApp.util.Resource
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.Exception

@Singleton
class ExchangeRepository @Inject constructor(
    private val api: ExchangeApi
) {
    suspend fun getCurrenciesList(): Resource<Any> {
        val response = try {
            api.getCurrenciesList()
        } catch (e: Exception) {
            return Resource.Error("Sth went wrong!")
        }
        return Resource.Success(response)
    }

    suspend fun getCurrencyInfo(CurrencyName: String): Resource<History> {
        val response = try {
            api.getCurrencyInfo(name = CurrencyName)
        } catch (e: Exception) {
            return Resource.Error("Sth went wrong!")
        }
        return Resource.Success(response)
    }


}