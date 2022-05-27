package com.rpicturedictionary.rpd.data

import com.rpicturedictionary.rpd.api.dictionaryApi.DictionaryApi
import com.rpicturedictionary.rpd.api.dictionaryApi.DictionaryResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DictionaryRepository @Inject constructor(private val dictionaryApi: DictionaryApi) {

    suspend fun getSearchResult(query: String): DictionaryResponse {
        return dictionaryApi.searchWord(DictionaryApi.BASE_URL + query)
    }
}