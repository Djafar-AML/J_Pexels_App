package com.example.j_pexels_app.presentation.screen

import android.content.Context
import android.content.Intent
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.net.Uri
import android.webkit.URLUtil
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.SubcomposeAsyncImage
import com.example.j_pexels_app.R
import com.example.j_pexels_app.domain.model.PhotoDetails
import com.example.j_pexels_app.presentation.vm.PhotoDetailsState
import com.example.j_pexels_app.presentation.vm.PhotoDetailsViewModel
import com.example.j_pexels_app.ui.theme.J_Pexels_AppTheme


@Composable
fun PhotoDetailsScreen(
    modifier: Modifier = Modifier,
    photoId: Long,
    viewModel: PhotoDetailsViewModel,
) {

    LaunchedEffect(key1 = Unit) {
        viewModel.getPhoto(photoId)
    }

    fun onRefresh() {
        viewModel.getPhoto(photoId)
    }

    val photoDetailsState by viewModel.photoDetailsState.collectAsStateWithLifecycle()

    when (photoDetailsState) {
        PhotoDetailsState.Loading -> {
            LoadingBox()
        }

        is PhotoDetailsState.Success -> {
            PhotoDetail(
                modifier = Modifier.then(modifier),
                photo = (photoDetailsState as PhotoDetailsState.Success).photoDetails,
            )
        }

        is PhotoDetailsState.Error -> {
            PhotoError(
                throwable = (photoDetailsState as PhotoDetailsState.Error).throwable,
                onRefresh = ::onRefresh,
            )
        }

    }
}

@Composable
private fun PhotoError(throwable: Throwable, onRefresh: () -> Unit) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            modifier = Modifier
                .size(64.dp),
            imageVector = Icons.Rounded.Warning, contentDescription = "warning icon"
        )

        Text(
            modifier = Modifier
                .padding(8.dp),
            text = throwable.message ?: throwable.toString(),
            textAlign = TextAlign.Center,
        )

        Button(
            onClick = onRefresh,
            content = {
                Text(text = "Refresh")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White,
            )
        )

    }

}

@Composable
private fun PhotoDetail(modifier: Modifier, photo: PhotoDetails) {

    val context = LocalContext.current

    Card(
        modifier = modifier,
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            SubcomposeAsyncImage(
                model = photo.imageSource.original,
                contentScale = ContentScale.FillBounds,
                contentDescription = photo.contentDescription,
                loading = {
                    CircularProgressIndicator()
                },
                error = {
                    painterResource(id = R.drawable.ic_error_placeholder)
                },
                modifier = Modifier.fillMaxHeight(0.5f)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = photo.photographer,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = photo.contentDescription,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontStyle = FontStyle.Italic,
                    color = MaterialTheme.colorScheme.onSurface
                ),
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextButton(
                onClick = { openImageUrl(photo.url, context) },
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
            ) {
                Text(text = "View Image in Pexels Site")
            }

            Spacer(modifier = Modifier.height(8.dp))

            TextButton(
                onClick = { openImageUrl(photo.photographerUrl, context) },
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
            ) {
                Text(text = "Photographer Profile")
            }

            Spacer(modifier = Modifier.height(8.dp))

        }
    }
}

fun openImageUrl(url: String, context: Context) {

    if (URLUtil.isValidUrl(url)) {
        val parsedUrl = Uri.parse(url)
        val openUrlIntent = Intent(Intent.ACTION_VIEW, parsedUrl)
        context.startActivity(openUrlIntent)
    }

}

@Composable
private fun LoadingBox() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.primary,
        )
    }
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PhotoItemPreview() {
    J_Pexels_AppTheme {
        PhotoDetail(
            modifier = Modifier,
            photo = PhotoDetails(
                id = 1,
                imageSource = PhotoDetails.ImageSource(
                    original = "https://images.pexels.com/photos/1090387/pexels-photo-1090387.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                ),
                contentDescription = "nature",
                photographer = "Jeff",
            )
        )
    }
}