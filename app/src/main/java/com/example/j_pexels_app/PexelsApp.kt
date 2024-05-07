package com.example.j_pexels_app

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.disk.DiskCache
import coil.memory.MemoryCache
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PexelsApp : Application(), ImageLoaderFactory {
    override fun newImageLoader() = imageLoader()

    private fun imageLoader() = ImageLoader.Builder(context = this)
        .crossfade(enable = true)
        .memoryCache {
            MemoryCache.Builder(context = this)
                .maxSizePercent(percent = 0.25)
                .build()
        }
        .diskCache {
            DiskCache.Builder()
                .directory(directory = cacheDir.resolve("coil_cache"))
                .maxSizePercent(percent = 0.02)
                .build()
        }
        .build()

}