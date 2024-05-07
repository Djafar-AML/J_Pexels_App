package com.example.j_pexels_app.data.remote

import androidx.collection.ArrayMap
import androidx.collection.arrayMapOf
import com.example.j_pexels_app.constants.PexelsConsts.HEADER_TOKEN
import com.example.j_pexels_app.data.remote.dto.PhotosResponse
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query

interface PexelsApi {

    @GET("curated")
    suspend fun getPhotos(
        @HeaderMap header: ArrayMap<String, String> = arrayMapOf("Authorization" to HEADER_TOKEN),
        @Query("page") page: Int,
        @Query("per_page") pageCount: Int = 20,
    ): PhotosResponse

}