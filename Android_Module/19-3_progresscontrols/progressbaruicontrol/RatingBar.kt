package com.example.progressbaruicontrol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.Toast
import com.example.progressbaruicontrol.databinding.ActivityMainBinding
import com.example.progressbaruicontrol.databinding.ActivityRatingBarBinding

class RatingBar : AppCompatActivity(), RatingBar.OnRatingBarChangeListener {

    private lateinit var bindings:ActivityRatingBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = ActivityRatingBarBinding.inflate(layoutInflater)
        val view = bindings.root
        setContentView(view)

    bindings.rate.setOnRatingBarChangeListener(this)
    }

    override fun onRatingChanged(ratingbar: RatingBar?, rating: Float, p2: Boolean) {

        Toast.makeText(applicationContext,""+ ratingbar!!.rating,Toast.LENGTH_LONG).show()
    }

}



