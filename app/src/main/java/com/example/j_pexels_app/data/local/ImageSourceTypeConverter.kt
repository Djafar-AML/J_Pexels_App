package com.example.j_pexels_app.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson

class ImageSourceTypeConverter {

    @TypeConverter
    fun fromImageSource(imageSource: PhotoEntity.ImageSource): String {
        return Gson().toJson(imageSource)
    }

    @TypeConverter
    fun toImageSource(json: String): PhotoEntity.ImageSource {
        return Gson().fromJson(json, PhotoEntity.ImageSource::class.java)
    }

}