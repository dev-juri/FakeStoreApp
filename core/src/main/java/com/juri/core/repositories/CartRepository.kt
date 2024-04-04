package com.juri.core.repositories

import com.juri.core.local.StoreDao
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

interface CartRepository {
}

class CartRepositoryImpl @Inject constructor(
    private val storeDao: StoreDao,
    private val dispatcher: CoroutineDispatcher
) : CartRepository {

}