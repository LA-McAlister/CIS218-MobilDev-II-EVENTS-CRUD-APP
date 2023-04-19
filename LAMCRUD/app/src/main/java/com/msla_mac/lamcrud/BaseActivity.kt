package com.msla_mac.lamcrud

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

var eventsList = ArrayList<EventsItem>()
var currentRecord = 0

open class BaseActivity() : AppCompatActivity() {

    open fun toastIt(msg: String?) {
        Toast.makeText(
            applicationContext,
            msg, Toast.LENGTH_SHORT
        ).show()
    }
}