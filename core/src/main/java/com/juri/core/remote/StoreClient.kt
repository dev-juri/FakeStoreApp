package com.juri.core.remote

import retrofit2.Response
import retrofit2.http.GET

interface StoreClient {

    @GET("/products")
    suspend fun getAllProducts(): Response<List<Product>>

}