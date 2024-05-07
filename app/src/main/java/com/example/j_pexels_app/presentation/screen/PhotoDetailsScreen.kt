package com.example.j_pexels_app.presentation.screen

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.j_pexels_app.ui.theme.J_Pexels_AppTheme


@Composable
fun PhotoDetailsScreen(
    modifier: Modifier = Modifier,
    photoId: Long,
) {

    Text(text = "photo id is : $photoId")
//
//    photo ?: return
//
//    fun onPhotoClick(photo: Photo) {
//        onItemClick(photo)
//    }
//
//    Card(
//        onClick = { onPhotoClick(photo) },
//        modifier = modifier,
//    ) {
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(IntrinsicSize.Max)
//                .padding(16.dp)
//        ) {
//
//            SubcomposeAsyncImage(
//                model = photo.imageSource.tiny,
//                contentScale = ContentScale.FillBounds,
//                contentDescription = photo.contentDescription,
//                loading = {
//                    CircularProgressIndicator()
//                },
//                error = {
//                    painterResource(id = R.drawable.ic_error_placeholder)
//                },
//                modifier = Modifier
//                    .weight(1f)
//                    .height(90.dp)
//                    .clip(CircleShape),
//            )
//
//            Spacer(modifier = Modifier.width(16.dp))
//
//            Column(
//                modifier = Modifier
//                    .weight(3f)
//                    .fillMaxHeight(),
//                verticalArrangement = Arrangement.Center,
//            ) {
//                Text(
//                    text = photo.photographer,
//                    style = MaterialTheme.typography.headlineMedium,
//                    modifier = Modifier.fillMaxWidth(),
//                )
//
//                Spacer(modifier = Modifier.height(8.dp))
//
//                Text(
//                    text = photo.contentDescription,
//                    style = MaterialTheme.typography.bodyMedium.copy(
//                        fontStyle = FontStyle.Italic,
//                        color = MaterialTheme.colorScheme.onSurface
//                    ),
//                    modifier = Modifier.fillMaxWidth(),
//                )
//
//                Spacer(modifier = Modifier.height(8.dp))
//
//            }
//        }
//    }
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PhotoItemPreview() {
    J_Pexels_AppTheme {
    }
}