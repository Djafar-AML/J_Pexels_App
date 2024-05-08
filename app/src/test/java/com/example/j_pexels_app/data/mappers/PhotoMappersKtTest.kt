package com.example.j_pexels_app.data.mappers

import com.example.j_pexels_app.data.local.PhotoEntity
import com.example.j_pexels_app.data.remote.dto.PhotosResponse
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(org.junit.runners.JUnit4::class)
class PhotoMappersKtTest {

    @Test
    fun `toPhotoEntity returns correct PhotoEntity object`() {
        // Arrange
        val photo = PhotosResponse.Photo(
            id = 1L,
            width = 100,
            height = 200,
            url = "https://example.com/image",
            photographer = "John Doe",
            photographerUrl = "https://example.com/johndoe",
            photographerId = 1L,
            avgColor = "#FFFFFF",
            imageSource = PhotosResponse.Photo.ImageSource(
                original = "https://example.com/original",
                large2x = "https://example.com/large2x",
                large = "https://example.com/large",
                medium = "https://example.com/medium",
                small = "https://example.com/small",
                portrait = "https://example.com/portrait",
                landscape = "https://example.com/landscape",
                tiny = "https://example.com/tiny"
            ),
            liked = true,
            contentDescription = "This is a test image"
        )

        // Act
        val photoEntity = photo.toPhotoEntity()

        // Assert
        assertEquals(1L, photoEntity.id)
        assertEquals(100, photoEntity.width)
        assertEquals(200, photoEntity.height)
        assertEquals("https://example.com/image", photoEntity.url)
        assertEquals("John Doe", photoEntity.photographer)
        assertEquals("https://example.com/johndoe", photoEntity.photographerUrl)
        assertEquals(1L, photoEntity.photographerId)
        assertEquals("#FFFFFF", photoEntity.avgColor)
        assertEquals("https://example.com/original", photoEntity.imageSource.original)
        assertEquals("https://example.com/large2x", photoEntity.imageSource.large2x)
        assertEquals("https://example.com/large", photoEntity.imageSource.large)
        assertEquals("https://example.com/medium", photoEntity.imageSource.medium)
        assertEquals("https://example.com/small", photoEntity.imageSource.small)
        assertEquals("https://example.com/portrait", photoEntity.imageSource.portrait)
        assertEquals("https://example.com/landscape", photoEntity.imageSource.landscape)
        assertEquals("https://example.com/tiny", photoEntity.imageSource.tiny)
        assertEquals(true, photoEntity.liked)
        assertEquals("This is a test image", photoEntity.contentDescription)

    }

    @Test
    fun `toPhoto returns correct Photo object`() {
        // Arrange
        val photoEntity = PhotoEntity(
            id = 1L,
            width = 100,
            height = 200,
            url = "https://example.com/image",
            photographer = "John Doe",
            photographerUrl = "https://example.com/johndoe",
            photographerId = 1L,
            avgColor = "#FFFFFF",
            imageSource = PhotoEntity.ImageSource(
                original = "https://example.com/original",
                large2x = "https://example.com/large2x",
                large = "https://example.com/large",
                medium = "https://example.com/medium",
                small = "https://example.com/small",
                portrait = "https://example.com/portrait",
                landscape = "https://example.com/landscape",
                tiny = "https://example.com/tiny"
            ),
            liked = true,
            contentDescription = "This is a test image"
        )

        // Act
        val photo = photoEntity.toPhoto()

        // Assert
        assertEquals(1L, photo.id)
        assertEquals(100, photo.width)
        assertEquals(200, photo.height)
        assertEquals("https://example.com/image", photo.url)
        assertEquals("John Doe", photo.photographer)
        assertEquals("https://example.com/johndoe", photo.photographerUrl)
        assertEquals(1L, photo.photographerId)
        assertEquals("#FFFFFF", photo.avgColor)
        assertEquals("https://example.com/original", photo.imageSource.original)
        assertEquals("https://example.com/large2x", photo.imageSource.large2x)
        assertEquals("https://example.com/large", photo.imageSource.large)
        assertEquals("https://example.com/medium", photo.imageSource.medium)
        assertEquals("https://example.com/small", photo.imageSource.small)
        assertEquals("https://example.com/portrait", photo.imageSource.portrait)
        assertEquals("https://example.com/landscape", photo.imageSource.landscape)
        assertEquals("https://example.com/tiny", photo.imageSource.tiny)
        assertEquals(true, photo.liked)
        assertEquals("This is a test image", photo.contentDescription)
    }

}