package com.example.j_pexels_app.domain.usecase

import com.vgen.vooop.execption.ApiError

interface UseCaseResponse <T> {
    fun onSuccess(response : T) {}
    fun onError(apiError : ApiError?) {}
}