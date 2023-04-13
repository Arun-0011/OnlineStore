package com.example.store.store.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.store.adapters.StoreAdapter
import com.example.store.databinding.ActivityMainBinding
import com.example.store.store.viewmodels.StoreViewModel
import com.example.store.util.ApiResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private val viewModel: StoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        observe()
        storeApi()
    }

    private fun storeApi() {
        viewModel.fetchData()
    }

    private fun observe() {
        lifecycleScope.launch {
            viewModel.storeResponse.collect {
                when (it) {
                    is ApiResponse.Loading -> {

                    }
                    is ApiResponse.Success -> {
                        binding?.recyclerView?.layoutManager =
                            GridLayoutManager(this@MainActivity, 2)
                        val adapter = it.data?.let { it1 -> StoreAdapter(it1) }
                        binding?.recyclerView?.adapter = adapter
                    }
                    is ApiResponse.Error -> {
                        Toast.makeText(
                            this@MainActivity,
                            "Something went wrong",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}