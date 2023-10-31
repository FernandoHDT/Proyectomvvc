package com.fve.proyectmvvm.Domain

import com.fve.proyectmvvm.Data.Model.QuoteModel
import com.fve.proyectmvvm.Data.QuoteRepository

class GetQuotesUseCase () {
    private val repository = QuoteRepository()
    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()

}