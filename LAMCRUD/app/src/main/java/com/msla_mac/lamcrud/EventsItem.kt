package com.msla_mac.lamcrud

class EventsItem (var name: String, var description: String,
                  var startDate: String, var endDate : String  ) {

    fun toCSV(): String {
        return "$name, $description, $startDate, $endDate"
    }

    override fun toString(): String {
        return "$name : $description"
    }


}