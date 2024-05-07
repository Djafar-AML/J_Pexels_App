package com.example.j_pexels_app.data.remote.mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.j_pexels_app.data.local.PhotoDatabase
import com.example.j_pexels_app.data.local.PhotoEntity
import com.example.j_pexels_app.data.mappers.toPhotoEntity
import com.example.j_pexels_app.data.remote.api.PexelsApi


@OptIn(ExperimentalPagingApi::class)
class PexelsRemoteMediator(
    private val pexelsApi: PexelsApi,
    private val pexelsDatabase: PhotoDatabase,
) : RemoteMediator<Int, PhotoEntity>() {

    private val photoDao = pexelsDatabase.getPhotoDao()
    private var nextPage: Int? = 1

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PhotoEntity>
    ): MediatorResult {
        val page = when (loadType) {
            LoadType.REFRESH -> null
            LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
            LoadType.APPEND -> {
                nextPage ?: return MediatorResult.Success(endOfPaginationReached = true)
            }
        }

        try {

            val response = pexelsApi.getPhotos(page = page ?: 1, pageCount = state.config.pageSize)

            nextPage = getNextPage(response.nextPage)
            val photos = response.photos
            val endOfPaginationReached = photos.isEmpty()

            pexelsDatabase.withTransaction {

                if (loadType == LoadType.REFRESH) {
                    photoDao.clearAll()
                }

                val photoEntities = photos.map { it.toPhotoEntity() }
                photoDao.upsertAll(photoEntities)

            }

            return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }

    private fun getNextPage(nextPageString: String): Int? {
        return try {
            nextPageString.substringAfter("page=").substringBefore("&").toInt()
        } catch (e: NumberFormatException) {
            null
        }
    }

}

