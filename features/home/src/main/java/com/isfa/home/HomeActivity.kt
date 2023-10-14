package com.isfa.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.isfa.utils.greeting

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val name = "Isfa"

        Toast.makeText(
            this,
            name.greeting(),
            Toast.LENGTH_LONG
        ).show()
    }
}