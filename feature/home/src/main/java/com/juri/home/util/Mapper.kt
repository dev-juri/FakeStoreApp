package com.juri.home.util

import com.juri.core.local.entities.DbProduct
import com.juri.core.remote.Product
import com.juri.home.domain.DomainProduct


fun List<DbProduct>.fromDbModel(): Array<DomainProduct> {
    return this.map {
        DomainProduct(
            id = it.id,
            title = it.title,
            price = it.price,
            description = it.description,
            category = it.category,
            image = it.image,
            rating = it.rating
        )
    }.toTypedArray()
}