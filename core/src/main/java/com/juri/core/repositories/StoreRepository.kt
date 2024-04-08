package com.juri.core.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.juri.core.local.StoreDao
import com.juri.core.local.entities.DbProduct
import com.juri.core.remote.StoreClient
import com.juri.core.util.NetworkResult
import com.juri.core.util.toDbModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

interface StoreRepository {

    suspend fun fetchRemoteProducts(): NetworkResult<Boolean>

    fun getSavedProducts() : LiveData<List<DbProduct>>

    fun getTest(): MutableLiveData<String>

}

class StoreRepositoryImpl @Inject constructor(
    private val storeClient: StoreClient,
    private val storeDao: StoreDao,
    private val dispatcher: CoroutineDispatcher
) : StoreRepository {

    val products = storeDao.getProducts()
    override suspend fun fetchRemoteProducts(): NetworkResult<Boolean> = with(dispatcher) {
        val result = storeClient.getAllProducts()
        if (result.isSuccessful && result.errorBody() == null) {

            storeDao.insertProducts(*result.body()!!.toDbModel())
            NetworkResult.Success(true)
        } else {
            NetworkResult.Error(result.message())
        }
    }

    override fun getSavedProducts(): LiveData<List<DbProduct>> {
        return storeDao.getProducts()
    }

    override fun getTest(): MutableLiveData<String> {
        return MutableLiveData("aede")
    }

}