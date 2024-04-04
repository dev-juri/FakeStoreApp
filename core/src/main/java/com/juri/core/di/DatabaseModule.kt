package com.juri.core.di

import android.app.Application
import androidx.room.Room
import com.juri.core.local.StoreDB
import com.juri.core.local.StoreDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application): StoreDB =
        Room.databaseBuilder(application, StoreDB::class.java, "Store.db")
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideBaseDAO(database: StoreDB): StoreDao = database.storeDao
}