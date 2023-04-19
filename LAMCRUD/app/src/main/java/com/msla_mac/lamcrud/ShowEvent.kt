package com.msla_mac.lamcrud

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView

class ShowEvent : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_event)

        val txtName: TextView = findViewById(R.id.txtName)
        val txtDescription: TextView = findViewById(R.id.txtDescription)
        val txtStartDate: TextView = findViewById(R.id.txtStartDate)
        val txtEndDate: TextView = findViewById(R.id.txtEndDate)

        val event = eventsList[ currentRecord ]

        txtName.text = event.name
        txtDescription.text = event.description
        txtStartDate.text = event.startDate
        txtEndDate.text = event.endDate

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