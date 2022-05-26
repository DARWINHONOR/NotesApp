package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.notesapp.data.SharedPreferencesManager
import com.google.android.material.textfield.TextInputEditText

class SharedPreferencesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    fun loadData(){
        var email = findViewById<TextView>(R.id.tvEmail)
        email.text = SharedPreferencesManager.getString(this, "email", "No tiene correo !!")
    }

    fun saveData(email: String){
        SharedPreferencesManager.putString(this,"email", email)
    }

    fun onClickSaveEmail(view: View) {
        var email = findViewById<TextInputEditText>(R.id.etEmail)
        saveData(email.text.toString())
        email.setText("")
        loadData()
    }
}