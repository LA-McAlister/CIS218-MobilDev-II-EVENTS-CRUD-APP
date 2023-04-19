package com.msla_mac.lamcrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class AddEvent : BaseActivity() {

    lateinit var edtEditName: EditText
    lateinit var edtEditDescription: EditText
    lateinit var edtEditStartDate: EditText
    lateinit var edtEditEndDate: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_event)

        edtEditName = findViewById(R.id.edtEditName)
        edtEditDescription = findViewById(R.id.edtEditDescription)
        edtEditStartDate = findViewById(R.id.edtEditStartDate)
        edtEditEndDate = findViewById(R.id.edtEditEndDate)
    }

    fun addNewEventOnClick( v : View ){
        val eventItem = EventsItem(edtEditName.text.toString(),
            edtEditDescription.text.toString(),
            edtEditStartDate.text.toString(),
            edtEditEndDate.text.toString())
        eventsList.add(eventItem)

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}