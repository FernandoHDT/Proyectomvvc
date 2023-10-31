package com.fve.proyectmvvm.Data.Network

import com.fve.proyectmvvm.Core.RetrofitHelper
import com.fve.proyectmvvm.Data.Model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class QuoteService  (){

    private val retrofit= RetrofitHelper.getRetrofit()
    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}