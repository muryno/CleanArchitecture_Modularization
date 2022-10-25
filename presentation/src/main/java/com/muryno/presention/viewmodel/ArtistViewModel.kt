package com.muryno.presention.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muryno.presention.model.ArtistModel
import com.muryno.domain.usecase.ArtistUseCase
import com.muryno.presention.mapper.ArtistDomainToPresentationMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArtistViewModel @Inject constructor(
    private val artistUseCase: ArtistUseCase,
    private val artistDomainMapper: ArtistDomainToPresentationMapper
) : ViewModel() {

    private val _artistState= MutableLiveData<List<ArtistModel>>()
    var artistState: LiveData<List<ArtistModel>> = _artistState



    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean> = _loading


    private val _errorState: MutableLiveData<Boolean> = MutableLiveData()
    val errorState: LiveData<Boolean> = _errorState


    fun artistQuery(artistName: String) {
        viewModelScope.launch {
            try {
                _loading.postValue(true)
                artistUseCase.execute(artistName).let {
                    if (it.isNotEmpty()) {
                        _artistState.value = it.map (artistDomainMapper::toPresentation)
                    }else {
                        _artistState.value = emptyList()
                    }
                    _loading.postValue(false)
                }
            } catch (e: Exception) {
                print(e.message)
                _errorState.postValue(true)
                _loading.postValue(false)
            }
        }

    }

}





