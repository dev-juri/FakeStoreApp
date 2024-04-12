package com.juri.home.domain

data class DomainProduct(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Double,
    val title: String
)
