package com.example.notesapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notesapp.data.dao.NoteDao
import com.example.notesapp.entitty.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class DataBaseManager : RoomDatabase(){

    abstract fun noteDao(): NoteDao

    companion object {
        var INSTANCE: DataBaseManager? = null

        fun getAppDataBase(context: Context): DataBaseManager?{
            if(INSTANCE == null){
                synchronized(DataBaseManager::class){
                    //construye la bd usando pagron singleton 1 sola variable
                    INSTANCE = Room.databaseBuilder(context.applicationContext, DataBaseManager::class.java, "database").build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }

}