package com.rpicturedictionary.rpd.ui.gallery

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.rpicturedictionary.rpd.api.dictionaryApi.DictionaryResponse
import com.rpicturedictionary.rpd.data.DictionaryRepository
import com.rpicturedictionary.rpd.data.UnsplashRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class GalleryViewModel @ViewModelInject constructor(
    private val repository: UnsplashRepository,
    private val dictionaryRepository: DictionaryRepository
) : ViewModel() {
    private val currentQuery = MutableLiveData(DEFAULT_QUERY)
   // val words: MutableLiveData<DictionaryResponse>? = null
    val words = MutableLiveData<DictionaryResponse>()
    val photos = currentQuery.switchMap { queryString ->
        repository.getSearchResult(queryString).cachedIn(viewModelScope)
        // repository.getSearchResult("apple").cachedIn(viewModelScope)
    }

    fun searchPhotos(query: String) {
        currentQuery.value = query
        viewModelScope.launch {
            try {
                val result = dictionaryRepository.getSearchResult(query)
                words.postValue(result)
                Log.i("check", "searchPhotos: ${result}")
            } catch (e: Exception) {
                Log.i("check", "$e")
            }
        }
    }


    companion object {
        private const val DEFAULT_QUERY = "cats"
    }

}