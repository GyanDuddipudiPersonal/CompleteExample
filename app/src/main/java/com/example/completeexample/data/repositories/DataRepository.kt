package com.example.completeexample.data.repositories

import com.example.completeexample.data.local.db.ImageDao
import com.example.completeexample.data.local.db.ImageEntity
import com.example.completeexample.data.model.CustomImage
import com.example.completeexample.data.remote.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val apiService: ApiService, private val imageDao: ImageDao
) {

    suspend fun getAllImages(): List<CustomImage> = withContext(Dispatchers.IO) {
        var images = imageDao.getAllImages()
            .map { CustomImage(userId = it.userId, id = it.id, title = it.title, body = it.body) }
        if (images.isEmpty()) {
            images = apiService.getAllImages()
            imageDao.insertAll(images.map {
                ImageEntity(
                    userId = it.userId, id = it.id, title = it.title, body = it.body
                )
            })

        }
        return@withContext images
    }
}