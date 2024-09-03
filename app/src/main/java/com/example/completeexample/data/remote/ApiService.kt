package com.example.completeexample.data.remote

import com.example.completeexample.data.model.CustomImage
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("posts/")
    suspend fun getAllImages(): List<CustomImage>
}