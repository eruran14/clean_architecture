package com.eru.clean_architecture.domain.usecase

import com.eru.clean_architecture.domain.model.Note
import com.eru.clean_architecture.domain.repository.NoteRepository

class GetAllNotesUseCase(
    private val noteRepository: NoteRepository
) {

    fun getAllNotes() = noteRepository.getAllNotes()
}