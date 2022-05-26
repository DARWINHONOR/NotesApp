package com.example.notesapp.entitty

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Note (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Int,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "message") var message: String,
    @ColumnInfo(name = "tags") var tags: String
)