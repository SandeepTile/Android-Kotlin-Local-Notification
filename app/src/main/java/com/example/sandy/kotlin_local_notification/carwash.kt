package com.example.sandy.kotlin_local_notification

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_carwash.*

class carwash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carwash)


        ok.setOnClickListener({

            val intent = Intent(this@carwash,MainActivity::class.java)
            startActivity(intent)

        })
    }
}
