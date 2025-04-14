package com.muryno.artist.artist.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muryno.artist.R

@Composable
fun EmptyArtistScreen(
    onEntered: (refreshText: String) -> Unit,
) {
    val initialArtistName = stringResource(id = R.string.initial_artist_name)
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.blank),
            contentDescription = "an image",
            modifier = Modifier
                .fillMaxWidth()
                .height(75.dp)
        )
        Text(
            text = stringResource(id = R.string.oops_no_artist_available),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(18.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                onEntered(initialArtistName)
            }
        ) {
            Text(text = stringResource(id = R.string.refresh_text))
        }
    }
}

@Preview
@Composable
fun EmptyArtistScreenPreview() {
    EmptyArtistScreen(
        onEntered = {}
    )
}
