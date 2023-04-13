package com.example.store.remote

import com.example.store.models.StoreModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("product")
    suspend fun storeApi(): Response<List<StoreModel>>
}