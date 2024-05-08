package com.example.j_pexels_app.data.mappers

import com.example.j_pexels_app.data.remote.dto.PhotoDetailsResponse
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)

class PhotoDetailsMapperKtTest {

    @Test
    fun `toPhotoDetails returns correct PhotoDetails object`() {
        // Arrange
        val response = PhotoDetailsResponse(
            id = 1L,
            width = 100,
            height = 200,
            url = "https://example.com/image",
            photographer = "John Doe",
            photographerUrl = "https://example.com/johndoe",
            photographerId = 1L,
            avgColor = "#FFFFFF",
            imageSource = PhotoDetailsResponse.ImageSource(
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
        val photoDetails = response.toPhotoDetails()

        // Assert
        assertEquals(1L, photoDetails.id)
        assertEquals(100, photoDetails.width)
        assertEquals(200, photoDetails.height)
        assertEquals("https://example.com/image", photoDetails.url)
        assertEquals("John Doe", photoDetails.photographer)
        assertEquals("https://example.com/johndoe", photoDetails.photographerUrl)
        assertEquals(1L, photoDetails.photographerId)
        assertEquals("#FFFFFF", photoDetails.avgColor)
        assertEquals("https://example.com/original", photoDetails.imageSource.original)
        assertEquals("https://example.com/large2x", photoDetails.imageSource.large2x)
        assertEquals("https://example.com/large", photoDetails.imageSource.large)
        assertEquals("https://example.com/medium", photoDetails.imageSource.medium)
        assertEquals("https://example.com/small", photoDetails.imageSource.small)
        assertEquals("https://example.com/portrait", photoDetails.imageSource.portrait)
        assertEquals("https://example.com/landscape", photoDetails.imageSource.landscape)
        assertEquals("https://example.com/tiny", photoDetails.imageSource.tiny)
        assertEquals(true, photoDetails.liked)
        assertEquals("This is a test image", photoDetails.contentDescription)
    }
}