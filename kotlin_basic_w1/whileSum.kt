package kotlin_basic_w1

fun main() {
    var sum = 0
    var x = 0

    while (x <= 10) {
        sum += x
        x++
    }
    println("sum: $sum")

    sum = 0
    x = 0

    do{
        // 안의 내용을 처리해라!
        sum += x
        x++
    }while(x <= 10)  // 이 조건을 만족한다면
    // 조건을 뒤에서 확인하기 때문에 처음부터 조건에 맞지 않더라도 첫 값은 수행됨
    println("sum: $sum")
}