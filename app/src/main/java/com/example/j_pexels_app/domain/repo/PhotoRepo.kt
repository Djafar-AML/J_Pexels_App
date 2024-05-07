package com.example.j_pexels_app.domain.repo

import androidx.paging.PagingData
import com.example.j_pexels_app.domain.model.Photo
import kotlinx.coroutines.flow.Flow

interface PhotoRepo {
    fun getPhotos(): Flow<PagingData<Photo>>

}