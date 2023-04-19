package com.msla_mac.lamcrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ShowEvent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_event)
    }


    fun editEventOnClick( v : View){
        val intent = Intent(this, EditEvent::class.java)
        startActivity(intent)
    }
    fun showAllEventsOnClick( v : View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}