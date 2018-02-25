package com.example.abdallahsarayrah.bankinapph

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonLogin.setOnClickListener {
            var bankingDBObject = BankingDB(this)
            var bankingDB = bankingDBObject.readableDatabase
            var cursorBankingDB = bankingDB.rawQuery("select * from users where user_phone = ? and user_password = ?", arrayOf(editTextMobile.text.toString(), editTextPassword.text.toString()))
            cursorBankingDB.moveToFirst()
            when {
                cursorBankingDB.count > 0 -> {
                    var intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("user_id", cursorBankingDB.getString(cursorBankingDB.getColumnIndex("user_id")))
                    startActivity(intent)
                    finish()
                }
                cursorBankingDB.count > 0 -> Toast.makeText(this, "Either phone number or password is wrong, please try again!!", Toast.LENGTH_SHORT).show()

            }
        }


        textViewRegister.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}
