package com.juri.core.di

import com.juri.core.repositories.CartRepository
import com.juri.core.repositories.StoreRepository
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface CoreComponent {

    fun storeRepository(): StoreRepository

    fun cartRepository(): CartRepository
}