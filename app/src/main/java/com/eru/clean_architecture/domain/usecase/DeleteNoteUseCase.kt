package com.eru.clean_architecture.domain.usecase

import com.eru.clean_architecture.domain.model.Note
import com.eru.clean_architecture.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {

    fun deleteNote(note: Note) = noteRepository.deleteNote(note)
}