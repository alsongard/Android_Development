/*
In the initial code provided in the following code snippet, write a program that converts a temperature from one scale to another with these formulas:

    Celsius to Fahrenheit: ° F = 9/5 (° C) + 32
    Kelvin to Celsius: ° C = K - 273.15
    Fahrenheit to Kelvin: K = 5/9 (° F - 32) + 273.15
 */


fun main() {
    val conversionFormula: (Double, String, String)-> Double = { measureMent, initialUnit, finalUnit  ->
   	when {
        initialUnit == "Celsius" && finalUnit == "Fahrenheit" -> (9.0/5.0 ) * measureMent + 32
        initialUnit == "Fahrenheit" && finalUnit == "Celsius" ->  measureMent - 273.15
        initialUnit == "Fahrenheit" && finalUnit == "Kelvin" -> (5.0/9.0) * (measureMent -32) + 273.15
        else -> 0.0
    }

}
    // Fill in the code.
    printFinalTemperature(27.0,"Celsius","Fahrenheit",conversionFormula);
    printFinalTemperature(250.0,"Kelvin","Celsius",conversionFormula);
    printFinalTemperature(10.0,"Fahrenheit","Kelvin",conversionFormula);

}


fun printFinalTemperature(
    initialMeasurement: Double, 
    initialUnit: String, 
    finalUnit: String, 
    conversionFormula: (Double, String, String) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement, initialUnit, finalUnit)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}