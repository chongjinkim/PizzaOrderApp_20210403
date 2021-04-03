package com.nepplus.pizzaorderapp_20210403

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(){

    val mContext = this

    abstract fun setupEvents()
    abstract fun setValues()


}