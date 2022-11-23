package com.eru.clean_architecture.data.repository

import com.eru.clean_architecture.data.localdb.NoteDao
import com.eru.clean_architecture.data.mapper.toEntity
import com.eru.clean_architecture.data.mapper.toNote
import com.eru.clean_architecture.domain.model.Note
import com.eru.clean_architecture.domain.repository.NoteRepository

class NoteRepositoryImpl(
    private val noteDao: NoteDao
): NoteRepository {
    override fun createNote(note: Note) {
        noteDao.createNote(note.toEntity())
    }

    override fun getAllNotes(): List<Note> {
        return noteDao.getAllNotes().map {
            it.toNote()
        }
    }

    override fun editNote(note: Note) {
        noteDao.editNote(note.toEntity())
    }

    override fun deleteNote(note: Note) {
        noteDao.deleteNote(note.toEntity())
    }
}