package com.eru.clean_architecture.presentation.ui.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eru.clean_architecture.domain.model.Note
import com.eru.clean_architecture.domain.usecase.DeleteNoteUseCase
import com.eru.clean_architecture.domain.usecase.GetAllNotesUseCase
import com.eru.clean_architecture.domain.utils.Resource
import com.eru.clean_architecture.presentation.UiState
import com.eru.clean_architecture.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
): BaseViewModel() {

    private val _getAllNotesState = MutableStateFlow<UiState<List<Note>>>(UiState.Empty())
    val getAllNotesState = _getAllNotesState.asStateFlow()

    private val _deleteNoteState = initMutableFlowState()
    val deleteNoteState = _deleteNoteState.asStateFlow()

    fun getAllNotes(){
        getAllNotesUseCase.getAllNotes().collectFlow(_getAllNotesState)
    }

    fun deleteNote(note: Note) {
        deleteNoteUseCase.deleteNote(note).collectFlow(_deleteNoteState)
    }
}