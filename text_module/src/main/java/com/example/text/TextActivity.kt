package com.example.text

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.di.Injector
import javax.inject.Inject

class TextActivity : AppCompatActivity(R.layout.text_activity) {

    companion object {

        fun intent(context: Context) : Intent {
            return Intent(context, TextActivity::class.java)
        }
    }

    @Inject
    lateinit var text: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Injector.get(TextComponent::class.java).inject(this)
        findViewById<TextView>(R.id.text).text = text
    }
}