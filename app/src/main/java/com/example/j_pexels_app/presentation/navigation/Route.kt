package com.example.j_pexels_app.presentation.navigation

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable

@Immutable
@Stable

sealed class Route(val route: String) {
    data object Home : Route(route = "home")
    data object PhotoDetails : Route(route = "photo_details")

}