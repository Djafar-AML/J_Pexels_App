package com.example.j_pexels_app.di

import com.example.j_pexels_app.data.remote.api.PexelsApi
import com.example.j_pexels_app.data.remote.repo.PhotoRepoImpl
import com.example.j_pexels_app.domain.repo.PhotoRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun providePhotoRepo(
        api: PexelsApi
    ): PhotoRepo {
        return PhotoRepoImpl(api = api)
    }
}