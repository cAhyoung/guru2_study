package kotlin_basic_w1

var myVar : Int = 100  // global variable

fun main() {
    var myVar : Int = 0  // local variable
    println(myVar)

    var sum : Int = addFunction(10, 20)
    println(sum)
}

fun addFunction(num1: Int, num2: Int) : Int {
    var hap : Int
    hap = num1 + num2 + myVar

    return hap
}