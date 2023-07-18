package com.example.project.ui.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.example.project.Client.ApiClient
import com.example.project.Interface.ApInterface
import com.example.project.Model.HomeModel
import com.example.project.R
import com.example.project.adapter.HomeAdapter
import com.example.project.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    lateinit var apiinterface: ApInterface
    lateinit var  list: MutableList<HomeModel>

    var map = HashMap<String,Int>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

         map.put("Image", R.drawable.gifttedy)
         map.put("Image1",R.drawable.gifttedy)

       for (name in map.keys)
        {

           var textslider = TextSliderView(activity)

            textslider
               // .description(name)
                 .image(map.get(name)!!)
                . setScaleType(BaseSliderView.ScaleType.Fit)

            binding.SliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion)
            binding.SliderLayout.setDuration(2000)
            binding.SliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
            binding.SliderLayout.addSlider(textslider)
        }
        list = ArrayList()

        binding.rvGift.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,true)

        apiinterface = ApiClient.getretofit()!!.create(ApInterface::class.java)

        var call:Call<List<HomeModel>> = apiinterface.viewData()

        call.enqueue(object :Callback<List<HomeModel>>
        {
            override fun onResponse(call: Call<List<HomeModel>>,response: Response<List<HomeModel>>) {

                list = response.body() as MutableList<HomeModel>

                var adapter = HomeAdapter(context!!, list)
                binding.rvGift.adapter = adapter
            }

            override fun onFailure(call: Call<List<HomeModel>>, t: Throwable) {

                Toast.makeText(context,""+t.message, Toast.LENGTH_LONG).show()
            }
        })
        return  view
    }
}
