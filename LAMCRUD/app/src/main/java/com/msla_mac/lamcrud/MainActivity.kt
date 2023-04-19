package com.msla_mac.lamcrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : BaseActivity() {
    lateinit var recyclerView : RecyclerView
    private lateinit var eventsListAdapter: EventsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.eventsRecycler)
        eventsListAdapter = EventsAdapter(eventsList) { position ->
            toastIt("You selected position: $position")

            //perform whatever you want onclick
            val intent = Intent(this, ShowEvent::class.java)
            currentRecord = position

            startActivity(intent)

        }
        toastIt("Created list")

        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = eventsListAdapter

        readEventsFile()
        eventsListAdapter.notifyDataSetChanged()
    }
fun addEventOnClick( v : View ) {
    val intent = Intent(this, AddEvent::class.java)
    startActivity(intent)
}

    fun scrollToTopOnClick( v : View){
        recyclerView.smoothScrollToPosition(0)
    }

    fun scrollToBottomOnClick( v : View ){
        recyclerView.smoothScrollToPosition(eventsList.size)
    }

    fun addMockDataOnClick( v : View) {
        for (i in 1..41) {
            val eventsItem = EventsItem("Meeting $i", "Very long meeting", "1/1/2023", "1/2/2023")
            eventsList.add(eventsItem)
        }
            writeEventsToFile()
            eventsListAdapter.notifyDataSetChanged()
    }
}