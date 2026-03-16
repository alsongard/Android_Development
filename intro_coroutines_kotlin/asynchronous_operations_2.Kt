import kotlinx.coroutines.* 
import kotlin.system.*
fun main() {
	runBlocking {
		val foreCast: Deferred<String> = async {
            getForeCast()
        }
        val temp: Deferred<String> = async {
            getTemperature()
        }
		println("Today's forecast ${foreCast.await()} ${temp.await()}")
    
    }        
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