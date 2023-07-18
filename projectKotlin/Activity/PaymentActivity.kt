package com.example.test.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.test.R
import com.example.test.databinding.ActivityCategoryBinding
import com.example.test.databinding.ActivityPaymentBinding
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import com.squareup.picasso.Picasso
import org.json.JSONException
import org.json.JSONObject

class PaymentActivity : AppCompatActivity(), PaymentResultListener
{
    private lateinit var binding: ActivityPaymentBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i = intent
        var id = i.getIntExtra("id",100)
        var name = i.getStringExtra("name")
        var price = i.getStringExtra("price")
        //var des = i.getStringExtra("description")
        var img = i.getStringExtra("image")


        binding.categoryNameTextView.setText(name)
        binding.categoryDescTextView.setText(price)
        //binding.categoryPriceTextView.setText((des))
        Picasso.get().load(img).into(binding.categoryImageView)

        binding.idBtnMakePaymanet.setOnClickListener {

           // val amount = Math.round(price!!.toFloat() * 100).toInt()
            val checkout = Checkout()
            checkout.setKeyID("rzp_test_7PX7ejznhsbYwJ")
            //checkout.setImage(R.mipmap.ic_launcher)
            val obj = JSONObject()
            try
            {
                obj.put("name", "Geeks for Geeks")

                // put description
                obj.put("description", "Test payment")

                // to set theme color
                obj.put("theme.color", "")

                // put the currency
                obj.put("currency", "INR")

                // put amount
                obj.put("amount", price)

                // put mobile number
                obj.put("prefill.contact", "+918849817263")

                // put email
                obj.put("prefill.email", "submitdata123@gmail.com")
                checkout.open(this, obj)
            }
            catch (e: JSONException)
            {
                e.printStackTrace()
            }




        }



    }

    override fun onPaymentSuccess(p0: String?) {
        Toast.makeText(this, "Payment is successful : " + p0, Toast.LENGTH_SHORT).show();



    }

    override fun onPaymentError(p0: Int, p1: String?) {
        Toast.makeText(this, "Payment  Error : " +p0, Toast.LENGTH_SHORT).show();
    }
}