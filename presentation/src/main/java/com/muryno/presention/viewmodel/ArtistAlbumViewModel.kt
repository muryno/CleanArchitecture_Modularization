package com.muryno.presention.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muryno.domain.usecase.ArtistAlbumUserUseCase
import com.muryno.presention.mapper.ArtistAlbumDomainToPresentationMapper
import com.muryno.presention.model.ArtistAlbumModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArtistAlbumViewModel @Inject constructor(
    private val artistAlbumUseCase: ArtistAlbumUserUseCase,
    private val artistAlbumDomainMapper: ArtistAlbumDomainToPresentationMapper
) : ViewModel() {

    private val _artistAlbumState = MutableLiveData<List<ArtistAlbumModel>>()
    var artistAlbumState: LiveData<List<ArtistAlbumModel>> = _artistAlbumState


    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean> = _loading


    private val _errorState: MutableLiveData<Boolean> = MutableLiveData()
    val errorState: LiveData<Boolean> = _errorState

    private val album = "album"

    fun artistAlbumQuery(artistId: String, type: String = album) {
        viewModelScope.launch {
            try {
                artistAlbumUseCase.execute(artistId, type).let {
                    if (it.isNotEmpty()) {
                        _artistAlbumState.value = it.map(artistAlbumDomainMapper::toPresentation)
                    } else {
                        _artistAlbumState.value = emptyList()
                    }
                    _loading.postValue(false)
                }
            } catch (e: Exception) {
                _errorState.postValue(true)
                _loading.postValue(false)
            }
        }

    }

}





