package com.muryno.presention.viewmodel

import com.muryno.presention.architecture.model.PresentationDestination
import com.muryno.presention.architecture.viewmodel.BaseViewModel

fun <VIEW_STATE : Any, NOTIFICATION : Any> BaseViewModel<VIEW_STATE>.observeViewStateForever() =
    mutableListOf<VIEW_STATE>().apply {
        viewState.observeForever(::add)
    }

fun <VIEW_STATE : Any, NOTIFICATION : Any> BaseViewModel<VIEW_STATE>.observeDestinationForever() =
    mutableListOf<PresentationDestination>().apply {
        destination.observeForever(::add)
    }
