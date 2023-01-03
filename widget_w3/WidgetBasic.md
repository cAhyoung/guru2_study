# XML
- element
  - root element는 하나 이상의 child element를 가짐
  - 각 child element도 하나 이상의 subchild element를 가질 수 있음
  - 데이터가 없는 element는 empty element라고 함
  - element는 여러개의 속성을 지정할 수 있으며 각 속성은 속성명과 속성 값으로 표현
  ```xml
  <element 속성명="속성값">
  ```
  - 주석은 \<!-- 내용-->

# Widget
- 텍스트 뷰
  - view 클래스 바로 다음에 위치하고 다양한 위젯이 그 하위에 존재함
  - text 속성
    - 텍스트 뷰에 나타나는 문자열
    - "문자열" 형식으로 값을 직접 입력하거나 "@string/변수명" 형식으로 지정한 후 strings.xml 파일에 지정할 수 있음
  - textColor 속성
    - 글자의 색을 지정
    - background 속성처럼 값은 #RRGGBB나 #AARRGGBB 형식을 사용함
  - textSize 속성
    - 글자 크기를 dp, px, in, mm, sp 단위로 지정
    - 텍스트가 입력되는 위젯은 주로 sp를 사용, sp는 Scale-independent Pixels의 약자로 문자열 크기를 나타내기 위해 사용하는 단위임
  - typeface 속성
    - 글자의 글꼴 지정
    - 값으로 sans, serif, monospace를 설정할 수 있고 default는 normal
  - textStyle 속성
    - 글자의 스타일 지정
    - bold, italic, bold|italic을 설정할 수 있고 default는 normal
  - singleLine 속성
    - 글이 너무 길어 줄이 넘어가는 경우에는 강제로 한줄까지만 출력하고 문자열의 맨 뒤에 ...을 표시
    - true/false -> default는 false
  - maxLines 속성
    - 텍스트 뷰에 최대 입력 가능한 줄 수 설정
  - minLines 속성
    - 텍스트 뷰에 최소 줄 수를 미리 설정
  - ellipsize 속성
    - 텍스트 뷰의 maxLines 속성이 1이거나 문자열이 길어서 글자가 잘릴 때 설정
  - lines 속성
    - 텍스트 뷰 높이 고정
  - maxLength
    - 텍스트 전체 길이 제한
    - 설정한 값만큼의 글자만 보이고 나머지는 보이지 않게 함
- EditText
  - 값을 입력받은 후 해당 값을 Kotlin 코드에서 가져와 사용하는 용도로 많이 쓰임
  ```xml
  <EditText
      android:id="@+id/edittext1">
  ```
  - 속성
    - hint
      - 클릭하면 사라지는 미리보기를 작성할 수 있음
    - inputType
      - 속성에 입력되는 옵션에 따라 키보드 모양이 바뀜
      - [number] : 숫자 형식
      - [numberPassword] : 숫자로만 구성된 비밀번호 이름
      - [phone] : 전화번호 형식
      - [date] : 날짜 형식
      - [textUri] : URI 형식의 문자 입력
      - [textEmailAdress] : email 주소 형식의 문자 입력
      - [textPassword] : 비밀번호 입력
      - [textVisiblePassword] : 비밀번호를 문자열 그대로 표시
  - 버튼을 클릭했을 때 동작 단계
    - 에디트 텍스트 변수를 선언하고 이 변수에 해당 id값을 넣은 후 접근
    - 에디트 텍스트 변수 선언 : var myEdit:EditText
    - 변수에 에디트 텍스트 위젯 대입 : myEdit = findViewById<EditText>(R.id.edittext)
    - 에디트 텍스트에 입력된 값 가져오기(버튼 클릭 이벤트 람다식 안에 넣음) : var myStr: String = myEdit.getText().toString()
    - 대부분의 위젯(라디오버튼, 이미지버튼, 체크박스, 토글버튼 등)에서 거의 동일하게 사용됨

- CompoundButton 클래스
  - Button 클래스의 하위 클래스로 체크박스, 라디오버튼, 스위치, 토글버튼의 상위 클래스임
  - CheckBox
    - 클릭할 때마다 상태가 체크/언체크로 바뀜
    - 여러개의 체크박스가 있어도 서로 독립적으로 동작하여 여러개를 동시에 체크할 수 있음
    - 체크와 언체크 시 코드 처리 절차
      - 체크박스 변수 선언 -> var mycheck : CheckBox
      - 변수에 체크박스 위젯 대입 -> mycheck = findViewById<CheckBox>(R.id.android)
      - 체크박스가 변경될 때 동작하는 람다식 정의 -> mycheck.setOnCheckedChangeListener{ compoundButton, b-> // 동작 내용 }
  - Switch, ToggleButton
    - 스위치와 토글 버튼은 모양만 조금 다를 뿐 용도는 거의 동일
    - 주 용도는 온오프 상태 표시
    - XML 속성이나 관련 메소드는 모두 체크박스와 동일하게 사용 가능
    - checked 속성은 true와 false에 따라 색상과 글자가 다르게 표현
  - RadioGroup, RadioButton
    - 라디오 그룹
      - ViewGroup-LinearLayout의 하위 클래스로 존재
      - TextView 하위의 위젯들과는 성격이 조금 다름
      - RadioGroup에서 가끔 사용되는 메소드인 clearCheck()
        - 해당 라디오 그룹 안에 체크된 것을 모두 해제함
    - 라디오버튼
      - XML 속성이나 메소드가 체크박스와 거의 동일하지만 용도가 다름
      - 여러개 중 하나만 선택해야 하는 경우 사용
      - 라디오버튼만 여러개 나열하면 클릭하는 것마다 모두 중복 선택되므로 라디오 그룹과 함께 사용
      - 각 라디오벅튼의 id 속성이 꼭 있어야 함 -> id 속성이 없으면 해당 라디오버튼이 계속 선택된 것으로 지정되어 해제되지 않음
- Toast 메세지
  - 화면 하단부에 잠시 보여주는 메세지
  - Toast.makeText(Context context, String message, int duration).show()

- ImageView
  - 그림을 출력하는 위젯
  - 그림을 넣거나 화면을 화려하게 구성할 때 사용
  - 이미지뷰에 보여줄 그림 파일은 일반적으로 프로젝트의 [res]-[drawable] 폴더에 있어야 함
  - 접근은 XML에서 "@drawable/그림아이디" 형식으로 함
  - ImageView, ImageButton 속성
    - src: 이미지 경로
    - maxHeight/maxWidth: 이미지 크기
    - scaleType: 이미지의 확대/축소 방식, matrix, fitXY, fitStart, fitEnd, center 등 지정한 값에 따라 이미지를 확대/축소하는 방식 결정
    - 사용하려는 이미지 파일은 png나 jpg를 권장함
    - [res]-[mipmap]
      - 같은 이름의 앱 아이콘 이미지가 디폴트로 들어가있음
      - 각각은 같은 이미지지만 해상도가 다름
      - XML 파일에서는 @mipmap/ic_launcher로 사용하고 kotlin코드에서는 R.mipmap.ic_launcher로 사용
      - ic_launcher를 화면에 출력하면 안드로이드 운영체제가 현재 안드로이드 폰의 해상도에 적절한 이미지를 알아서 선택
