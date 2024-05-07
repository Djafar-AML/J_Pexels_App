package com.example.j_pexels_app.data.remote.repo

import com.example.j_pexels_app.data.mappers.toPhotoDetails
import com.example.j_pexels_app.data.remote.api.PexelsApi
import com.example.j_pexels_app.domain.model.PhotoDetails
import com.example.j_pexels_app.domain.repo.PhotoRepo

class PhotoRepoImpl(
    private val api: PexelsApi,
) : PhotoRepo {
    override suspend fun getPhotoDetails(photoId: Long): PhotoDetails {
        return api.getPhotoDetails(photoId = photoId).toPhotoDetails()
    }
}