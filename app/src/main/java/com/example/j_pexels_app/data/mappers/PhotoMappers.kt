package com.example.j_pexels_app.data.mappers

import com.example.j_pexels_app.data.local.PhotoEntity
import com.example.j_pexels_app.data.remote.dto.PhotosResponse
import com.example.j_pexels_app.domain.model.Photo

fun PhotosResponse.Photo.toPhotoEntity(): PhotoEntity {
    return PhotoEntity(
        id = id,
        width = width,
        height = height,
        url = url,
        photographer = photographer,
        photographerUrl = photographerUrl,
        photographerId = photographerId,
        avgColor = avgColor,
        imageSource = PhotoEntity.ImageSource(
            original = imageSource.original,
            large2x = imageSource.large2x,
            large = imageSource.large,
            medium = imageSource.medium,
            small = imageSource.small,
            portrait = imageSource.portrait,
            landscape = imageSource.landscape,
            tiny = imageSource.tiny,
        ),
        liked = liked,
        contentDescription = contentDescription,
    )
}

fun PhotoEntity.toPhoto(): Photo {
    return Photo(
        id = id,
        width = width,
        height = height,
        url = url,
        photographer = photographer,
        photographerUrl = photographerUrl,
        photographerId = photographerId,
        avgColor = avgColor,
        imageSource = Photo.ImageSource(
            original = imageSource.original,
            large2x = imageSource.large2x,
            large = imageSource.large,
            medium = imageSource.medium,
            small = imageSource.small,
            portrait = imageSource.portrait,
            landscape = imageSource.landscape,
            tiny = imageSource.tiny,
        ),
        liked = liked,
        contentDescription = contentDescription,
    )
}