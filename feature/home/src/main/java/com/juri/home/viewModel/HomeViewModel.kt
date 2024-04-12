package com.juri.home.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.juri.core.repositories.StoreRepository
import com.juri.core.util.NetworkResult
import com.juri.home.util.fromDbModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel : ViewModel() {
    @Inject
    lateinit var storeRepo: StoreRepository

    val products = storeRepo.getSavedProducts().map {
        it.fromDbModel()
    }

    private var _status = MutableLiveData<NetworkState>()
    val status get() = _status

    init {
        refreshProducts()
    }

    private fun refreshProducts() {
        _status.value = NetworkState.LOADING
        viewModelScope.launch {
            val result = storeRepo.fetchRemoteProducts()
            when (result) {
                is NetworkResult.Success -> {
                    _status.value = NetworkState.SUCCESS
                }

                is NetworkResult.Error -> {
                    _status.value = NetworkState.ERROR
                }

                else -> {
                    _status.value = NetworkState.LOADING
                }
            }
        }
    }
}

enum class NetworkState {
    SUCCESS, ERROR, LOADING
}