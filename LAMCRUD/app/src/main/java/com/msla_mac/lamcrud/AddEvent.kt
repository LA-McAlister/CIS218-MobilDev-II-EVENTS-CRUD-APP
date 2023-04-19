package com.msla_mac.lamcrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AddEvent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_event)
    }

    fun showAllEventsOnClick( v : View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}