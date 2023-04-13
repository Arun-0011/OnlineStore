package com.example.store.store.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.store.models.StoreModel
import com.example.store.repo.MainRepo
import com.example.store.util.ApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoreViewModel @Inject constructor(private val repo: MainRepo) : ViewModel() {
    private val _storeResponse: MutableSharedFlow<ApiResponse<List<StoreModel>?>> =
        MutableSharedFlow()
    val storeResponse: SharedFlow<ApiResponse<List<StoreModel>?>> = _storeResponse

    fun fetchData() {
        viewModelScope.launch {
            val response = repo.fetchData()
            _storeResponse.emit(response)
        }
    }
}