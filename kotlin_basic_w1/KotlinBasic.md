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