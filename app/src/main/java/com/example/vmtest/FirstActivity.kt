package com.example.vmtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels

class FirstActivity : AppCompatActivity() {

    private val vm: FirstActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        Log.d(LOG_TAG, "FA create")

        val text = findViewById<TextView>(R.id.tv_activity)
        val field = findViewById<EditText>(R.id.et_activity)
        val button = findViewById<Button>(R.id.btn_activity)
        val replaceBtn = findViewById<Button>(R.id.btn_activity_2)

        button.setOnClickListener {
            vm.setText(field.text.toString())
        }

        replaceBtn.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .addToBackStack("")
                .replace(R.id.container, SecondFragment())
                .commit()
        }

        vm.text.observe(this, {
            text.text = it
        })

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, FirstFragment())
            .commit()
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "FA stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "FA destroy")
    }

    companion object {
        const val LOG_TAG = "logging_this"
    }
}