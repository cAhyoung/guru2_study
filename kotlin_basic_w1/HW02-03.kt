package kotlin_basic_w1

fun main(){
    var two = Array<IntArray>(3, {IntArray(3)})
    // var value = arrayOf(arrayOf(100, 110, 120), arrayOf(130, 140, 150), arrayOf(16, 170, 180))

    var value = 100
    for (i in 0..2 step 1){
        for (j in 0..2 step 1){
            two[i][j] = value
//            println("two[$i][$j]: $value")
//            value += 10
             value += 10
             println("two[$i][$j]: ${two[i][j]}")

        }
    }
}