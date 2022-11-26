package com.eru.clean_architecture.data.repository

import com.eru.clean_architecture.data.localdb.NoteDao
import com.eru.clean_architecture.data.mapper.toEntity
import com.eru.clean_architecture.data.mapper.toNote
import com.eru.clean_architecture.domain.model.Note
import com.eru.clean_architecture.domain.repository.NoteRepository
import com.eru.clean_architecture.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
): NoteRepository {
    override fun createNote(note: Note): Flow<Resource<Unit>> = flow {
            emit(Resource.Loading())
            try {
                val data = noteDao.createNote(note.toEntity())
                emit(Resource.Success(data))
            } catch (e: IOException){
                emit(Resource.Error(e.localizedMessage ?: "Неизвестная ошибка"))
            }
        }.flowOn(Dispatchers.IO)

    override fun getAllNotes(): Flow<Resource<List<Note>>> = flow {
            emit(Resource.Loading())
            try {
                val data = noteDao.getAllNotes().map { it.toNote() }
                emit(Resource.Success(data))
            } catch (e: IOException){
                emit(Resource.Error(e.localizedMessage ?: "Неизвестная ошибка"))
            }
        }.flowOn(Dispatchers.IO)


    override fun editNote(note: Note): Flow<Resource<Unit>>  = flow {
            emit(Resource.Loading())
            try {
                val data = noteDao.editNote(note.toEntity())
                emit(Resource.Success(data))
            } catch (e: IOException){
                emit(Resource.Error(e.localizedMessage ?: "Неизвестная ошибка"))
            }
        }.flowOn(Dispatchers.IO)

    override fun deleteNote(note: Note): Flow<Resource<Unit>> = flow {
            emit(Resource.Loading())
            try {
                val data = noteDao.deleteNote(note.toEntity())
                emit(Resource.Success(data))
            } catch (e: IOException){
                emit(Resource.Error(e.localizedMessage ?: "Неизвестная ошибка"))
            }
        }.flowOn(Dispatchers.IO)
    }