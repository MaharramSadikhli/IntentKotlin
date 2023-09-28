package com.imsoft.intentkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.imsoft.intentkotlin.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intentFromMain = intent
        val name = intentFromMain.getStringExtra("name")

        object : CountDownTimer(5000, 1000) {
            override fun onTick(p0: Long) {
                binding.textView3.text = "Wait: ${p0 / 1000}"
            }

            override fun onFinish() {
                binding.textView3.text = "Name: ${name}"
            }

        }
            .start()
    }

    fun prevPage(view: View) {
        val intent = Intent(this@NextActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}