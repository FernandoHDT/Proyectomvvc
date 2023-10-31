package com.fve.proyectmvvm.Data.Network

import com.fve.proyectmvvm.Data.Model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}