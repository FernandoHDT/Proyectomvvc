package com.fve.proyectmvvm.UI.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fve.proyectmvvm.Data.Model.QuoteModel
import com.fve.proyectmvvm.Domain.GetQuotesUseCase
import com.fve.proyectmvvm.Domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch




class QuoteViewModel () : ViewModel() {
    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    private val getQuotesUseCase = GetQuotesUseCase()
    private val getRandomQuoteUseCase=  GetRandomQuoteUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()
            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote() {
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()
        if (quote != null) {
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
    }
}
