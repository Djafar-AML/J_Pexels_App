package com.example.j_pexels_app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(
    entities = [PhotoEntity::class],
    version = 1,
    exportSchema = false,
)
@TypeConverters(ImageSourceTypeConverter::class)
abstract class PhotoDatabase : RoomDatabase() {
    abstract fun getPhotoDao(): PhotoDao
}