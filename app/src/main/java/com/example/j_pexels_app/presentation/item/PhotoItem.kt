package com.example.j_pexels_app.presentation.item

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.j_pexels_app.R
import com.example.j_pexels_app.domain.model.Photo
import com.example.j_pexels_app.ui.theme.J_Pexels_AppTheme


@Composable
fun PhotoItem(
    modifier: Modifier = Modifier,
    photo: Photo?,
    onItemClick: (Photo) -> Unit,
) {

    photo ?: return
    val context = LocalContext.current

    Card(
        onClick = {
            Toast.makeText(context, "photo id is: ${photo.id}", Toast.LENGTH_SHORT).show()
            onItemClick(photo)
        },
        modifier = modifier,
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
                .padding(16.dp)
        ) {

            SubcomposeAsyncImage(
                model = photo.imageSource.tiny,
                contentScale = ContentScale.FillBounds,
                contentDescription = photo.contentDescription,
                loading = {
                    CircularProgressIndicator()
                },
                error = {
                    painterResource(id = R.drawable.ic_error_placeholder)
                },
                modifier = Modifier
                    .weight(1f)
                    .height(90.dp)
                    .clip(CircleShape),
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
            ) {
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

            }
        }
    }
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PhotoItemPreview() {
    J_Pexels_AppTheme {
        PhotoItem(photo = Photo(), onItemClick = {})
    }
}