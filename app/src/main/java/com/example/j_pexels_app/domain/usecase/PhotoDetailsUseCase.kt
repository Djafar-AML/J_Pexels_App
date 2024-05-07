package com.example.j_pexels_app.domain.usecase

import com.example.j_pexels_app.domain.model.PhotoDetails
import com.example.j_pexels_app.domain.repo.PhotoRepo


class PhotoDetailsUseCase(
    private val photoRepo: PhotoRepo
) : UseCase<PhotoDetails, Long>() {
    override suspend fun run(params: Long?): PhotoDetails {
        return photoRepo.getPhotoDetails(params!!)
    }
}