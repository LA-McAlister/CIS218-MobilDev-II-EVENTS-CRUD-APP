package com.msla_mac.lamcrud

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


internal class EventsAdapter(private var eventsList : List<EventsItem>,
                             private val listener: (position: Int) -> Unit ):
    RecyclerView.Adapter<EventsAdapter.MyViewHolder>() {

    // TODO: finish adapter
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view),
    View.OnClickListener{
        var item: TextView = view.findViewById(R.id.eventNameText)
        var description: TextView = view.findViewById(R.id.eventDescriptionText)
        var startDate: TextView = view.findViewById(R.id.eventStartDate)
        var endDate: TextView = view.findViewById(R.id.eventEndDate)

        init {
            itemView.setOnClickListener( this )
        }
        override fun onClick(v: View){
            listener (adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.event_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // TODO: finish binding to XML view
        //get the data from the list and fill in the various CELL from fields
        val eventItem = eventsList[position]
        holder.item.text = eventItem.name
        holder.description.text = eventItem.description
        holder.startDate.text = eventItem.startDate
        holder.endDate.text = eventItem.endDate
    }

    override fun getItemCount(): Int {
        return eventsList.size
    }
}
