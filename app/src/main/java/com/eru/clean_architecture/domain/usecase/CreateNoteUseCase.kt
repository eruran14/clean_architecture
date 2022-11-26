package com.eru.clean_architecture.domain.usecase

import com.eru.clean_architecture.domain.model.Note
import com.eru.clean_architecture.domain.repository.NoteRepository
import javax.inject.Inject

class CreateNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {

    fun createNote(note: Note) = noteRepository.createNote(note)
}