package com.juri.core.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.juri.core.local.entities.DbCart
import com.juri.core.local.entities.DbProduct

@Dao
interface StoreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(vararg products: DbProduct)

    @Query("SELECT * FROM DbProduct")
    fun getProducts(): LiveData<List<DbProduct>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToCart(vararg cart: DbCart)

    @Query("SELECT * FROM DbCart")
    fun getCartItems(): LiveData<List<DbCart>>

    @Query("DELETE FROM DbCart WHERE productId=:id")
    suspend fun deleteItemWithId(id: Long)

    @Query("SELECT * FROM DbProduct WHERE id=:key")
    suspend fun getProductWithId(key: Long): DbProduct

}