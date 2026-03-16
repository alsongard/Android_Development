/* when using launch it creates 2 coroutines that run concurrenlty */
import kotlinx.coroutines.* 
import kotlin.system.*
fun main() {
    val time = measureTimeMillis {
        runBlocking {
             launch { //using launch 
            	printTemperature()
            }
        	launch {
            	printForeCast()
        	}
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

