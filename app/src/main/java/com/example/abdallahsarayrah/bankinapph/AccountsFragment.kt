package com.example.abdallahsarayrah.bankinapph


import android.os.Bundle
import android.app.Fragment
import android.view.*
import android.widget.ListView
import android.widget.ArrayAdapter


/**
 * A simple [Fragment] subclass.
 */
class AccountsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view: View = inflater!!.inflate(R.layout.fragment_accounts, container, false)

        var accountsArrayList = ArrayList<String>()

        var bankingDBObject = BankingDB(activity)
        var bankingDB = bankingDBObject.readableDatabase
        var bankingDBCursor = bankingDB.rawQuery("select * from accounts", arrayOf())
        bankingDBCursor.moveToFirst()
        while (bankingDBCursor.moveToNext()) {
            accountsArrayList.add(bankingDBCursor.getString(bankingDBCursor.getColumnIndex("account_number")))
        }


        var accountsAdapter = ArrayAdapter<String>(activity, R.layout.activity_main, accountsArrayList)

        var listViewAccounts = view.findViewById<ListView>(R.id.listViewAccounts)
//        listViewAccounts.adapter = accountsAdapter

        //Inflate the layout for this fragment
        return view
    }

}// Required empty public constructor
