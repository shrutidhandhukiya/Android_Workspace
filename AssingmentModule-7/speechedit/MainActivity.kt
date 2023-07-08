package com.example.speechprogram

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.speechprogram.databinding.ActivityMainBinding
import org.w3c.dom.Text
import java.util.*


class MainActivity : AppCompatActivity() {
    var textToSpeech:TextToSpeech? = null
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        textToSpeech = TextToSpeech(applicationContext) { i ->
            // if No error is found then only it will run
            if (i != TextToSpeech.ERROR) {
                // To Choose language of speech
                textToSpeech!!.setLanguage(Locale.UK)
            }
        }

        binding.btnText.setOnClickListener {
            val toSpeak: String = binding.Text.getText().toString()

            Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
            textToSpeech!!.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
        }
        }

    }
