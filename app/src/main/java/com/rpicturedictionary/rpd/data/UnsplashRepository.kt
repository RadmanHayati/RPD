package com.rpicturedictionary.rpd.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.rpicturedictionary.rpd.api.UnsplashApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepository @Inject constructor(private val unsplashApi: UnsplashApi) {

    fun getSearchResult(query: String) =
        Pager(
            config = PagingConfig(
                pageSize = 20, //params.loadSize() how many items fit on screen
                maxSize = 100,
                enablePlaceholders = false,
            ),
            pagingSourceFactory = { UnsplashPagingSource(unsplashApi, query) }
        ).liveData
}