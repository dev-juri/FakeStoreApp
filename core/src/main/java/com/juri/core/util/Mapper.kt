package com.juri.core.util

import com.juri.core.local.entities.DbProduct
import com.juri.core.remote.Product

fun List<Product>.toDbModel(): Array<DbProduct> {
    return this.map {
        DbProduct(
            id = it.id,
            title = it.title,
            price = it.price,
            description = it.description,
            category = it.category,
            image = it.image,
            rating = it.rating.rate
        )
    }.toTypedArray()
}