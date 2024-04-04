package com.juri.core.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "DbCart")
data class DbCart(
    @PrimaryKey(autoGenerate = false) val productId: Long,
    val quantity: Long,
    val image: String,
    val priceOfProduct: Double,
    val productName: String
)

