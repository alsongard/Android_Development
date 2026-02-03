fun main()
{
    println("Hello World")
    var trickFunction = ::trick
    xmas()
    treats();
    val coins:(Int)->String = { theCoins ->
        "I was given extra $theCoins on my treat! Hurray"
    }
    val cupcake:(Int)->String={ quantity ->
        "I was given extra $quantity of cupkaes! Hurray"   
    }
    var treatFunction = treatTrick(false, coins)
    var myTrick = treatTrick(true, null)
    treatFunction()
    myTrick()
}
fun treatTrick(isTrick:Boolean, isExtra:((Int)->String)?): ()->Unit
{
	if (isTrick)
    {
        if (isExtra != null)
        {
			println(isExtra(1))
        }
        return xmas
    }
    else
    {
        if (isExtra != null)
        {
            println(isExtra(5))
        }
        return treats
    }
}

val treats: ()->Unit = {
    println("Have a treat!")
}
fun trick()
{
	println("Trick or Treats?")
}
val xmas = {
    println("Hello it's Christmas Time")
}
// working with lambda
/*
 * to define a function as a lambda function we use curly braces which define the function body and a variable assigned
 * With this there is no need for function operator refrence 
 * 
 * 
 * # funciton Types
 * To define a function type we do the following:
 * (..|| someArguments:argumentType)->TypeOfReturn
 * Example:
 * ```
 * var treats: ()->Unit {
 * 	println("...")
 * }
 * 
 * */
