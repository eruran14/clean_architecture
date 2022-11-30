package com.eru.clean_architecture.presentation.ui.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eru.clean_architecture.domain.model.Note
import com.eru.clean_architecture.domain.usecase.GetAllNotesUseCase
import com.eru.clean_architecture.domain.utils.Resource
import com.eru.clean_architecture.presentation.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNotesUseCase
): ViewModel() {

    private val _getAllNotesState = MutableStateFlow<UiState<List<Note>>>(UiState.Empty())
    val getAllNotesState = _getAllNotesState.asStateFlow()

    fun getAllNotes(){
        viewModelScope.launch(Dispatchers.IO) {
            getAllNotesUseCase.getAllNotes().collect{ result->
                when (result){
                    is Resource.Loading ->{
                        _getAllNotesState.value = UiState.Loading()
                    }
                    is Resource.Error ->{
                        _getAllNotesState.value = UiState.Error(result.message!!)
                    }
                    is Resource.Success ->{
                        if (result.data != null)
                            _getAllNotesState.value = UiState.Success(result.data)
                    }
                }
            }
        }
    }
}