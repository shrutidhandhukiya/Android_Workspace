package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var map = hashMapOf<String, Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        map.put("Image", R.drawable.img)
        map.put("Image", R.drawable.teddy)
        map.put("Image", R.drawable.img)

        for (name in map.keys) {
            var textslider = TextSliderView(this)

            textslider
                .description(name)
                .image(map.get(name)!!)
                .setScaleType(BaseSliderView.ScaleType.Fit)


            binding.slider.setPresetTransformer(SliderLayout.Transformer.Accordion)
            binding.slider.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom)
            binding.slider.setDuration(2000)

            binding.slider.addSlider(textslider)
        }

    }

    
}