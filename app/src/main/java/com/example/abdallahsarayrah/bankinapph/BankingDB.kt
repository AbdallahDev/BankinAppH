package com.example.abdallahsarayrah.bankinapph

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by abdallah.sarayrah on 10/16/2017.
 */
class BankingDB(context: Context) : SQLiteOpenHelper(context, "Banking.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table users(user_id integer primary key autoincrement, user_phone text UNIQUE not null, user_password text not null, user_name text not null)")
        db?.execSQL("create table accounts(account_id integer primary key autoincrement, account_number integer UNIQUE not null, account_balance Decimal(19,4), account_user_id integer not null)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

}
