package com.example.j_pexels_app.data.remote.repo


import com.example.j_pexels_app.data.remote.api.PexelsApi
import com.example.j_pexels_app.data.remote.dto.PhotoDetailsResponse
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any

class PhotoRepoImplTest {

    @Mock
    private lateinit var api: PexelsApi

    private lateinit var photoRepoImpl: PhotoRepoImpl

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        photoRepoImpl = PhotoRepoImpl(api)
    }

    @Test
    fun `test getPhotoDetails`(): Unit = runBlocking {
        // Given
        val photoId = 1L
        val expectedResponse = PhotoDetailsResponse()
        Mockito.`when`(api.getPhotoDetails(any(), any())).thenReturn(expectedResponse)

        // When
        photoRepoImpl.getPhotoDetails(photoId)

        // Then
        Mockito.verify(api).getPhotoDetails(any(), any())

    }
}
