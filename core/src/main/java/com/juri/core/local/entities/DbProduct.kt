package com.juri.core.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DbProduct")
data class DbProduct(
    val category: String,
    val description: String,
    @PrimaryKey(autoGenerate = false) val id: Int,
    val image: String,
    val price: Double,
    val rating: Double,
    val title: String
)
