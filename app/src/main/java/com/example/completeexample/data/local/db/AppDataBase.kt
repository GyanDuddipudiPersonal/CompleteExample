package com.example.completeexample.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ImageEntity::class], version = 2, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun imageDao(): ImageDao
}