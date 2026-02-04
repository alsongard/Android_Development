fun main() {
    
    // INTRODUCITON TO ARRAYS: NON-MUTABLE, ACCESSING USING INDEX
    var rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
    var gasPlanets = arrayOf<String>("Jupiter", "Saturn", "Uranus")
    println(rockPlanets[0])
    var solarSystem = rockPlanets + gasPlanets
    println(solarSystem[0])
    
	// lIST: MUTABLE 
    // List and MutableList
    // the listOf does not return an array and you can access it's element using indexing method || get()
    // not necessary to pass data type to : listOf<String> || arrayOf<String>
    var myFavoriteThings = listOf("Jupiter", "GameDev", "Data Analysis", "BlockChains", "FullStack Dev", "CyberSecurity")
    println(myFavoriteThings.get(0))
    
    // using indexof for searching elements index
    println("What is the index of Jupiter in myFavoriteThings: ${myFavoriteThings.indexOf("Jupiter")}")
    
    
    // USING iteration: for loop 
    for (item in myFavoriteThings)
    {
        println("Index: ${myFavoriteThings.indexOf(item)} : Value : ${item}")
    }
    
    // ## Using mutableList for modifying arrays
    /*
     * 	There are two versions of the add() function:
        The first add() function has a single parameter of the type of element in the list and adds it to the end of the list.
        The other version of add() has two parameters. The first parameter corresponds to an index at which the new element should be inserted. The second parameter is the element being added to the list.
	*/
    
    
    var milkyWayGalaxy = mutableListOf("Earth", "Jupiter", "Uranus", " Sagittarius A")
    println(milkyWayGalaxy)
    milkyWayGalaxy.add("Pluto")
    println(milkyWayGalaxy)
    milkyWayGalaxy.add(4, "Mars")
    println(milkyWayGalaxy)
    
    
    /*Remove elements from a list
		Elements are removed using the remove() or removeAt() method. You can either remove an element by passing it into the remove() method or by its index using removeAt().
    */
    milkyWayGalaxy.remove("Pluto")
    milkyWayGalaxy.add("Saturn")
    
    println(milkyWayGalaxy)
    
    
    println("Jupiter" in myFavoriteThings)
    println(myFavoriteThings.contains("GameDev"))
}
