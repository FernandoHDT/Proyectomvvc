package com.fve.proyectmvvm.Domain

import com.fve.proyectmvvm.Data.Model.QuoteModel
import com.fve.proyectmvvm.Data.Model.QuoteProvider


class GetRandomQuoteUseCase {


    operator fun invoke():QuoteModel?{
        val quotes = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}