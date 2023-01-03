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
- 