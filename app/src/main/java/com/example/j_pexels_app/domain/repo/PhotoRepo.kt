package com.example.j_pexels_app.domain.repo

import com.example.j_pexels_app.domain.model.PhotoDetails

interface PhotoRepo {
    suspend fun getPhotoDetails(photoId: Long): PhotoDetails

}