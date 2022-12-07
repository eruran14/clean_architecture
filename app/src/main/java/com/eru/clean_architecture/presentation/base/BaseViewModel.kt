package com.eru.clean_architecture.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eru.clean_architecture.domain.utils.Resource
import com.eru.clean_architecture.presentation.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun <T> Flow<Resource<T>>.collectFlow(_state: MutableStateFlow<UiState<T>>) {
        viewModelScope.launch(Dispatchers.IO) {
            this@collectFlow.collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        _state.value = UiState.Loading()
                    }
                    is Resource.Error -> {
                        _state.value = UiState.Error(result.message!!)
                    }
                    is Resource.Success -> {
                        if (result.data != null)
                            _state.value = UiState.Success(result.data)
                    }
                }
            }
        }
    }

    protected fun initMutableFlowState(): MutableStateFlow<UiState<Unit>> {
        return MutableStateFlow<UiState<Unit>>(UiState.Empty())
    }
}