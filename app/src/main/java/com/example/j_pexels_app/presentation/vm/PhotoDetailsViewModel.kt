package com.example.j_pexels_app.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.j_pexels_app.domain.model.PhotoDetails
import com.example.j_pexels_app.domain.usecase.PhotoDetailsUseCase
import com.example.j_pexels_app.domain.usecase.UseCaseResponse
import com.vgen.vooop.execption.ApiError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class PhotoDetailsViewModel @Inject constructor(
    private val photoDetailsUseCase: PhotoDetailsUseCase,
) : ViewModel() {

    private val _photoDetailsState = MutableStateFlow<PhotoDetailsState>(PhotoDetailsState.Loading)
    val photoDetailsState: StateFlow<PhotoDetailsState> = _photoDetailsState

    fun getPhoto(photoId: Long) {

        if (_photoDetailsState.value !is PhotoDetailsState.Loading) {
            _photoDetailsState.value = PhotoDetailsState.Loading
        }

        photoDetailsUseCase(
            scope = viewModelScope,
            params = photoId,
            onResult = object : UseCaseResponse<PhotoDetails> {
                override fun onSuccess(response: PhotoDetails) {
                    _photoDetailsState.value = PhotoDetailsState.Success(response)
                }

                override fun onError(apiError: ApiError?) {
                    _photoDetailsState.value = PhotoDetailsState.Error(Throwable(apiError?.message))
                }
            },
        )
    }

}

sealed class PhotoDetailsState {
    data object Loading : PhotoDetailsState()
    data class Success(val photoDetails: PhotoDetails) : PhotoDetailsState()
    data class Error(val throwable: Throwable) : PhotoDetailsState()
}