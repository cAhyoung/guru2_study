package group_pra.java.com.example.group_pra

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var nameEditText: EditText
    lateinit var numberEditText: EditText
    lateinit var nameResultEditText: EditText
    lateinit var numberResultEditText: EditText

    lateinit var initButton: Button
    lateinit var insertButton: Button
    lateinit var selectButton: Button
    lateinit var updateButton: Button
    lateinit var deleteButton: Button

    lateinit var myHelper: myDBHelper
    lateinit var sqlDB: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.nameEditText)
        numberEditText = findViewById(R.id.numberEditText)
        nameResultEditText = findViewById(R.id.nameResultEditText)
        numberResultEditText = findViewById(R.id.numberResultEditText)

        initButton = findViewById(R.id.initButton)
        insertButton = findViewById(R.id.insertButton)
        selectButton = findViewById(R.id.selectButton)
        updateButton = findViewById(R.id.updateButton)
        deleteButton = findViewById(R.id.deleteButton)

        myHelper = myDBHelper(this)

        initButton.setOnClickListener {
            sqlDB = myHelper.writableDatabase
            myHelper.onUpgrade(sqlDB, 1, 2)
            sqlDB.close()

            selectButton.callOnClick()
        }

        insertButton.setOnClickListener {
            sqlDB = myHelper.writableDatabase
            sqlDB.execSQL("INSERT INTO groupTBL VALUES ('"+nameEditText.text.toString()+" ', "+numberEditText.text.toString() + ");")
            sqlDB.close()
            
            Toast.makeText(applicationContext, "입력됨", Toast.LENGTH_SHORT).show()

            selectButton.callOnClick()
        }

        selectButton.setOnClickListener {
            sqlDB = myHelper.readableDatabase

            var cursor: Cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null)

            var strNames = "그룹 이름" + "\r\n" + "-------------" + "\r\n"
            var strNumber = "인원" + "\r\n" + "---------" + "\r\n"

            while (cursor.moveToNext()) {
                strNames += cursor.getString(0) + "\r\n"
                strNumber += cursor.getString(1) + "\r\n"

            }
            nameResultEditText.setText(strNames)
            numberResultEditText.setText(strNumber)

            cursor.close()
            sqlDB.close()

        }

        updateButton.setOnClickListener {
            sqlDB = myHelper.writableDatabase
            sqlDB.execSQL("UPDATE groupTBL SET gNumber =" + numberEditText.text + " WHERE gName = '" + nameEditText.text.toString() + "';")

            sqlDB.close()

            Toast.makeText(applicationContext, "수정됨", Toast.LENGTH_SHORT).show()

            selectButton.callOnClick()
        }

        deleteButton.setOnClickListener {
            sqlDB = myHelper.writableDatabase
            sqlDB.execSQL("DELETE FROM groupTBL WHERE gNAME = '" + nameEditText.text.toString()+"';")

            sqlDB.close()

            Toast.makeText(applicationContext, "삭제됨", Toast.LENGTH_SHORT).show()

            selectButton.callOnClick()
         }
    }

    inner class myDBHelper(context: Context): SQLiteOpenHelper(context, "groupDB", null, 1) {
        override fun onCreate(db: SQLiteDatabase?) {
            db!!.execSQL("CREATE TABLE groupTBL (gName CHAR(20), gNumber Integer);")
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db!!.execSQL("DROP TABLE IF EXISTS groupTBL")
            onCreate(db)
        }
    }
}