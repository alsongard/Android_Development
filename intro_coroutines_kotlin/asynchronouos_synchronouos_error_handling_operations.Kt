import kotlinx.coroutines.* 
import kotlin.system.*
fun main() {
	runBlocking {
        try
        {
            println("Weather ForeCast")
            println(getWeatherForeCast())
            println("Happy Day!")
        }
        catch(e: AssertionError)
        {
            println("Caught exception in runBlocking(): $e")
            println("Invalid Temp value")
        }
        
    
    }        
}
suspend fun getWeatherForeCast() = coroutineScope { // in this case the coroutine is viewed as a sychronous operation
    // within it however we have asychronous operations
    val foreCast: Deferred<String> = async {
        getForeCast()
    }
    val temp: Deferred<String> = async {
        try
        {
        	getTemperature()
        }
        catch(e:AssertionError)
        {
         	println("Error getting temp ")
            "Temperature value cannot be found at the moment"
		}
    }
    "Today's forecast ${foreCast.await()} ${temp.await()}"
} 

suspend fun getTemperature(): String
{
    delay(1000)
    // setting an error using throw keyword 
    throw AssertionError("Invalid temp value")
	return "30\u00b0C"
}

suspend fun getForeCast(): String
{
    delay(1000)

    return "today is sunny!"
}