fun main()
{
    val cookies = listOf(
    Cookie(
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut", 
        softBaked = true, 
        hasFilling = false, 
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
	)
    cookies.forEach{
        println("Menu Item: ${it.name}")
    }
//     The map() function lets you transform a collection into a new collection with the same number of elements. For example, map() could transform a List<Cookie> into a List<String> only containing the cookie's name, provided you tell the map() function how to create a String from each Cookie item.
	val fullMenu = cookies.map{
        "${it.name} - \$${it.price}"
    }
    println(fullMenu)
    fullMenu.forEach{
        println(it)
    }
    
//     The filter() function lets you create a subset of a collection. For example, if you had a list of numbers, you could use filter() to create a new list that only contains numbers divisible by 2.

	val softBakedCookies = cookies.filter{
		it.softBaked
    }
    println("SoftBaked Cookies:")
    softBakedCookies.forEach{
        println("${it.name} - \$${it.price}")
    }
//     The groupBy() function can be used to turn a list into a map, based on a function. Each unique return value of the function becomes a key in the resulting map. The values for each key are all the items in the collection that produced that unique return value.
// The data type of the keys is the same as the return type of the function passed into groupBy(). The data type of the values is a list of items from the original list.

	val groupedMenu = cookies.groupBy{
        it.softBaked
    }
    println(groupedMenu)

    // create 2 list 
    val softBakedMenu = groupedMenu[true] ?: listOf()
    val crunchyMenu = groupedMenu[false] ?: listOf()

	println("softBakedMenu:-->")
    softBakedMenu.forEach{
        println("${it.name}")
    }
    println("crunchyMenu:-->")
	crunchyMenu.forEach{
        println("${it.name}")
    }
    
//     The fold() function is used to generate a single value from a collection. This is most commonly used for things like calculating a total of prices, or summing all the elements in a list to find an average.
/*The fold() function takes two parameters:

    An initial value. The data type is inferred when calling the function (that is, an initial value of 0 is inferred to be an Int).
    A lambda expression that returns a value with the same type as the initial value.

The lambda expression additionally has two parameters:

    The first is known as the accumulator. It has the same data type as the initial value. Think of this as a running total. Each time the lambda expression is called, the accumulator is equal to the return value from the previous time the lambda was called.
    The second is the same type as each element in the collection
    */
    
    val totalPrice = cookies.fold(0.0){ total, cookie ->
        total + cookie.price
    }
    println("Total price is: $totalPrice")
    
//     When you first learned about collections, you learned that the sort() function could be used to sort the elements. However, this won't work on a collection of Cookie objects. The Cookie class has several properties and Kotlin won't know which properties (name, price, etc.) you want to sort by.

// For these cases, Kotlin collections provide a sortedBy() function. sortedBy() lets you specify a lambda that returns the property you'd like to sort by. For example, if you'd like to sort by price, the lambda would return it.price. So long as the data type of the value has a natural sort order—strings are sorted alphabetically, numeric values are sorted in ascending order—it will be sorted just like a collection of that type.
    
	val alphabeticalMenu = cookies.sortedBy{
    	it.name
	}
    println(alphabeticalMenu)
    alphabeticalMenu.forEach{
        println("${it.name}")
    }
}

class Cookie(	
    val name:String,
    val softBaked:Boolean,
    val hasFilling:Boolean,
    val price: Double)
{}

/*The first higher-order function that you learn about is the forEach()function. The forEach() function executes the function passed as a parameter once for each item in the collection*/
