package com.example.studentmanagement

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup

class PersonnelReg : AppCompatActivity() {

    lateinit var dbManager: DBManager
    lateinit var sqlitedb : SQLiteDatabase

    lateinit var registerButton : Button
    lateinit var nameEditText : EditText
    lateinit var ageEditText: EditText
    lateinit var telEditText: EditText

    lateinit var gender : RadioGroup
    lateinit var female : RadioButton
    lateinit var male : RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personnel_reg)

        registerButton = findViewById(R.id.registerButton)
        nameEditText = findViewById(R.id.nameEditText)
        ageEditText = findViewById(R.id.ageEditText)
        telEditText = findViewById(R.id.telEditText)

        gender = findViewById(R.id.gender)
        female = findViewById(R.id.female)
        male = findViewById(R.id.male)

        dbManager = DBManager(this, "personnelDB", null, 1)

        registerButton.setOnClickListener {
            var str_name : String = nameEditText.text.toString()
            var str_age : String = ageEditText.text.toString()
            var str_tel : String = telEditText.text.toString()

            var str_gender : String = ""
            if (gender.checkedRadioButtonId == R.id.female) {
                str_gender = female.text.toString()
            }

            if (gender.checkedRadioButtonId == R.id.male) {
                str_gender = male.text.toString()
            }

            sqlitedb = dbManager.writableDatabase
            sqlitedb.execSQL("INSERT INTO personnel VALUES ('" +str_name+"', '"+ str_gender +"', " +str_age+", '" +str_tel+"')")
            sqlitedb.close()

            val intent = Intent(this, Personnelinfo::class.java)
            intent.putExtra("intent_name", str_name)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_personnel_reg, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId) {
            R.id.action_home -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_list -> {
                val intent = Intent(this, PersonnelList::class.java)
                startActivity(intent)
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

}