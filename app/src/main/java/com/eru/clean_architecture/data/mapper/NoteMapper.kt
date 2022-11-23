package com.eru.clean_architecture.data.mapper

import com.eru.clean_architecture.data.model.NoteEntity
import com.eru.clean_architecture.domain.model.Note

fun Note.toEntity() = NoteEntity(
    id,
    title,
    description,
    createdAt
)

fun NoteEntity.toNote() = Note(
    id,
    title,
    description,
    createdAt
)