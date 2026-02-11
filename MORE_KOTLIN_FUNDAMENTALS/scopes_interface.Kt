fun main()
{

//     var myQuiz = Quiz()

    println("student Progress on questions: ${Quiz.answered}/${Quiz.total} ")
//     println(Quiz.progressText)
//     Quiz.printProgressBar()
//     var myQuiz = Quiz()
//     myQuiz.progressBar()
//     myQuiz.printQuiz()
    
    // using apply {}
    Quiz().apply{ printQuiz()}
}


// A class that has no activity, that is does not perform any action can be classified under a data class.
data class Question<T>(var questionText:String, var answer:T, var difficulty:Difficulty)
{
 	fun getQuestions()
    {
        println("Question: $questionText \t Diffuculty: $difficulty");
        println("Select Answer:\n $answer");
	}
}
enum class Difficulty {
    EASY, MEDIUM, HARD
}

// If you need multiple classes to have the same additional properties and methods, perhaps with differing behavior, you can define
//  these properties and methods with an interface

// You can define something called an interface that specifies the methods and/or properties that each of these classes must include.


interface ProgressPrintable {
    val progressString: String
    fun progressBar()
}

class Quiz: ProgressPrintable
{
    val question1 = Question<String>("Quoth the raven __", "nvermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28,Difficulty.HARD)
	
    //question1.getQuestions()
    //println(question2.toString())
    companion object StudentProgress  { // using companions to access object : singleton object
        var total: Int = 10
        var answered: Int = 5
	}
    
    override val progressString 
        get () = "${answered}/${answered} question"
    
    override fun progressBar()
    {
        repeat(Quiz.answered) {print("▓")}
        repeat(Quiz.total - Quiz.answered) {print("▒")}
        println("")
        print(progressString)    
    }
    
    // using let for accessing object properties: lambda : var someName {} // access varialbes usign it
    fun printQuiz()
    {
        println("")
        question1.let{
         	println(it.questionText)
         	println(it.answer)
         	println(it.difficulty)
        }
        println("")
        question2.let{
			println(it.questionText)
         	println(it.answer)
         	println(it.difficulty)  
        }
        println("")
        question3.let{
			println(it.questionText)
         	println(it.answer)
         	println(it.difficulty)
        }
        println("")
        
    }
}

// Extending class properties
val Quiz.StudentProgress.progressText:String
	get() = "Answered ${answered}/${total} questions." // when using get() defined below the variable used to se


/// Extending function 
fun Quiz.StudentProgress.printProgressBar ()
{
    repeat(Quiz.answered) {print("▓")}
    repeat(Quiz.total - Quiz.answered) {print("▒")}
    println("")
    print(Quiz.progressText)
}




// Scope functions allow you to concisely access properties and methods from a class without having to repeatedly access the variable name
