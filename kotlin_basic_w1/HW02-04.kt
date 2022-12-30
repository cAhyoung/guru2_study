package kotlin_basic_w1

// 5단에서 8단까지 출력하기
fun main() {
    for (i in 5..8 step 1)
        for (j in 1..9 step 1)
            println("$i X $j = ${i*j}")

    // 단 사이에 (*******************) 넣기
    for (i in 5..8 step 1) {
        for (j in 1..9 step 1)
            println("$i X $j = ${i * j}")
        println("*********************************")
    }
}