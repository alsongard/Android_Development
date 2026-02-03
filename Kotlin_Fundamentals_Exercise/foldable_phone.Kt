open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }
    
    fun switchOff() {
        isScreenLightOn = false
    }
    
    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}


class FoldablePhone(var foldableStatus: Boolean) : Phone()
{
	fun checkStatus(){
    	println("Hello Foldable Phone")
    }
    override fun switchOn()
    {
        if (foldableStatus) 
        {
            isScreenLightOn = false
        }
        else 
        {
            isScreenLightOn = true
        }
    }
}

fun main()
{
    val redmi = Phone(false)
    redmi.checkPhoneScreenLight()
    
    val samsungFoldable = FoldablePhone(true) 
    samsungFoldable.checkPhoneScreenLight()
}