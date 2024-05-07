package com.example.j_pexels_app.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photos")
data class PhotoEntity(
    @PrimaryKey
    val id: Int = 0,
    val width: Int = 0,
    val height: Int = 0,
    val url: String = "",
    val photographer: String = "",
    val photographerUrl: String = "",
    val photographerId: Int = 0,
    val avgColor: String = "",
    val imageSource: ImageSource = ImageSource(),
    val liked: Boolean = false,
    val contentDescription: String = "",
    val totalResults: Int = 0,
) {
    data class ImageSource(
        val original: String = "",
        val large2x: String = "",
        val large: String = "",
        val medium: String = "",
        val small: String = "",
        val portrait: String = "",
        val landscape: String = "",
        val tiny: String = ""
    )
}
