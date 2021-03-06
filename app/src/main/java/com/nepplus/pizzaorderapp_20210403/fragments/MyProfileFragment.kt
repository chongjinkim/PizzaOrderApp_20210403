package com.nepplus.pizzaorderapp_20210403.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nepplus.pizzaorderapp_20210403.EditNicknameActivity
import com.nepplus.pizzaorderapp_20210403.R
import kotlinx.android.synthetic.main.fragment_my_profile_list.*

class MyProfileFragment : Fragment() {

    val REQUEST_FOR_NICKNAME = 1001

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_profile_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        editnicknameBtn.setOnClickListener {

            val myIntent = Intent(activity, EditNicknameActivity::class.java)

            startActivityForResult(myIntent, REQUEST_FOR_NICKNAME)
        }



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(requestCode == REQUEST_FOR_NICKNAME){

            if(resultCode == Activity.RESULT_OK){

                val newNickname = data?.getStringExtra("nick")

                nicknameTxt.text = newNickname
            }
        }
    }


}