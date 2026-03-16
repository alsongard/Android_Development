import kotlinx.coroutines.* 
import kotlin.system.*
fun main() {
    val time = measureTimeMillis {
        runBlocking {
            delay(2000) // this is a suspend function suspend functions can only be run in another suspend function or in a corouting 
            println("sunny") 
            printTemperature()
            printForeCast()
    	}
    }
    
    println("Execution time: ${time / 1000.0} seconds")

}

suspend fun printTemperature()
{
    delay(3000)
	println("30\u00b0C")
}

suspend fun printForeCast()
{
    delay(4000)
	println("today is sunny!")	
}