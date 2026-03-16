import kotlinx.coroutines.* 
import kotlin.system.*
fun main() {
	runBlocking {
        println("Weather ForeCast")
		println(getWeatherForeCast())
        println("Happy Day!")
    
    }        
}
suspend fun getWeatherForeCast() = coroutineScope { // in this case the coroutine is viewed as a sychronous operation
    // within it however we have asychronous operations
    val foreCast: Deferred<String> = async {
        getForeCast()
    }
    val temp: Deferred<String> = async {
        getTemperature()
    }
    "Today's forecast ${foreCast.await()} ${temp.await()}"
} 
suspend fun getTemperature(): String
{
    delay(1000)
	return "30\u00b0C"
}

suspend fun getForeCast(): String
{
    delay(1000)
	return "today is sunny!"	
}