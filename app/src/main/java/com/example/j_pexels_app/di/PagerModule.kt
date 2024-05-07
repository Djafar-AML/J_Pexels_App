package com.example.j_pexels_app.di

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.j_pexels_app.data.local.PhotoDatabase
import com.example.j_pexels_app.data.local.PhotoEntity
import com.example.j_pexels_app.data.remote.api.PexelsApi
import com.example.j_pexels_app.data.remote.mediator.PexelsRemoteMediator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PagerModule {

    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun providePhotoPager(
        photoDb: PhotoDatabase,
        api: PexelsApi,
    ): Pager<Int, PhotoEntity> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 5
            ),
            remoteMediator = PexelsRemoteMediator(
                pexelsApi = api,
                pexelsDatabase = photoDb,
            ),
            pagingSourceFactory = {
                photoDb.getPhotoDao().pagingSource()
            }
        )
    }

}
