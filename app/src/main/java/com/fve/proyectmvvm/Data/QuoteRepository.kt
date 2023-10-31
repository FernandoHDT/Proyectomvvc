package com.fve.proyectmvvm.Data

import com.fve.proyectmvvm.Data.Model.QuoteModel
import com.fve.proyectmvvm.Data.Model.QuoteProvider
import com.fve.proyectmvvm.Data.Network.QuoteService


class QuoteRepository () {

    private val api = QuoteService()
    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}