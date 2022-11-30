package com.eru.clean_architecture.presentation.ui.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eru.clean_architecture.domain.model.Note
import com.eru.clean_architecture.domain.usecase.CreateNoteUseCase
import com.eru.clean_architecture.domain.usecase.DeleteNoteUseCase
import com.eru.clean_architecture.domain.usecase.EditNoteUseCase
import com.eru.clean_architecture.domain.utils.Resource
import com.eru.clean_architecture.presentation.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddNoteViewModel @Inject constructor(
    private val createNoteUseCase: CreateNoteUseCase,
    private val editNoteUseCase: EditNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
) : ViewModel() {

    private val _createNoteState = MutableStateFlow<UiState<Unit>>(UiState.Empty())
    val createNoteState = _createNoteState.asStateFlow()

    private val _editNoteState = MutableStateFlow<UiState<Unit>>(UiState.Empty())
    val editNoteState = _editNoteState.asStateFlow()

    private val _deleteNoteState = MutableStateFlow<UiState<Unit>>(UiState.Empty())
    val deleteNoteState = _deleteNoteState.asStateFlow()

    fun createNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            createNoteUseCase.createNote(note).collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        _createNoteState.value = UiState.Loading()
                    }
                    is Resource.Error -> {
                        _createNoteState.value = UiState.Error(result.message!!)
                    }
                    is Resource.Success -> {
                        if (result.data != null)
                            _createNoteState.value = UiState.Success(result.data)
                    }
                }
            }
        }
    }

    fun editNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            editNoteUseCase.editNote(note).collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        _editNoteState.value = UiState.Loading()
                    }
                    is Resource.Error -> {
                        _editNoteState.value = UiState.Error(result.message!!)
                    }
                    is Resource.Success -> {
                        if (result.data != null)
                            _editNoteState.value = UiState.Success(result.data)
                    }
                }
            }
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteNoteUseCase.deleteNote(note).collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        _deleteNoteState.value = UiState.Loading()
                    }
                    is Resource.Error -> {
                        _deleteNoteState.value = UiState.Error(result.message!!)
                    }
                    is Resource.Success -> {
                        if (result.data != null)
                            _deleteNoteState.value = UiState.Success(result.data)
                    }
                }
            }
        }
    }
}