package com.example.j_pexels_app.di

import com.example.j_pexels_app.domain.repo.PhotoRepo
import com.example.j_pexels_app.domain.usecase.PhotoDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UsecaseModule {

    @Provides
    fun providePhotoDetailsUsecase(
        photoRepo: PhotoRepo
    ): PhotoDetailsUseCase {
        return PhotoDetailsUseCase(
            photoRepo = photoRepo
        )
    }

}