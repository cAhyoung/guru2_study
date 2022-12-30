package kotlin_basic_w1

// fun sum(a: Int, b: Int) = a + b

fun sub(a: Int, b: Int) : Int = a - b

fun mul(a: Int, b: Int) : Int {
    return a * b
}

fun main() {
    var num1 : Int
    var num2 : Int

    print("number1 = ")
    num1 = readLine()!!.toInt()
    print("number2 = ")
    num2 = readLine()!!.toInt()

    println(mul(num1, num2))
    println(sum(num1, num2))
    println(sub(num1, num2))
}