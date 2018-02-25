package com.example.abdallahsarayrah.bankinapph

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity(), AccountInsertFragment.Account, AccountsViewFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private var bankingDBObject = BankingDB(this)

    override fun createAccount(accountNumber: String, accountBalance: String) {
        var user_id = intent.getStringExtra("user_id")
        var bankingDBWritable = bankingDBObject.writableDatabase
        bankingDBWritable.execSQL("insert into accounts(account_number, account_balance, account_user_id) values(?, ?, ?)", arrayOf(accountNumber, accountBalance, user_id))
        Toast.makeText(this, "Account number $accountNumber create successfully", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.itemLogOut -> {
                var intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            R.id.itemAccounts -> {
                var transaction = fragmentManager.beginTransaction()
                var transactionObject = AccountsFragment()
                transaction.replace(R.id.fragmentContainer, transactionObject)
                transaction.commit()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
