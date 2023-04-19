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

            val intent = Intent(this, ShowEvent::class.java)
            startActivity(intent)

        }
        toastIt("Created list")

        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = eventsListAdapter

        eventsListAdapter.notifyDataSetChanged()
    }

    fun addMockDataOnClick( v : View) {
        val eventItem = EventsItem( "Meeting 1", "Very long meeting", "1/1/2023", "1/2/2023"  )
        eventsList.add(eventItem)
        eventsListAdapter.notifyDataSetChanged()
    }

}