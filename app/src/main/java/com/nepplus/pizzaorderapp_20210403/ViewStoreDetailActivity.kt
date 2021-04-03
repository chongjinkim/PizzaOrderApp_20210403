package com.nepplus.pizzaorderapp_20210403

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import com.nepplus.pizzaorderapp_20210403.datas.Store
import kotlinx.android.synthetic.main.activity_view_store_detail.*
import java.security.Permission

class ViewStoreDetailActivity : BaseActivity() {

    lateinit var mStore: Store

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_store_detail)
    }

    override fun setupEvents() {

        val p1 = object : PermissionListener{
            override fun onPermissionGranted() {
               val myUri = Uri.parse("tel:${mStore.phoneNum}")
               val myIntent = Intent(Intent.ACTION_CALL, myUri)
               startActivity(myIntent)
            }

            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                Toast.makeText(mContext, "전화 연결 불가", Toast.LENGTH_SHORT).show()
            }

        }

//        여기 수정해야함
       TedPermission.with(mContext){

       }
    }

    override fun setValues() {

//        링크 안나옴 - 수정
        mStore = intent.getSerializableExtra("store") as Store

        Glide.with(mContext).load(mStore.logoURL).into(logoImg)
        storeNameTxt.text = mStore.name
        phoneNumTxt.text = mStore.phoneNum



    }


}