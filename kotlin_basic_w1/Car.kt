package kotlin_basic_w1

open class Car {
    var color : String = ""
    var speed : Int = 0

    companion object {
        var carCount : Int = 0
        const val MAXSPEED : Int = 200
        const val MINSPEED : Int = 0
        fun currentCarCount() : Int {
            return carCount
        }
    }

    constructor(color: String, speed: Int) {  // 생성자 코드
        this.color = color
        this.speed = speed
        carCount ++
    }
    constructor(speed: Int){
        this.speed = speed
    }

    constructor() {
    }

    open fun upSpeed(value: Int) {
        if (speed + value >= 200)
            speed = 200
        else
            speed = speed + value
    }

    fun downSpeed(value : Int) {
        if (speed - value <= 0)
            speed = 0
        else
            speed = speed - value
    }
}

// 상속
class Automobile : Car {
    var seatNum : Int = 0
    constructor(){
    }
    fun countSeatNum() : Int {
        return seatNum
    }

    //메소드 오버라이딩
    override fun upSpeed(value: Int) {
        if (speed+value >= 300)
            speed = 300
        else
            speed = speed + value
    }
}

fun main() {
    var auto : Automobile = Automobile()
    auto.upSpeed(250)
    println("승용차의 속도는 " + auto.speed + "km 입니다.")
}



// 메소드 오버로딩
// 한 클래스 내에서 메소드의 이름이 같아도 파라미터의 개수나 데이터 형식만 다르면 여러개를 선언할 수 있음
//class Car2 {
//    var color : String = ""
//    var speed : Int = 0
//
//    constructor(color: String, speed: Int) {  // 생성자 코드 -> parameter가 두개가 들어온다면 이 생성자를 이용
//        this.color = color
//        this.speed = speed
//    }
//
//    constructor(speed: Int) {  // parameter가 한개 들어온다면 이 생성자를 이용
//        this.speed = speed
//    }
//
//    constructor()  // parameter가 들어오지 않는다면 아무것도 하지 않음
//}

//fun main() {
////    var myCar1 : Car = Car()
////    myCar1.color = "빨강"
////    myCar1.speed = 0
////
////    var myCar2 : Car = Car()
////    myCar2.color = "파랑"
////    myCar2.speed = 0
////
////    var myCar3 : Car = Car()
////    myCar3.color = "초록"
////    myCar3.speed = 0
//
//    var myCar1 : Car = Car("빨강", 0)
//    var myCar2 : Car = Car("파랑", 0)
//    var myCar3 : Car = Car("초록", 0)
//
//    println("생산된 차의 대수(정적 필드) : " + Car.carCount)
//    println("생산된 차의 대수(정적 메소드) : " + Car.currentCarCount())
//    println("차의 최고 제한 속도 : " + Car.MAXSPEED)
//
//    println("PI의 값 : " + Math.PI)
//    println("3의 5제곱 : " + Math.pow(3.0, 5.0))
//
//
//    myCar1.upSpeed(50)
//    println("자동차1의 색상은 " + myCar1.color + "이며, 속도는 " + myCar1.speed + "km 입니다.")
//
//    myCar2.upSpeed(100)
//    println("자동차2의 색상은 " + myCar2.color + "이며, 속도는 " + myCar2.speed + "km 입니다.")
//
//    myCar3.upSpeed(70)
//    println("자동차3의 색상은 " + myCar3.color + "이며, 속도는 " + myCar3.speed + "km 입니다.")
//}