package com.example.abdallahsarayrah.bankinapph

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        buttonLogin.setOnClickListener {
            var bankingDBObject = BankingDB(this)
            var bankingDBWrite = bankingDBObject.writableDatabase
            bankingDBWrite.execSQL("insert into users(user_phone, user_password, user_name) values(?, ?, ?)", arrayOf(editTextMobile.text.toString(), editTextPassword.text.toString(), editTextName.text.toString()))

            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
