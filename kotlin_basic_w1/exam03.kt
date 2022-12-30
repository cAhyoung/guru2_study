package kotlin_basic_w1

fun main(){
    var one : IntArray = intArrayOf(10, 20, 30)
    for (i in one.indices) {  // 인덱스로 접근해서 출력
        println(one[i])
    }

    for (value in one){  // arr 내의 요소에 직접 접근
        println(value)
    }

    var two : Array<String> = arrayOf("하나", "둘", "셋")
    for (i in 0..2 step 1) {  // for문을 이용한 출력
        println(two[i])
    }

    var k : Int = 0
    while(k < two.size){  // while문을 이용한 출력
        println(two[k])
        k++
    }
}