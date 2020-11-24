package com.example.broadcastbestpractice

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val prefs = getPreferences(Context.MODE_PRIVATE)
        val isRemember = prefs.getBoolean("记住密码",false)
        if (isRemember){
            //将账号和密码都设置到文本框中
            val id = prefs.getString("id","")
            val pwd = prefs.getString("pwd","")
            UserID.setText(id)
            UserPwd.setText(pwd)
            rememberPass.isChecked = true
        }
        LoginButton.setOnClickListener {
            val id  = UserID.text.trim().toString()
            val pwd = UserPwd.text.trim().toString()
            if (id == "1750397846" && pwd == "123456")
            {
                val editor=prefs.edit()
                if (rememberPass.isChecked){//检查复选框是否被选中
                    editor.putBoolean("记住密码",true)
                    editor.putString("id",id)
                    editor.putString("pwd",pwd)
                }else{
                    editor.clear()
                }
                editor.apply()
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,"QQ号码或者密码错误，请重试",Toast.LENGTH_SHORT).show()
            }
        }
    }
}