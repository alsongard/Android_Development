data class Event(var title:String, description:String?, daypart:DayPart, duration:Int)
{}

enum class DayPart {
    MORNING, AFTERNOON, EVENING
}



var myFirstEvent = Event("Study Kotlin", "Commiting to study kotlin at least 15 minutes per day", DayPart.EVENING, 15)

println(myFirstEvent.title)
println(myFirstEvent.description)
println(myFirstEvent.daypart)
println(myFirstEvent.minute)

/*
Solution:
data class Event(
    val title: String,
    val description: String? = null,
    val daypart: String,
    val durationInMinutes: Int,
)
 */

fun main()
{
    var events = MutableListOf(
        Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0),
        Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15),
        Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30),
        Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60),
        Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10),
        Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)
    )
    var shortListEvents = events.filter{
        $it.durationInMinutes < 60
    }
    println("You have ${shortListEvents.size} short events.")
    shortListEvents.forEach{
        println("Event Name: ${it.title} is on the short listed event.")
    }

    println("Details for each event")
    events.forEach{
        println("Moring: $")
    }

    ver groupedEvents = events.groupBy{
        it.daypart    
    }
    println(groupedEvents)

    groupedEvents.forEach { (daypart, events) ->
        println("$daypart: ${events.size} events")
    }
    eveningEvents = groupedEvents["EVENING"]
    moriningEvents = groupedEvents["MORNING"]
    afternoonEvents = groupedEvents["AFTERNOON"]

    println("Evening: ${eveningEvents.size} events")
    println("Morning: ${moriningEvents.size} events")
    println("Afternoon: ${afternoonEvents.size} events")

    // get last events
    println("Last event for the dayy is ${events[events.size - 1].name}")


    val Event.durationOfEvent: String // is this an interfrace or what
        get() = if (this.durationInMinutes < 60){
            "short"
        } else {
            "long"
        }

    println("Duration of first event of the day: ${events[0].durationOfEvent}")

}

/*Task 3 Solution:
val events = mutableListOf<Event>(event1, event2, event3, event4, event5, event6)
 */



/*
Task 4
val shortEvents = events.filter { it.durationInMinutes < 60 }
println("You have ${shortEvents.size} short events.")

 decides the user should be able to see a summary of their short events, based on the event's duration. For example, "You have 5 short events."

A "short" event is an event that is less than 60 minutes.
 */

/*
Task 5: 

Users to be able to see a summary of all the events and their daypart.

The output should be similar to:

Morning: 3 events
Afternoon: 4 events
Evening: 2 events

val groupedEvents = events.groupBy { it.daypart }
groupedEvents.forEach { (daypart, events) ->
    println("$daypart: ${events.size} events")
}
*/


/*
Task 6:
    get the last event on the collection using the last() instead of: events[event.size - 1] e.g if events.size is 6 : indices[0, 1, 2, 3, 4, 5]
*/


/*
Task 7:
val durationOfEvent = if (events[0].durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }
println("Duration of first event of the day: $durationOfEvent")

 */