package com.example.notesapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.example.notesapp.data.DataBaseManager
import com.example.notesapp.data.SharedPreferencesManager
import com.example.notesapp.entitty.Note
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            var list = listOf<Note>(
                Note(1, "Nota 1" , "Esta es mi nota 1", "Etiqueta de nota 1"),
                Note(2, "Nota 2" , "Esta es mi nota 2", "Etiqueta de nota 2"),
                Note(3, "Nota 3" , "Esta es mi nota 3", "Etiqueta de nota 3"),
                Note(4, "Nota 4" , "Esta es mi nota 4", "Etiqueta de nota 4"),
                Note(5, "Nota 5" , "Esta es mi nota 5", "Etiqueta de nota 5"),
                Note(6, "Nota 6" , "Esta es mi nota 6", "Etiqueta de nota 6"),
                Note(7, "Nota 7" , "Esta es mi nota 7", "Etiqueta de nota 7"),
                Note(8, "Nota 8" , "Esta es mi nota 8", "Etiqueta de nota 8")
            )

            var db = DataBaseManager.getAppDataBase(this@MainActivity)
            db?.noteDao()?.insert(list)

            var notes = db?.noteDao()?.getAll()
            Log.d("Notes", "Notas:  ${notes?.size}")
        }


    }


}