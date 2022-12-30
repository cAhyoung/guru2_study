# View
- View
  - View 클래스의 서브클래스로 만든 객체
  - 액티비피 화면은 한개 이상의 뷰로 구성
  - 크게 두 종류로 나눔
    - 레이아웃
      - 다른 위젯을 담아 배치하는 틀
      - 여러개의 뷰를 규칙대로 화면에 배치
      - ViewGroup의 서브클래스
    - 위젯
      - 버튼, 라디오버튼, 이미지 등 화면에서 사용되는 것
      - View 또는 ViewGroup의 서브클래스로서 단독으로 사용
- View 클래스의 XML 속성
  - id 속성
    - 모든 위젯의 아이디를 나타냄
    - 터치했을 때 어떤 동작이 필요한 경우 아이디 부여
    - 일반적으로 id속성은 위젯에 아이디를 새로 부여하는 개념
    - @+id/
    - / 다음에는 새로 지정할 id를 넣음
    - android:id="@+id/button1" -> 버튼 위젯의 아이디로 button1을 부여
    - kotlin 코드에서 버튼 등의 위젯에 접근할 때 id 속성에 지정한 아이디 사용
    ```kotlin
    import java.awt.Button
    widgetVar = findViewById<widgetType>(R.id.widgetId)
    // 예시
    var button1 : Button
    button1 = fidnViewById<Button>(R.id.button1)
    ```
  - layout_width, layout_height 속성
    - 모든 위젯에 필수적으로 들어가는 속성
    - layout_width
      - 버튼의 너비
    - layout_height
      - 버튼의 높이
    - 속성값으로는 아래의 세가지 중 하나의 값으로 설정할 수 있음
      - wrap_content
        - 버튼의 너비나 높이가 그 안의 글자와 꼭 맞는 크기가 됨
      - match_parent
        - 버튼의 글자와 관계없이 버튼을 싸고있는 부모(레이아웃)에 꽉 차는 크기가 됨
      - 값을 숫자로 지정하는 경우
        - dp(Density-Independent Pixels): 어떤 기종을 사용하든 위젯 배치가 비슷하게 되도록 함
        - sp(Scale-Independent Pixels): 안드로이드os에서 텍스트 크기를 조절하는 경우 앱에서도 적용되도록 함