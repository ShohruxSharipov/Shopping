package com.example.shopping

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import coil.load

class item_activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    val handler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        var home = findViewById<ImageView>(R.id.home)
        var card = findViewById<CardView>(R.id.card)
        card.animation = AnimationUtils.loadAnimation(this,R.anim.anim)
        home.setOnClickListener {
            val anim = AnimationUtils.loadAnimation(this,R.anim.anim3)
            home.animation = anim
            home.visibility = View.INVISIBLE
            card.animation = anim
            card.visibility = View.INVISIBLE
            handler.postDelayed({
                onBackPressedDispatcher.onBackPressed()
//                val intent = Intent(this,MainActivity2::class.java)
//                startActivity(intent)
                finish()
            },400)
        }


        }
    }
