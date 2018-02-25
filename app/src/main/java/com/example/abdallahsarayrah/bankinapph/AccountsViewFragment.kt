package com.example.abdallahsarayrah.bankinapph

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [AccountsViewFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [AccountsViewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AccountsViewFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null

    private var mListener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
            mParam2 = arguments.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view: View = inflater!!.inflate(R.layout.fragment_accounts_view, container, false)

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

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction(uri)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AccountsViewFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): AccountsViewFragment {
            val fragment = AccountsViewFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
