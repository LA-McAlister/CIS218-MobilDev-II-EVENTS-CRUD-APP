package com.msla_mac.lamcrud

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText

class EditEvent : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_event)

        val edtEditName: EditText = findViewById(R.id.edtEditName)
        val edtEditDescription: EditText = findViewById(R.id.edtEditDescription)
        val edtEditStartDate: EditText = findViewById(R.id.edtEditStartDate)
        val edtEditEndDate: EditText = findViewById(R.id.edtEditEndDate)

        val event = eventsList[ currentRecord ]

        edtEditName.setText(event.name)
        edtEditDescription.setText(event.description)
        edtEditStartDate.setText(event.startDate)
        edtEditEndDate.setText(event.endDate)
    }

    fun showAllEventsOnClick( v : View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}