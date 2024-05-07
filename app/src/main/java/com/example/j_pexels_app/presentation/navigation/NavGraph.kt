package com.example.j_pexels_app.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.j_pexels_app.constants.PexelsConsts.PHOTO_ID
import com.example.j_pexels_app.domain.model.Photo
import com.example.j_pexels_app.presentation.screen.PhotoDetailsScreen
import com.example.j_pexels_app.presentation.screen.PhotosScreen


@Composable
fun NavGraph(
    startDestination: String = Route.Home.route,
    innerPaddingValues: PaddingValues,
    navController: NavHostController = rememberNavController(),
) {


    fun onNavigateToPhotoDetails(photo: Photo) {
        navController.currentBackStackEntry?.savedStateHandle?.set(
            PHOTO_ID,
            photo.id,
        )
        navController.navigate(Route.PhotoDetails.route)
    }

    NavHost(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPaddingValues),
        navController = navController,
        startDestination = startDestination,
    ) {

        composable(Route.Home.route) {
            PhotosScreen(
                photosViewModel = hiltViewModel(),
                onPhotoClick = ::onNavigateToPhotoDetails,
            )
        }

        composable(
            route = Route.PhotoDetails.route,
        ) {
            val photoId = navController.previousBackStackEntry?.savedStateHandle?.get<Long>(PHOTO_ID) ?: -1L
            PhotoDetailsScreen(
                photoId = photoId,
                viewModel = hiltViewModel()
            )
        }

    }

}

