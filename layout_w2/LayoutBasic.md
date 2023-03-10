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
        - sp(Scale-Independent Pixels): 안드로이드os에서 텍스트 크기를 조절하는 경우 앱에서도 적용되도록 함'
  - background 속성
    - view의 배경, widget의 색상을 지정
    - #RRGGBB 값으로 지정, 16진수로 표현
  - margin 속성
    - 뷰와 부모 뷰 사이의 공간을 의미함
    - 해당 여백은 뷰 자신의 영역에 포함되지 않음
  - padding 속성
    - 뷰와 뷰의 내용물 사이의 공간
    - 해당 여백은 뷰 자신의 영역에 포함됨
  - visibility 속성
    - widget을 보일 것인가?
    - visible: default 값, 보이는 상태
    - invisible: 보이지 않지만 위치해있음
    - gone: 보이지 않으며 위치도 존재하지 않음
  - enabled, clickable 속성
    - XML보다 Kotlin 코드에서 주로 사용됨
    - enabled: 위젯의 동작 여부, true or false
    - clickable: 클릭이나 터치 동작 여부, true or false
- 배치를 담당하는 Layout
  - 레이아웃 안에 존재하는 위젯을 배치하게 해줌
  - 프로젝트를 처음 생성하면 화면을 구성하는 activity_main이라는 xml파일이 자동으로 만들어짐
  - 레이아웃 파일은 소스코드가 아닌 리소스로 분류
  - 파일명은 모두 소문자
  - 파일 이름 끝에는 .xml
- Layout 종류
  - LinearLayout
    - 위젯을 가로 또는 세로 한줄로 배치하기 위한 레이아웃
    - orientation의 horizontal, vertical 중 하나로 설정해주면 기존에 배치되어있던 위젯들도 방향을 바꿀 수 있음
    - androidx.constraintlayout.widget.ConstraintLayout을 LinearLayout으로 변경하여 사용
    - 한 화면에서 위젯을 수평, 수직 모두 이용해 매치하는 경우
      - 바깥의 큰 LinearLayout 안에 작은 LinearLayout을 여러개 넣어서 사용해야 함
    - 주요 속성
      - orientation: 레이아웃 안에 배치할 위젯을 수직으로 할지, 수평으로 할지 설정함
        - 옵션: vertical, horizontal
      - gravity: 레이아웃 안에 배치할 위젯의 정렬 방향을 좌, 우, 중앙 등으로 설정 -> 레이아웃에 속성이 적용됨
        - 옵션: left, right, bottom, top, center, center_horizontal, center_vertical
        - 2개씩 조합도 가능함
        - defalt: left | top
      - layout_gravity: 자신의 위치를 부모의 어디에 위치시킬지 결정 -> 위젯에 속성이 적용됨
        - 옵션: gravity와 동일
      - margin: 뷰와 부모 뷰 사이의 공간
        - layout_margin: 4면 모두 동일한 여백 지정
        - 옵션: layout_marginLeft, layout_marginRight, layout_marginTop, layout_marginBottom -> 4면의 개별 여백 지정 가능 
      - padding: 레이아웃 안에 배치할 위젯의 여백 설정
        - 뷰와 뷰의 내용물 사이의 공간
        - padding: 4면 모두 동일한 여백 지정
        - 옵션: paddingLeft, paddingTop, paddingRight, paddingBottom -> 4면의 개별 여백으로 지정 가능
      - layout_weight: 레이아웃이 전체 화면에서 차지하는 공간의 가중값을 설정, 여러개의 레이아웃이 중복될 때 주로 사용함
        - 중복 linear layout에서 사용됨
        - linear layout을 사용하는 경우 각 layout의 크기를 지정해야 함
        - layout을 화면 전체에 채워줘야 하기 때문에 주로 전체 화면에 대한 비율로 지정함
        - 비율에 따라 부모 레이아웃의 남은 영역을 차지하는 비율이 결정됨
      - baselineAligned: 레이아웃 안에 배치할 위젯을 보기 좋게 정렬
        - 옵션: true, false
        - default: true
  - RelativeLayout
    - 위젯과 부모와의 위치관계 또는 위젯끼리의 관계를 지정함으로써 뷰를 배치함
    - 부모 뷰를 기준으로 위치 지정
    - 속성: layout_alignParentLeft, layout_centerHorizontal, layout_alignParentRight, layout_alignParentTop, layout_centerVertical, layout_alignParentBottom, layout_centerlnParent
    - relative layout 안에서 다른 위젯의 특정한 곳에 배치하는 방법도 존재함
      - 해당 방식을 이용하기 위해서는 다른 위젯의 id를 지정해야 함
      - 속성: toLeftOf-alignTop/alignBaseline/alignBottom, above-alignLeft/alignLeft, toRightOf-alignTop/alignBaseline/alignBottom, below-alignLeft/alignRight
  - TableLayout
    - 위젯을 표 형태로 배치할 때 주로 사용
    - TableRow 속성과 함께 사용함
    - 행의 수는 TableRow의 수, 열의 수는 TableRow 안에 포함된 위젯의 수
    - 속성
      - layout_span: 테이블 레이아웃 안에 포함된 위젯에 설정하는 속성으로 열을 합쳐서 표시하라는 의미
      - layout_column: 테이블 레이아웃 안에 포함된 위젯에 설정하는 속성으로 지정된 열에 현재 위젯 표시
      - stretchColumns: TableLayout 자체에 설정하는 속성으로 지정된 열의 너비를 늘리라는 의미, stretchColumns="*"는 각 셀을 모두 같은 크기로 확장하여 전체 화면이 꽉 차도록 함, 열 번호는 0번부터 시작함 
  - GridLayout
    - 격자 내부의 셀에 자식뷰를 배치하는 뷰 그룹
    - 테이블 레이아웃과 비슷하지만 각각의 자식 뷰가 자신의 위치와 차지하는 셀의 개수를 독립적으로 지정할 수 있음
    - GridLayout 관련 속성: rowCount-행의 수, columnCount-열의 수, orientation-그리드를 수평과 수직 중 어느 것을 우선으로 할지 설정함
    - GridLayout의 위젯에 설정하는 속성
      - layout_row: 자신이 위치할 행 번호(0부터 시작)
      - layout_column: 자신이 위치할 열 번호(0부터 시작)
      - layout_rowSpan: 행을 지정된 수만큼 확장
      - layout_columnSpan: 열을 지정된 수만큼 확장
      - layout_gravity: 주로 fill, fill_vertical, fill_horizontal 등으로 지정 -> layout_rowSpan이나 layout_columnSpan으로 행 또는 열을 확장했을 때 위젯을 확장된 셀에 꽉 채움
  - FrameLayout
    - 레이아웃 안의 위젯을 왼쪽 상단부터 겹쳐서 출력함
    - 속성: foreground-프레임레이아웃의 전경 이미지를 지정함, foregroundGravity-전경 이미지의 위치를 지정, fill, right, left, top, bottom 등의 값을 이용
  - ConstraintLayout
    - 안드로이드 기본 레이아웃
    - 화면에 배치되는 위젯들 사이에 간단한 제약 조건을 설정하여 화면 구성
    - 주어진 위젯을 다른 위젯과 비교해 상대적으로 위치를 지정하고 배치함
    - chaining: constraint로 연결된 위젯끼리 서로의 위치값을 공유하여 상대적인 값으로 크기와 위치를 결정하도록 함
- Activity
  - 화면을 구성하는 가장 기본적인 컴포넌트
  - 앱을 실행 시 보여지는 화면을 구성할 수 있도록 해주는 안드로이드 구성요소
  - 앱은 한개 혹은 여러개의 액티비티로 구성됨
  - Activity class는 안드로이드의 Activity를 상속한 클래스로 다양한 액티비티 클래스가 존재하나 하위 호환성을 위헤 AppCompatActivity를 사용함