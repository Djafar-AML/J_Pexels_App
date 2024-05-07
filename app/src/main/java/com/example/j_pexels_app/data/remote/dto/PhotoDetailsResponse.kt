package com.example.j_pexels_app.data.remote.dto

import com.squareup.moshi.Json

data class PhotoDetailsResponse(
    val id: Long = 0,
    val width: Int = 0,
    val height: Int = 0,
    val url: String = "",
    val photographer: String = "",
    @Json(name = "photographer_url")
    val photographerUrl: String = "",
    @Json(name = "photographer_id")
    val photographerId: Int = 0,
    @Json(name = "avg_color")
    val avgColor: String = "",
    @Json(name = "src")
    val imageSource: ImageSource = ImageSource(),
    val liked: Boolean = false,
    @Json(name = "alt")
    val contentDescription: String = ""
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