fun main() {
    
   // # SETS
   var solarSystem = mutableSetOf("Earth", "Jupiter", "Mars")
   println(solarSystem)
   solarSystem.add("Venus")
   solarSystem.add("Sun")
   println(solarSystem)
   
   println(solarSystem.size)
   println("Earth" in solarSystem)
   println(solarSystem.remove("Sun"))
   
   // # MAPS
   //    A Map is a collection consisting of keys and values. It's called a map because unique keys are mapped to other values. A key and its accompanying value are often called a key-value pair.
// 	A map's keys are unique. A map's values, however, are not. Two different keys could map to the same value
// Maps can be declared using the mapOf() or mutableMapOf() function. Maps require two generic types separated by a comma—one for the keys and another for the values.
// A map can also use type inference if it has initial values. To populate a map with initial values, each key value pair consists of the key, followed by the to operator, followed by the value. Each pair is separated by a comma.

	var planetMoons = mutableMapOf(
    	"Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1
    )
    println(planetMoons.size)
    println(planetMoons["Mercury"])

}