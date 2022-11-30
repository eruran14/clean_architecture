package com.eru.clean_architecture.data.repository

import com.eru.clean_architecture.data.base.BaseRepository
import com.eru.clean_architecture.data.localdb.NoteDao
import com.eru.clean_architecture.data.mapper.toEntity
import com.eru.clean_architecture.data.mapper.toNote
import com.eru.clean_architecture.domain.model.Note
import com.eru.clean_architecture.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
) : NoteRepository, BaseRepository() {

    override fun createNote(note: Note) = doRequest {
        noteDao.createNote(note.toEntity())
    }

    override fun getAllNotes() = doRequest {
        noteDao.getAllNotes().map { it.toNote() }
    }


    override fun editNote(note: Note) = doRequest {
        noteDao.editNote(note.toEntity())
    }

    override fun deleteNote(note: Note) = doRequest {
        noteDao.deleteNote(note.toEntity())
    }
}