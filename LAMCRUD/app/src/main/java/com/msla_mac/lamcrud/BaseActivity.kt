package com.msla_mac.lamcrud

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity() : AppCompatActivity() {

    var eventsList = ArrayList<EventsItem>()

    open fun toastIt(msg: String?) {
        Toast.makeText(
            applicationContext,
            msg, Toast.LENGTH_SHORT
        ).show()
    }
}