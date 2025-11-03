import javax.xml.stream.events.Characters

fun main() {
    println("Hello World")
//    sayHello(54, "Mr. James")
//    println("Sum of ${doulbleSum(5.0, 2.2, 3)}")
//    concatenateStrings("Cause when we play", "Sofia the first")
//    galaxy(age=130000000)
//    gettingArrays()
//    val myMaxArray = arrayOf(1, 3, 5, 7, 9, 23, 29, 17)
//    val myMinArray = arrayOf(13, 11,23, 29,31, 37)
//    println(findMax(myMaxArray))
//    println(findMin(myMinArray))
//    val returnedValue = findNumber(5, myMaxArray)
//    if (returnedValue != null)
//    {
//        println("Found number is")
//        println("Found Number is $returnedValue")
//    }

    var car1 = Car()
    car1.distance = 10000
    car1.brand = "Mercedez"
    car1.name = "E250"
    car1.price = 2500000

    car1.move()
    car1.stop()


    var car2 = Car()
    car2.name  = "Tesla"
    car2.brand = "EV"
    car2.distance = 10000


    println("\n")
    println("The car ${car2.name} can travel to up to a distance of ${car2.distance} without refueling")
    println("The car is of type : ${car2.brand}")
}

fun introduction()
{
    println("hello world")

    // working with variables
    // syntax: var(keyword) variableName: dataType = value
    var favName: String = "Jupiter"
    println("hello $favName")


    // Int datatype
    var age: Int = 1000
    println("Earth is of age  $age")

    // val keyword: the ``val`` keyword makes a constant variable that is it's value can never be changed
    val galaxy: String = "Andromeda"

    println("the nearest galaxy to ours is $galaxy")

    // BOOLEAN DATATYPES
    var myBoolean: Boolean = true

    var mySingleChar: Char = 'D'

    println("myBoolean=$myBoolean and mySingleChar:$mySingleChar")

    // ARITHMETIC OPERATIONS
    val x = 30
    val y = 25

    // x = 40 the val keyword declares a variable whose value cannot be changed
    var result = x + y
    println("Sum of x:$x and y:$y is $result")


    var new_value_1 = 2
    var new_value_2 = 8

    // TO PERFORM OPERATIONS WE
    println("sum of $new_value_2  and $new_value_1 is ${new_value_2 + new_value_1}")
    println("division of $new_value_2  and $new_value_1 is ${new_value_2 / new_value_1}")
    println("multiplication of $new_value_2  and $new_value_1 is ${new_value_2 * new_value_1}")
    println("modulus of $new_value_2  and $new_value_1 is ${new_value_2 % new_value_1}")



    // CONTROL STRUCTURES
    if (new_value_1 > 3)
    {
        println("New value is greater than 3")
    }
    else
    {
        println("Not greater than 3")
    }

    if (new_value_2 == 8)
    {
        println("value is 8")
    }

    if (new_value_2 != 2)
    {
        println("new_value_2 is not 2")
    }
    var score: Int = 100
    val isActive: Boolean = true
    if (score > 99 && isActive)
    {
        println("score is greater than 99 and isActive is ${isActive}")
    }

    val text2 = if (new_value_1 >= 2 && new_value_2 < 10)
    {
        println("new value is 1 is equal or greateer than 2 and new value 2 is less than 10")
        "condition true"
    }
    else
    {
        println("new value 1 is not equal or greater than 2 and new value 2 is not less than 10")
        "condition false"
    }
    println("${text2}")

    var text =  if (isActive) "your are welcomed to text" else 5
    println(text)


    val new_string: String?  = "null"

    if (new_string != null) // checking if not equal to String type
    {
        println("new_string value is not null ${new_string}")
        println(new_string.length)
    }
    else
    {
        println("new_string value is null")
    }
}
fun sayHello(age:Int, name: String)
{
    println("Hello Mr/Mrs.${name} and age: ${age}")
}

fun doulbleSum(a:Double, b: Double, c: Int): Double {
    return a + b + c
}

fun concatenateStrings(a:String, b:String){
    println(a + b)
}


// working with arguments
fun galaxy(name: String ="milky way", age:Int)
{
    println("The galaxy $name is $age old")
}

fun gettingArrays()
{
    var myArray: Array<String> = arrayOf("Apple", "Banana", "Watermelon")
    println(myArray[0])
}

fun findMax(myArray: Array<Int>): Int
{
    var max: Int = 0

    for (num in myArray)
    {
        if (num > max)
        {
            max = num
        }
    }
    return max
}


fun findMin(myArray: Array<Int>): Int
{
    var min: Int = 0
    for (num in myArray)
    {
        if (num < min)
        {
            min = num
        }
    }
    return min
}
fun findNumber(myVal: Int, myArray:Array<Int>): Int?
{
    for (num in myArray)
    {
        if (myVal == num) {
            return num
        }
    }
    return null
}

class Car()
{
    var name = ""
    var brand = ""
    var price = 0
    var distance = 0


    fun travelledDistance(): String
    {
        return "The car $name has travelled for ${distance}km"
    }
    fun move()
    {
        println("The car $name is moving")
    }
    fun stop()
    {
        println("The car $name has stopped moving ")
    }
}
