package com.codinginflow.exchangeApp.ui.exchangeDetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codinginflow.exchangeApp.data.remote.response.History
import com.codinginflow.exchangeApp.repository.ExchangeRepository
import com.codinginflow.exchangeApp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: ExchangeRepository
) : ViewModel() {
    val currencyInfo = MutableLiveData<Resource<List<Double>>>()
    val isLoading = MutableLiveData(false)
    val loadError = MutableLiveData<String>()
    val priceList = mutableListOf<Double>()
    fun loadCurrencyInfo(name: String) {
        // currentQuery.value = query
        isLoading.value = true
        viewModelScope.launch {
            val result = repository.getCurrencyInfo(name)
            when (result) {
                is Resource.Success -> {
                    loadError.value = ""
                    isLoading.value = false
                    for (pairs in result.data?.prices!!) {
                        priceList.add(pairs[1])
                    }
                    currencyInfo.postValue(Resource.Success(priceList))
                }
                is Resource.Error -> {
                    loadError.value = result.message
                    isLoading.value = false
                }
            }

        }
    }
}