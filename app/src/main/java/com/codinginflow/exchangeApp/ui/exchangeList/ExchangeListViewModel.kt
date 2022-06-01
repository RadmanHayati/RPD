package com.codinginflow.exchangeApp.ui.exchangeList

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codinginflow.exchangeApp.repository.ExchangeRepository
import com.codinginflow.exchangeApp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExchangeListViewModel @Inject constructor(
    private val repository: ExchangeRepository
) : ViewModel() {
    val currencies = MutableLiveData<Resource<Any>>()
    val isLoading = MutableLiveData(false)
    val loadError = MutableLiveData<String>()
    fun loadCurrenciesList() {
        // currentQuery.value = query
        isLoading.value = true
        viewModelScope.launch {
            val result = repository.getCurrenciesList()
            when (result) {
                is Resource.Success -> {
                    loadError.value = ""
                    isLoading.value = false
                    currencies.postValue(result)
                }
                is Resource.Error -> {
                    loadError.value = result.message
                    isLoading.value = false
                }
            }

        }
    }
}