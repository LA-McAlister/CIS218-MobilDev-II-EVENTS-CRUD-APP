package com.msla_mac.lamcrud

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter

var eventsList = ArrayList<EventsItem>()
var currentRecord = 0
const val EVENTS_FILE = "events.txt"

open class BaseActivity() : AppCompatActivity() {

    fun writeEventsToFile(){
        //Open File
        val fileOutputStream: FileOutputStream = openFileOutput(EVENTS_FILE, MODE_PRIVATE)
        val eventFile = OutputStreamWriter(fileOutputStream)
        //Write each record
        for(event in eventsList) {
            eventFile.write( event.toCSV() + "\n")
        }
        // Close the File
        eventFile.close()
    }

    fun readEventsFile(){
        eventsList.clear()
        //Open the file
        val file = File(filesDir, EVENTS_FILE)
        if(file.exists()) {
            //Read each line
            File(filesDir, EVENTS_FILE). forEachLine{
                val parts = it.split(",")
                //convert to an RecordsItem
                val event = EventsItem( parts[0], parts[1], parts[2], parts[3])
                //Add the event to the recordList
                eventsList.add(event)
            }
        }
    }

    fun deleteEventsFile(){
        val file = File(filesDir, EVENTS_FILE)
        if(file.exists()){
            file.delete()
        }
    }

    fun appendEventToFile(event: EventsItem) {
        val fileOutputStream: FileOutputStream = openFileOutput(EVENTS_FILE, MODE_APPEND)
        val eventFile = OutputStreamWriter(fileOutputStream)
        eventFile.write( "${event.toCSV()}\n")
        eventFile.close()
    }

    open fun toastIt(msg: String?) {
        Toast.makeText(
            applicationContext,
            msg, Toast.LENGTH_SHORT
        ).show()
    }
}