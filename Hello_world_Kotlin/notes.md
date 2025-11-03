# first file
1. go to src: right click and open new file as kotlin

2. name file : Main (notice the case)

### declaring a function

Syntax:
```kotlin
fun functionName()
{
    //do sth
    println('hello world')
    // Int datatype
    var age: Int = 1000
    println("Earth is of age  $age")

    // val keyword: the ``val`` keyword makes a constant variable that is it's value can never be changed
    val galaxy: String = "Andromeda"

    println("the nearest galaxy to ours is $galaxy")
}
```
``fun`` this is a keyword for declaring a function


Example:
```kotlin
fun main()
{
    println("hello world")
}
```

working with variables
syntax: var(keyword) variableName: dataType = value
```kotlin
// syntax: var(keyword) variableName: dataType = value
var favName: String = "Jupiter"
println("hello $favName")
```    

after stating the type of your variable always ensure the data|value assigned is of that type:
example:
| type | value | 
| --- | --- |
| String | "abcd.." |
| Int | 123.. |
| Char| 'D' (takes only a single character|
| Boolean |  true / false |
| | |


### arithmetic operations 
- addition
- division
- multiplication
- subtraction
- modulus

To perform an operation e.g addition within print statement we use curly braces:
Example:
```kotlin
println("sum of new_value2 and new_value_1 : ${new_value_2 + new_value+1}")
```

### Nullable values
when assigning null values to variables, you use the the question mark symbol:
```kotlin
var myString: String? = null
```
You must define the type of variable followed by the symbol above. 


### string methods
- length
```kotlin
println(myString.length)
```

### tenary operations
```kotlin
var myText: String?  = null
myText?.length
```


### return types
by default any function you define return type of Unit. this is similar to void in other programming languages
```kotlin
def doubleSum(a:Double, b:Double, c:Int): Double {
    // from the above we defined the return type
    return a + b + c
}
```

### strings
**Concatenation**
To concatenate strings in kotlin we use the ``+`` symbol

```kotlin

var name: String = "Jupiter"
var location: String = "Milky Way Galaxy"
println(name + location)
```

It is also possible to concatenate strings with boolean values.
```kotlin
var notificationsEnabled = true

println("Notification Status ${notificationsEnabled}")
```


### named arguments
You can also pass named arguments to a function as shown below:
```kotlin
sayHello(name="James Tony", age=32)
```

### default arguments
```kotlin
fun createServer(name="express", port:String)
{
    println("Hello this is server ${name} and running in port: ${port}")
}
```


### working with arrays
when working with arrays:
```kotlin
var myArray: Array<String> = arrayOf("Banana", "Apple")
```



### Object Oriented Programming
Define your class
A class can have multiple attributes and methods/functions
```kotlin

```