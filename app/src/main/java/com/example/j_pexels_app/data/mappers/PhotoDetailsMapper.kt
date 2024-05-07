package com.example.j_pexels_app.data.mappers

import com.example.j_pexels_app.data.remote.dto.PhotoDetailsResponse
import com.example.j_pexels_app.domain.model.PhotoDetails


fun PhotoDetailsResponse.toPhotoDetails(): PhotoDetails {
    return PhotoDetails(
        id = id,
        width = width,
        height = height,
        url = url,
        photographer = photographer,
        photographerUrl = photographerUrl,
        photographerId = photographerId,
        avgColor = avgColor,
        imageSource = PhotoDetails.ImageSource(
            original = imageSource.original,
            large2x = imageSource.large2x,
            large = imageSource.large,
            medium = imageSource.medium,
            small = imageSource.small,
            portrait = imageSource.portrait,
            landscape = imageSource.landscape,
            tiny = imageSource.tiny
        ),
        liked = liked,
        contentDescription = contentDescription,
    )
}