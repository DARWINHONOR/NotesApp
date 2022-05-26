package com.example.notesapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    fun loadData(){
        var sharedPreferences = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)
        var emailTxt = sharedPreferences.getString("email","No tiene correo guardado !!")
        var email = findViewById<TextView>(R.id.tvEmail)
        email.text = emailTxt
    }

    fun saveData(email: String){
        var sharedPreferences = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)
        var editor = sharedPreferences.edit()
        editor.putString("email", email)
        editor.commit()
    }

    fun onClickSaveEmail(view: View) {
        var email = findViewById<TextInputEditText>(R.id.etEmail)
        saveData(email.text.toString())
        email.setText("")
        loadData()
    }
}