package com.muryno.artist.architecture.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import com.muryno.artist.architecture.mapper.ViewStateBinder
import com.muryno.artist.navigation.mapper.DestinationPresentationToUiMapper
import com.muryno.presention.architecture.model.PresentationDestination
import com.muryno.presention.architecture.viewmodel.BaseViewModel

private const val NO_LAYOUT_RESOURCE = 0

abstract class BaseFragment<VIEW_STATE : Any> : Fragment(), ViewsProvider {
    protected abstract val viewModel: BaseViewModel<VIEW_STATE>

    open val layoutResourceId: Int = NO_LAYOUT_RESOURCE

    abstract val destinationMapper: DestinationPresentationToUiMapper
    abstract val viewStateBinder: ViewStateBinder<VIEW_STATE, ViewsProvider>

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = if (layoutResourceId != NO_LAYOUT_RESOURCE) {
            inflater.inflate(layoutResourceId, container, false).apply {
                bindViews()
            }
        } else {
            null
        }
        observeViewModel()

        return view
    }

    abstract fun View.bindViews()

    private fun observeViewModel() {
        viewModel.viewState.observe(viewLifecycleOwner, ::applyViewState)
        viewModel.destination.observe(viewLifecycleOwner, ::navigateToDestination)
    }

    private fun applyViewState(viewState: VIEW_STATE) {
        with(viewStateBinder) {
            bindState(viewState)
        }
    }

    private fun navigateToDestination(destination: PresentationDestination) {
        destinationMapper.toUi(destination).navigate()
    }

    protected fun closeSoftKeyboard() {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}
