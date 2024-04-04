package com.juri.core.di

import com.juri.core.local.StoreDB
import com.juri.core.local.StoreDao
import com.juri.core.remote.StoreClient
import com.juri.core.repositories.CartRepository
import com.juri.core.repositories.CartRepositoryImpl
import com.juri.core.repositories.StoreRepository
import com.juri.core.repositories.StoreRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun providesStoreRepository(
        storeClient: StoreClient,
        storeDao: StoreDao,
        dispatcher: CoroutineDispatcher
    ) = StoreRepositoryImpl(storeClient, storeDao, dispatcher) as StoreRepository

    @Provides
    @Singleton
    fun providesCartRepository(
        storeDao: StoreDao,
        dispatcher: CoroutineDispatcher
    ) = CartRepositoryImpl(storeDao, dispatcher) as CartRepository
}