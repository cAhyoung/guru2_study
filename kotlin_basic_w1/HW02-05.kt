package kotlin_basic_w1

fun main(){
    var sum = 0
    var i = 0

    while(i <= 100){
        if (i % 2 == 1){
            sum += i
        }
        i++
    }
    println("sum(while) = $sum")

    sum = 0
    i = 0

    for (i in 1..100 step 2){
        sum += i
    }
    println("sum(for) = $sum")
}