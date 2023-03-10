package com.example.shopping

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import java.util.*

class Splash : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val handler = Handler(Looper.getMainLooper())
        var olcha = findViewById<ImageView>(R.id.olcha)
        supportActionBar?.hide()

        val anim = AnimationUtils.loadAnimation(this,R.anim.anim2)
        olcha.animation = anim


        handler.postDelayed({
            var cache = getSharedPreferences("Cache", MODE_PRIVATE)
            var str = cache.getString("language","")
            if (str != ""){
                var locale = Locale(str)
                Locale.setDefault(locale)
                val config = Configuration()
                config.locale = locale
                baseContext.resources.updateConfiguration(
                    config,
                    baseContext.resources.displayMetrics)
                var intent = Intent(this,Code::class.java)
                startActivity(intent)
            }else{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
                }
            finish()
        },3000)
    }
}