package kotlin_basic_w1

fun main() {
    var score : Int = 90

    if(score >= 90) {
        println("if : 합격(장학생)")
    }
    else if(score >= 60){
        println("if : 합격")
    }
    else {
        println("if : 불합격")
    }

    when(score) {
        in 90..100 -> println("합격(장학생)")
        in 60..89 -> println("합격")
        else -> println("불합격")
    }
}