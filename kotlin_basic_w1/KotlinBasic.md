# Kotlin
- 특징
  - 자바와 100% 상호호완이 가능하여 자바의 코드를 대체할 수 있음
  - 자바보다 문법이 단순함
  - 프로그램 안정성 good
  - var 또는 val 예약어를 통해 데이터 형식을 선언하지 않고 변수를 선언할 수 있음
- 변수선언
  - 암시적 선언
    - 변수의 데이터 형식을 지정하지 않고, 대입되는 값에 따라 자동으로 변수의 데이터 형식이 지정됨
    - 초기화 하지 않는 경우에는 데이터 형식을 반드시 명시해야 함
    ```kotlin
    var var1 = 10
    var var2 = 10.1f
    var var3 = 10.2
    ```
  - var(variable)
    - 일반 변수를 선언할 때 사용
    - 필요할 때마다 다른 값을 대입할 수 있음
  - val(value)
    - 변수 선언과 동시에 값을 대입하거나, 초기화 없이 선언한 후 한번만 값 대입 가능
    - 한번 값을 대입하고 나면 값을 **변경할 수 없음**
  ```kotlin
    var myVar : Int 100
    myVar = 200 // 가능
    
    val myVal : Int 100
    myVal = 200 // 에러
  ```
    
- 데이터 형식 변환
  - 캐스팅 연산자 이용
  ```kotlin
  var a : Int = "100".toInt()
  var b : Double = "100.123".toDouble()
  ```
- null
  - Kotlin은 변수에 null값을 넣을 수 없음
  - 변수 선언 시 데이터 형식 뒤에 ?를 붙이면 대입 가능
  ```kotlin
  var notNull : Int  = null // error
  var okNull : Int? = null // ok
  ```
  - 변수가 null값이 아니라고 표시해야하는 경우 !! 이용
  ```kotlin
  var ary = ArrayList<int>(1) // 1개짜리 배열 리스트
  ary!!.add(100) // array에 100 추가
  ary!!.add(null) // error
  ```
- 조건문
  - 조건이 True 또는 False일 때 어떤 작업을 할 지 결정할 수 있도록 함
  - 다른 말로 *이중분기*라고도 함
  ```kotlin
  if (condition) {
  // True일 때 
  }
  else {
  // False일 때
  }
  ```
  - when문은 다중 if문으로 여러 경우에 대한 작업을 작성할 수 있음
  ```kotlin
  when (expression) {
  value1 -> // value1이라면 이 부분 실행
  value2 -> // value2라면 이 부분 실행
  else -> // 어디에도 해당되지 않는다면 이 부분 실행
  }
  ```
  - 만약 특정 값이 구간이라면 ..을 이용해 구간을 나타낼 수 있음
    - e.g. in 80 .. 90 / in 1 .. 10
- Array
  - 여러개의 데이터를 하나의 변수에 저장하기 위해 사용
  ```kotlin
  var arr = Array<data type>(counts, {first arr})
  var arr = Array<data type>(counts) {first arr}
  ```
  - 일차원 배열을 선언하는 다른 방법
  ```kotlin
  val numbers = arrayOf(4, 5, 7, 3) // 정수형으로 초기화된 배열
  val animals = arrayOf("cat", "dog", "lion")
  // arrayOfNulls()는 빈 배열을 선언
  ```
  - 이차원 배열 선언하기
  ```kotlin
  // Array를 이용해 선언하기
  var arr = Array<data type>(row counts, {data type(col counts)})
  
  // arrayOf를 이용해 선언하기
  val arr1 = arrayOf(1, 2, 3)
  val arr2 = arrayOf(4, 5, 6)
  val arr3 = arrayOf(7, 8, 9)
  val arr2d = arrayOf(arr1, arr2, arr3)
  ```
    - 3x4 배열 선언하고 값 대입하기
    ```kotlin
    var arr = Array<IntArray>(3, {IntArray(4)})
    arr[0][0] = 100
    arr[2][3] = 200
    ```
  - 배열을 선언하며 바로 값을 대입하기
  ```kotlin
  var three : IntArray = intArrayOf(1, 2, 3)
  var one = ArrayList<Int>(4)
  one.add(10)  // index 0에 더해줌
  one.add(20)  // index 1에 더해줌
  var hap = one.get(0) + one.get(1)
  // 첫번째 값과 두번째 값을 꺼내서 더함
  ```
- 반복문
  - for문
  ```kotlin
  for (variable in start...end step increase) {
  // 반복시킬 것을 작성
  }
  
  for (variable in arrName.indices) { // arr를 순차적으로 둘러봄
  // 반복시킬 것을 작성
  }
  ```
    -배열의 모든 값을 출력해보기
    ```kotlin
    var one : IntArray = intArrayOf(10, 20, 30, 40)
    for (i in one.indices) {
        println(one[i])
    }
    ```
    - 첨자 없이 바로 배열의 값을 처리하고 싶다면?
    ```kotlin
    for (variable in arrName) {
    // varialbe 이용
    }
    ```
  - while문
  ```kotlin
  while (condition) {
    // condition이 True인 경우 실행하는 부분
  }
  ```
   - break vs continue
     - 반복문에 break를 넣는 경우 반복문 밖으로 탈출함
     - 반복문에 continue를 넣는 경우 continue 뒤에 있는 문장을 거치지 않고 다시 반복문의 처음으로 돌아감

- 함수
  ```kotlin
  fun sum(a: Int, b:Int) : Int {
    var sum = a + b
  
    return sum
  }
  
  fun funName([varName: dataType, varName2: dataType]) : [return var dataType] {
    expressions
  
    return returnVar
  }
  ```
  - 코틀린은 다중 패러다임 언어로 함수형 프로그래밍과 객체지향 프로그래밍이 가능함
  - 함수형 프로그래밍을 하는 이유는 코드를 간략하게 할 수 있으며, 테스트나 재사용성이 증가함
    - 순수 함수, 람다식, 고차함수를 사용해서 구성함
  ```kotlin
  fun sum(a: Int, b: Int) {
  return a + b
  }
  
  // 간략한 버전
  fun sum(a: Int, b: Int): Int = a + b
  fun sum(a: Int, b: Int) = a + b
  ```
  - pure function (순수함수)
    - 부작용이 없는 함수
    - 동일한 입력 파라미터에 대해서는 항상 같은 결과를 출력하거나 반환함
    - 값이 예측이 가능해 결정적임(deterministic)
    - 순수함수의 조건
      - 같은 인자에 대해 항상 같은 값을 반환함
      - 함수 외부의 어떤 상태도 바꾸지 않음
    ```kotlin
    fun sum(a: Int, b: Int) : Int {
        return a + b //  동일한 
    }
    ```
  - lamda
    - 익명 함수의 한 형태로 이름 없이 사용 및 실행가능
    - 람다대수로부터 유래
    - 람다식은 고차함수에서 인자로 넘기거나 결과값으로 반환하는 등의 작업이 가능함
    - 변수에 람다식 적용 가능
    ```kotlin
    fun main() {
    var result : Int
    val multi = {x: Int, y: Int -> x*y} // 일반 변수에 람다식 할당
    
    result = multi(10, 20) // 람다식이 할당된 변수는 함수처럼 사용 가능
    println(result)
    }
    ```
    - 람다식은 {}로 감싸며 fun 예약어 사용 X
    - {} 안 -> 의 왼쪽은 파라미터, 오른쪽은 함수의 내용을 작성
    - -> 오른쪽 문장이 여러개라면 ;로 구분
    - 내용 중 마지막 문장은 반환값(return)
    ```kotlin
    buttonVar.setOnClickListener {
      // 버튼을 클릭하면 실행될 내용
    }
    ```
  - 고차함수(high-order funtion)
    - 일반 함수를 인자나 반환값으로 사용
    ```kotlin
    fun main() {
        println(highFunc({x, y -> x + y}, 10, 20))  // 람다함수를 인자로 넘김
    }
    fun highFunc(sum: (Int, Int) -> Int, a: Int, b: Int) : Int = sum(a, b)
    ```
- 메소드
  - 기본 메소드인 main() 함수 외에 사용자가 메소드를 추가할 수 있음
  - 메소드를 호출할 때 파라미터를 넘길 수 있음
  - 메소드에서 사용된 결과를 return 문으로 돌려줄 수 있음
- 변수
  - 전역변수
    - 모든 메소드에서 사용됨
  - 지역변수
    - 메소드 내부에서만 사용됨

- 클래스
  - 변수(필드)와 메소드로 구성
  - 객체지향 관점에서의 클래스
    - 실 세계의 객체들이 가질 수 있는 상태와 행동을 담음
  - 정적 필드(static field)
    - instance를 생성하지 않고 class 자체에서 사용되면 변수
    - companion object{} 안에 작성하여 정적 필드를 만듬
  - 정적 메소드(static method)
    - 메소드 또한 companion object{} 안에 작성
    - instance를 생성하지 않고도 className.methodName()으로 호출하여 사용 가능
  - 상수 필드
    - 정적필드에 초깃값을 입력하고 const val로 선언
    - 선언 후 값을 변경할 수 없음
    - 상수필드는 대문자로 구성하는 것이 일반적임
    - 클래스 안에 상수를 정의할 때 사용
  - 클래스의 상속
    - 기존의 클래스가 가지고 있는 것을 그대로 물려받으면서 필요한 필드나 메소드를 추가로 정의함
    - 구조
      - superclass(부모클래스)
      - subclass(자식클래스) -> superclass의 필드와 메소드를 선언 없이 사용함
      - method overriding -> superclass의 메소드를 무시하고 새로 정의함
    - 추상 클래스
      - 추상 클래스는 instance 생성 불가
      - 추상클래스는 클래스 앞에 abstract 키워드를 붙여서 지정함
      ```kotlin
      // instance화
      var auto : Automobile  = Automobile()
      ```
    - 추상 메소드
      - 본체가 없는 메소드
      - 메소드 앞에 abstract 키워드를 붙여서 지정
      - 추상 메소드를 포함하는 클래스는 추상 클래스로 지정해야 함
      - 공통적으로 사용되는 기능을 추상 메소드로 선언하고, 추상 클래스를 상속받은 후 추상 메소드를 오버라이딩해서 사용하기 위함
      - implement(구현하다) -> 추상 메소드를 오버라이딩 하다
    - 변수의 다형성
      - 서브 클래스에서 생성한 인스턴스를 자신의 클래스 변수에 대입할 수 있는 것을 의미
      - 하나의 변수에 여러종류의 인스턴스를 대입할 수 있음
    - 인터페이스
      - 추상 클래스와 성격이 비슷함
      - interface 키워드를 사용하여 정의하고 내부에는 추상메소드를 선언함
      - 클래스에서 인터페이스를 받아 완성할 때 상속과 마찬가지로 ':인터페이스 이름' 형식을 사용함
      - 인터페이스는 '상속받는다'고 하지 않고 '구현한다'고 함
      - kotlin은 다중상속을 지원하지 않음
        - interface를 이용해 다중상속과 유사하게 작성할 수 있음
- 추가적인 문법
  - 패키지
    - 클래스와 인터페이스가 많아지면 관리하기 어려워 패키지단위로 묶어서 관리함
    - package 패키지명
    ```kotlin
    // 자바 프로젝트처럼 디렉토리와 매치되어야 하지는 않음
    package  com.example.edu
    class Person(val name: String, val age: Int)
    ```
    - 패키지를 지정하지 않으면 이름이 없는 기본(default) 패키지 포함
    - import 이름이 충돌하면 as 키워드를 이용해 로컬에서 사용할 이름을 변경하여 사용
    ```kotlin
    import com.example.edu.Person
    import com.example.edu.Person as User
    ```
    - import는 클래스 뿐만 아니라 다른 것도 불러올 수 있음
    - 최상위 레벨 함수와 property, object 선언의 함수와 property, 열거형 상수
    
    |    패키지 이름      |                      설명                         |
    |---------------------|---------------------------------------------------|
    | kotlin.*            | Any, Int, Double 등 코어 함수와 자료 형           | 
    | kotlin.text.*       | 문자와 관련된 API                                 |
    | kotlin.sequences.*  |컬렉션 자료형의 하나로 반복이 허용되는 개체를 열거 |
    | kotlin.ranges.*     | If문이나 for문에서 사용할 범위 관련 요소          |
    | kotlin.io.*         | 입출력 관련 API                                   |
    | kotlin.collections.*| List, Set, Map 등의 컬렉션                        |
    | kotlin.annotation.* | 어노테이션 관련 API                               |
  - 제네릭스(Generics)
    - 데이터의 안전성을 보장
    - 제네릭스를 사용해 strList에 문자열만 들어가도록 설정할 수 있음
    - 다음 코드의 마지막 행은 컴파일 오류가 발생함
    ```kotlin
    var strList = ArrayList<String>(4)
    strList.add("첫번째")
    strList.add("두번째")
    strList.add(3)  //error
    ```
    - 제네릭스는 String분만 아니라 Int, Double 등을 사용할 수 있음
    - 사용자가 정의한 클래스 형에도 사용 가능
  - 예외(exception)
    - Kotlin 프로그램 실행 중에 발생하는 오류로 실행 도중의 잠재적인 오류까지 검사할 수 없어 비정상적으로 프로그램이 종료되는 경우
      - 운영체제의 문제: 잘못된 시스템 호출의 문제
      - 입력값의 문제: 존재하지 않는 파일, 숫자입력란에 문자 입력 등
      - 받아들일 수 없는 연산: 0으로 나누기 등
      - 메모리의 할당 실패 및 부족
      - 컴퓨터 기계 자체의 문제: 전원 문제, 망가진 기억장치 등
    ```kotlin
    try {
        // 예외 가능성있는 문장
    } catch(e: /*예외처리 클래스 명*/) {
        // 예외처리를 위한 문장
    } finally {
        //반드시 실행되어야 하는 문장
    }
    ```
  - 날짜 형식
    - DataFormat 클래스를 상속받은 SimpleDataFormat 사용
    - 년월일, 시분초와같은 일반적 표현이 가능
    ```kotlin
    import java.text.DateFormat
    import java.text.SimpleDateFormat
    import java.util.*
    
    fun main() {
        var now = Date
        var sFormat : SimpleDataFormat
    
        sFormat = SimpleDateFormat("yyyyMMdd")
        sFormat = SimpleDateFormat("HH:mm:ss")
        
        println(sFormat.format(now))
    }
    ```
  - 문자열 비교
    - String 클래스의 equals() 메소드 사용
    ```kotlin
    var str : String = "안녕하세요"
    if (str.equals("안녕하세요")) {
        // 문자열이 같다면 이곳을 수행
    }
    ```
  - let()
    - 블록에 자기 자신을 전달하고 수행된 결과를 반환하는 함수
    ```kotlin
    // fun <T, R> T.let(block: (T) -> R): R
    val result = str?.let {
        Integer.parseInt(it)  // parseInt: str을 int로 변환
    }
    ```
  - with()
    - parameter로 객체를 받고, 블록에서 수행된 결과를 반환하는 함수
    ```kotlin
    // fun <T, R> with(receiver: T, block T.() -> R): R
    with(str) {
        println(toUpperCase())
    }
    ```
  - apply()
    - 블록에 자기 자신을 전달하고 이 객체를 반환하는 함수
    ```kotlin
    // fun <T> T.apply(block: T.() -> Unit): T
    val result = car?.apply{
        car.setColor(Color.RED)
        car.setPrice(1000)
    }
    ```
  - run()
    - 익명함수처럼 사용하거나 블록에 자기 자신을 전달하고 수행된 결과를 반환하는 함수
    - 객체에서 호출하는 방법은 객체를 블록의 리시버 객체로 전달하고 블록의 결과를 반환함
    - 안전한 호출을 할 수 있다는 장점으로 with() 함수보다 유용함
    ```kotlin
    // fun <R> run(block: () -> R): R
    val avg = run {
        val korean = 100
        val english = 80
        val math = 50
        
        (korean + english + math) / 3.0
    }
    ```
  - 리스트
    - 배열 같은 자료형의 데이터들을 순서대로 가지고 있는 자료구조
    - 중복된 아이템을 가질 수 있고 추가, 삭제, 교체 등이 쉬움
    ```kotlin
    val foods: List<String> = listOf("라면", "갈비", "밥")
    // 요소를 변경할 수 없는 읽기 전용 리스트는 listOf() 메서드로 작성
    val foods = listOf("라면", "갈비", "밥")
    
    //요소를 변경하는 리스트를 작성할 때는 mutableListOf() 메서드 이용
    val foods = mutableListOf("라면", "갈비", "밥")
    foods.add("초밥")
    foods.removeAt(0)  // 0번째 인덱스 아이템 삭제
    foods[1] = "부대찌개"  // 인덱스 1번의 아이템을 부대찌개로 변경
    ```
  - map()
    - key와 value의 쌍으로 이루어져 있으며, key가 중복될 수 없는 자료구조
    ```kotlin
    // 읽기 전용 map
    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
    
    // 변경 가능 map
    val citiesMap = mutableMapOf("Korea" to "Seoul",
                                "Japan" to "Tokyo",
                                "China" to "Beijing")
    // 요소 추가
    citiesMap["USA"] = "Washington"
    
    // map의 key와 value 탐색
    for ((k, v) in map) {
        println("$k -> $v")
    }
    ```
  - set
    - set은 중복되지 않는 요소들로 구성된 자료구조
    - setOf() 메서드로 읽기 전용집합을 만들고, mutableSetOf()메서드로 수정 가능한 집합을 만듬
    ```kotlin
    // 읽기 전용 집합
    val citySet = setOf("서울", "수원", "부산")
    
    // 수정 가능한 집합
    val citySet2 = mutableSetOf("서울", "수원", "부산")
    citySet2.add("안양")
    citySet2.remove("수원")
    
    // 집합의 크기
    println(citySet2.size)
    
    // "서울"이 집합에 포함되어 있는지
    println(citySet2.contains("서울"))
    ```