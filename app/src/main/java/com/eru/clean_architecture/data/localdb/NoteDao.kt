package com.eru.clean_architecture.data.localdb

import androidx.room.*
import com.eru.clean_architecture.data.model.NoteEntity

@Dao
interface NoteDao {

    //CRUD
    // C - create
    // R - read
    // U - update
    // D - delete

    @Insert
    fun createNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM notes")
    fun getAllNotes(): List<NoteEntity>

    @Update
    fun editNote(noteEntity: NoteEntity)

    @Delete
    fun deleteNote(noteEntity: NoteEntity)
}