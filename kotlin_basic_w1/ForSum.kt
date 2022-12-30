package kotlin_basic_w1

fun main(){
    var sum = 0
    for(x in 1..10) {
            sum += x
    }
    println("sum: $sum")  // $를 이용해 문자열 안에 변수명을 넣을 수 있음

    for(x in 1..10) sum += x
    println("sum: $sum")
}