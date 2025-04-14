package com.muryno.artist.artist.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muryno.artist.artist.mapper.ArtistPresentationToUIMapper
import com.muryno.artist.artist.model.ArtistUIModel
import com.muryno.presention.artist.viewmodel.ArtistViewModel

@Composable
fun ArtistScreen(
    viewModel: ArtistViewModel,
    artistToUiMapper: ArtistPresentationToUIMapper
) {
    val viewState by viewModel.viewState.observeAsState()
    val keyboardController = LocalSoftwareKeyboardController.current
    var searchText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Search bar and button
        Text(
            text = "Artist",
            fontSize = 32.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 10.dp, top = 20.dp, end = 20.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = searchText,
                onValueChange = { searchText = it },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                placeholder = { Text("artist name...") },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent
                ),
                singleLine = true
            )
            Button(
                onClick = {
                    keyboardController?.hide()
                    viewModel.onEntered(artistName = searchText)
                },
                shape = RoundedCornerShape(0.dp)
            ) {
                Text(
                    text = "FIND",
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }

        Box(modifier = Modifier.fillMaxSize()) {
            // Loading indicator
            if (viewState?.isLoading == true) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            // Artist list
            viewState?.artist?.let { artistList ->
                if (artistList.isNotEmpty()) {
                    LazyColumn {
                        items(
                            items = artistList.map(artistToUiMapper::toUi),
                            key = { it.id }
                        ) { artist ->
                            ArtistItem(
                                artist = artist,
                                onClick = {
                                    keyboardController?.hide()
                                    viewModel.onEntered(artistName = searchText)
                                }
                            )
                        }
                    }
                } else {
                    // Empty state
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("No artists found")
                    }
                }
            }
        }
    }

    // Initial search with default value
    LaunchedEffect(Unit) {
        viewModel.onEntered("Chicago")
    }
}

@Composable
fun ArtistItem(
    artist: ArtistUIModel,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Name: ",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    modifier = Modifier.padding(top = 2.dp).width(70.dp)
                )
                Text(
                    text = artist.name,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "City: ",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    modifier = Modifier.padding(top = 2.dp).width(70.dp)
                )
                Text(
                    text = artist.city,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Gender: ",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    modifier = Modifier.padding(top = 2.dp).width(70.dp)
                )
                Text(
                    text = artist.gender.trim(),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = artist.description,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
