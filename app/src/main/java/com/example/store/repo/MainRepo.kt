package com.example.store.repo

import com.example.store.models.StoreModel
import com.example.store.remote.ApiInterface
import com.example.store.util.ApiResponse
import javax.inject.Inject

class MainRepo @Inject constructor(private val apiInterface: ApiInterface) {
    suspend fun fetchData(): ApiResponse<List<StoreModel>?>{
        val response = apiInterface.storeApi()
        return if (response.isSuccessful){
            ApiResponse.Success(response.body())
        }else{
            ApiResponse.Error(response.message())
        }
    }
}