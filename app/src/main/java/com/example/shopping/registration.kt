package com.example.shopping

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.shopping.databinding.ActivityRegistrationBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class registration : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    var list = mutableListOf<user>()
    lateinit var login:String
    lateinit var password:String
    lateinit var number:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)



        var type = object : TypeToken<List<user>>() {}.type
        var gson = Gson()

        var cache = getSharedPreferences("Cache", MODE_PRIVATE)
        var edit = cache.edit()



        binding.next.setOnClickListener {
            login = binding.emails.text.toString()
            password = binding.password.text.toString()
            number = binding.numbers.text.toString()
            if (login!!.isEmpty() || password!!.isEmpty() || number!!.isEmpty()) {
                Log.d("TAG", "login : "+login)
                Log.d("TAG", "pasword : "+password)
                Log.d("TAG", "number : "+number)
                Toast.makeText(this, "Fill all", Toast.LENGTH_SHORT).show()
            } else {
                var str = cache.getString("Users","")
                if (str == ""){
                    list = mutableListOf()
                }else{
                    list = gson.fromJson(str,type)
                }
                list.add(user(login,password))
                var s = gson.toJson(list)
                edit.putString("Users",s).commit()
                var intent = Intent(this, Code::class.java)
                startActivity(intent)
            }
        }
    }
}