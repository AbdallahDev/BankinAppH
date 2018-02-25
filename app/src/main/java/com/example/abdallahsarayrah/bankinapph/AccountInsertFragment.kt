package com.example.abdallahsarayrah.bankinapph


import android.app.Activity
import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


/**
 * A simple [Fragment] subclass.
 */
class AccountInsertFragment : Fragment() {

    var accountObject: Account? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view: View = inflater!!.inflate(R.layout.fragment_account_insert, container, false)

        var editTextAccountNumber = view.findViewById<EditText>(R.id.editTextAccountNumber)
        var editTextAccountBalance = view.findViewById<EditText>(R.id.editTextAccountBalance)
        var buttonCreateAccount = view.findViewById<Button>(R.id.buttonCreateAccount)

        buttonCreateAccount.setOnClickListener {
            accountObject?.createAccount(editTextAccountNumber.text.toString(), editTextAccountBalance.text.toString())
        }

        return view
    }

    interface Account {
        fun createAccount(accountNumber: String, accountBalance: String)
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)

        accountObject = activity as Account
    }

}// Required empty public constructor
