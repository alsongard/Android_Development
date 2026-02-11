fun main()
{

//     var myQuiz = Quiz()

    println("student Progress on questions: ${Quiz.answered}/${Quiz.total} ")
    println(Quiz.progressText)
    Quiz.printProgressBar()
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

class Quiz()
{
    val question1 = Question<String>("Quoth the raven __", "nvermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28,Difficulty.HARD)
	
// 	question1.getQuestions()
//     println(question2.toString())
    companion object StudentProgress  { // using companions to access object : singleton objetc
        var total: Int = 10
        var answered: Int = 5
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