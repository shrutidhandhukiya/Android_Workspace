package com.example.assingmentapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.assingmentapplication.databinding.ActivityReversnumberBinding

class ReversNumber : AppCompatActivity() {

    private lateinit var binding: ActivityReversnumberBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReversnumberBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.edText.setOnClickListener {

            if (binding.edText.text.toString().isNotEmpty()) {
                val c: StringBuilder = StringBuilder(binding.edText.text.toString())
                binding.tvext.setText(c.reverse())
                Toast.makeText(this, "Inserted", Toast.LENGTH_LONG).show()
            }
            else {
                binding.tvext.setError("Enter NAME")
            }

        }
    }
}

