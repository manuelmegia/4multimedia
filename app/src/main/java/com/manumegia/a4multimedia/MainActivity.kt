package com.manumegia.a4multimedia

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    var cont = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var botonRes = findViewById<Button>(R.id.button)
        var botonSum = findViewById<Button>(R.id.button2)
        var mensajeTextView = findViewById<TextView>(R.id.textView)
        var editText = findViewById<EditText>(R.id.editText)
        editText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                cambiarColor(botonRes, "#9b9b9b")
                cambiarColor(botonSum, "#9b9b9b")
            } else {
                cambiarColor(botonRes, "#ffcc0000")
                cambiarColor(botonSum, "#ff669900")
            }
        }
        botonSum.setOnClickListener {
            cont += editText.text.toString().toInt()
            mensajeTextView.text = cont.toString()
        }

        botonRes.setOnClickListener {
            if (cont - editText.text.toString().toInt() >= 0) cont -= editText.text.toString()
                .toInt()
            mensajeTextView.text = cont.toString()
        }
    }

    private fun cambiarColor(cambView: View, color: String){
        val colorStateList = ColorStateList.valueOf(Color.parseColor(color))
        cambView.backgroundTintList = colorStateList
    }
}
