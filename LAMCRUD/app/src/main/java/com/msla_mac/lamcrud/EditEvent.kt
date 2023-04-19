package com.msla_mac.lamcrud

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText

class EditEvent : BaseActivity() {
    lateinit var edtEditName: EditText
    lateinit var edtEditDescription: EditText
    lateinit var edtEditStartDate: EditText
    lateinit var edtEditEndDate: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_event)
        val event = eventsList[ currentRecord ]

        edtEditName = findViewById(R.id.edtEditName)
        edtEditDescription = findViewById(R.id.edtEditDescription)
        edtEditStartDate = findViewById(R.id.edtEditStartDate)
        edtEditEndDate = findViewById(R.id.edtEditEndDate)

        edtEditName.setText(event.name)
        edtEditDescription.setText(event.description)
        edtEditStartDate.setText(event.startDate)
        edtEditEndDate.setText(event.endDate)
    }

    fun saveChangesOnClick( v : View ){
        val event = eventsList [ currentRecord ]
        event.name = edtEditName.text.toString()
        event.description = edtEditDescription.text.toString()
        event.startDate = edtEditStartDate.text.toString()
        event.endDate = edtEditEndDate.text.toString()
        eventsList[currentRecord] = event
        val intent = Intent(this, ShowEvent::class.java)
        startActivity(intent)
    }

    fun showAllEventsOnClick( v : View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}