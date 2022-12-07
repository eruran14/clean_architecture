package com.eru.clean_architecture.presentation.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.eru.clean_architecture.presentation.UiState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseFragment(@LayoutRes layoutId: Int): Fragment(layoutId) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initialize()
        setUpRequests()
        setUpObservers()
        setUpClickListeners()
    }

    protected open fun initialize(){}
    protected open fun setUpClickListeners(){}
    protected open fun setUpObservers(){}
    protected open fun setUpRequests(){}

    protected open fun <T> StateFlow<UiState<T>>.collectState(
        onLoading: () -> Unit,
        onError: (message: String) -> Unit,
        onSuccess: (data: T) -> Unit
    ){
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                this@collectState.collect{ state ->
                when (state){
                    is UiState.Loading -> {
                        onLoading()
                    }
                    is UiState.Error -> {
                        onError(state.message)
                    }
                    is UiState.Success -> {
                        onSuccess(state.data)
                    }
                    is UiState.Empty -> {}
                }
            }
            }
        }

    }
}

