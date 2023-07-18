package com.example.project.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.project.Client.ApiClient
import com.example.project.Interface.ApInterface
import com.example.project.Model.LoginModel
import com.example.project.R
import com.example.project.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
   lateinit var apInterface: ApInterface
   lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        apInterface = ApiClient.getretofit()!!.create(ApInterface::class.java)
        sharedPreferences = getSharedPreferences("SESSION",Context.MODE_PRIVATE)

        if (sharedPreferences.getBoolean("SESSION", false) && sharedPreferences.getString("PHONE", "")!!
                .isNotEmpty())
        {
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
        }

        binding.tvSignuptxt.setOnClickListener {

            startActivity(Intent(applicationContext, SignUpActivity::class.java))
        }

        binding.btLoginbtn.setOnClickListener {

            var phone = binding.edMobileNo.text.toString()
            var pass = binding.edPassword.text.toString()

            if (phone.isEmpty() && pass.isEmpty()) {
                binding.edMobileNo.setError("Please Enter PhoneNo")
                binding.edPassword.setError("Please Enter Password")

            } else if (phone.isEmpty()) {
                binding.edMobileNo.setError("Please Enter PhoneNo")

            } else if (pass.isEmpty()) {
                binding.edPassword.setError("Please Enter Password")
            }
            else
            {
                var call: Call<LoginModel> = apInterface.loginData(phone, pass)
                call.enqueue(object : Callback<LoginModel> {
                    override fun onResponse(
                        call: Call<LoginModel>,
                        response: Response<LoginModel>
                    ) {

                        Toast.makeText(applicationContext, "Login Sucsess", Toast.LENGTH_SHORT).show()


                        // Shared prefrence
                        var edit:SharedPreferences.Editor = sharedPreferences.edit()
                        edit.putString("PHONE",phone)
                        edit.putString("PASS",pass)
                        edit.putBoolean("SESSION",true)
                        edit.commit()

                        startActivity(Intent(applicationContext,DashboardActivity::class.java))

                    }

                    override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                        Toast.makeText(applicationContext, "Incorrect Login  ", Toast.LENGTH_SHORT)
                            .show()
                    }
                })
            }
        }
    }

    override fun onBackPressed() {

        finishAffinity()
        super.onBackPressed()
    }
}