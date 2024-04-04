package com.juri.core.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.juri.core.local.entities.DbCart
import com.juri.core.local.entities.DbProduct

@Database(
    entities = [DbProduct::class, DbCart::class],
    version = 1,
    exportSchema = false
)
abstract class StoreDB : RoomDatabase() {
    abstract val storeDao: StoreDao
}