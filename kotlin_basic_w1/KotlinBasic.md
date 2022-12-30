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