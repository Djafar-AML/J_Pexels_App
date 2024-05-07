package com.example.j_pexels_app.presentation.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.j_pexels_app.domain.model.Photo
import com.example.j_pexels_app.presentation.item.ErrorItem
import com.example.j_pexels_app.presentation.item.PhotoItem


@Composable
fun PhotoScreen(
    modifier: Modifier = Modifier,
    photos: LazyPagingItems<Photo>
) {

    val context = LocalContext.current

    LaunchedEffect(key1 = photos.loadState) {

        when {
            photos.loadState.refresh is LoadState.Error -> {
                showNetworkErrorMessage(context, photos)
            }
        }

    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier),
        contentAlignment = Alignment.Center,
    ) {
        if (photos.loadState.refresh is LoadState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(
                    Alignment.Center
                )
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 4.dp)
            ) {
                items(count = photos.itemCount) { index ->

                    val photoItem = photos[index]

                    PhotoItem(
                        modifier = Modifier.fillMaxWidth(),
                        photo = photoItem,
                        onItemClick = {},
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                }

                item {
                    ErrorItem(
                        loadState = photos.loadState.mediator,
                        photosCount = photos.itemCount,
                        onRefresh = { photos.refresh() },
                    )
                }
            }
        }
    }
}

private fun showNetworkErrorMessage(
    context: Context,
    photos: LazyPagingItems<Photo>
) {
    Toast.makeText(
        context,
        "Error: ${(photos.loadState.refresh as LoadState.Error).error.message}",
        Toast.LENGTH_LONG,
    ).show()
}