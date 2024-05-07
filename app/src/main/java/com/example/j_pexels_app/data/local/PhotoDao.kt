package com.example.j_pexels_app.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface PhotoDao {

    @Upsert
    suspend fun upsertAll(beers: List<PhotoEntity>)

    @Query("SELECT * FROM photos")
    fun pagingSource(): PagingSource<Int, PhotoEntity>

    @Query("DELETE FROM photos")
    suspend fun clearAll()

}