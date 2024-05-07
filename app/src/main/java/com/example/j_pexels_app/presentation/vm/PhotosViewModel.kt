package com.example.j_pexels_app.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.j_pexels_app.data.local.PhotoEntity
import com.example.j_pexels_app.data.mappers.toPhoto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject


@HiltViewModel
class PhotosViewModel @Inject constructor(
    pager: Pager<Int, PhotoEntity>,
) : ViewModel() {

    val photosPagingFlow = pager
        .flow
        .map { pagingData ->
            pagingData.map { it.toPhoto() }
        }
        .cachedIn(viewModelScope)


}