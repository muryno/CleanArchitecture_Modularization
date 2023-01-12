package com.muryno.artist.artist.view

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.muryno.artist.architecture.view.ViewsProvider


interface ArtistViewsProvider : ViewsProvider {
    val artistListView: RecyclerView
    val progressBar: ProgressBar
    val searchButton: Button
    val musicSearch: EditText
    val emptyState: View
}
