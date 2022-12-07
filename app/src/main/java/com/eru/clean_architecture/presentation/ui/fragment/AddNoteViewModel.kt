package com.eru.clean_architecture.presentation.ui.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eru.clean_architecture.domain.model.Note
import com.eru.clean_architecture.domain.usecase.CreateNoteUseCase
import com.eru.clean_architecture.domain.usecase.DeleteNoteUseCase
import com.eru.clean_architecture.domain.usecase.EditNoteUseCase
import com.eru.clean_architecture.domain.utils.Resource
import com.eru.clean_architecture.presentation.UiState
import com.eru.clean_architecture.presentation.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddNoteViewModel @Inject constructor(
    private val createNoteUseCase: CreateNoteUseCase,
    private val editNoteUseCase: EditNoteUseCase,
) : BaseViewModel() {

    private val _createNoteState = initMutableFlowState()
    val createNoteState = _createNoteState.asStateFlow()

    private val _editNoteState = initMutableFlowState()
    val editNoteState = _editNoteState.asStateFlow()



    fun createNote(note: Note) {
        createNoteUseCase.createNote(note).collectFlow(_createNoteState)
    }

    fun editNote(note: Note) {
        editNoteUseCase.editNote(note).collectFlow(_editNoteState)
    }
}