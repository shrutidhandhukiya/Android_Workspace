package com.example.project.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.Toast
import com.example.project.Client.ApiClient
import com.example.project.Interface.ApInterface
import com.example.project.R
import com.example.project.databinding.ActivityLoginBinding
import com.example.project.databinding.ActivitySignUpBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class SignUpActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    private lateinit var binding: ActivitySignUpBinding
    lateinit var  apiInterface : ApInterface
    var gender = ""

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        apiInterface = ApiClient.getretofit()!!.create(ApInterface::class.java)

        binding.rbMale.setOnCheckedChangeListener(this)
        binding.rbFemale.setOnCheckedChangeListener(this)

        binding.tvLogin.setOnClickListener {

            startActivity(Intent(applicationContext,LoginActivity::class.java))
        }

        binding.btSignUp.setOnClickListener {

            var fName = binding.edFname.text.toString()
            var lName = binding.edLname.text.toString()
            var email = binding.edEmail.text.toString()
            var phone = binding.edPhoneNo.text.toString()
            var city = binding.edCity.text.toString()
            var password = binding.edPassword.text.toString()

            if (fName.isEmpty() && lName.isEmpty() && email.isEmpty() && phone.isEmpty() && city.isEmpty() && password.isEmpty())
            {
                binding.edFname.error = "Please Enter FirstName"
                binding.edLname.error = "Please Enter LastName"
                binding.edEmail.error = "Please Enter Email"
                binding.edPhoneNo.error = "Please Enter Phone"
                binding.edCity.setError("Please Enter City")
            }

            else if (fName.isEmpty())
            {
                binding.edFname.error = "Please Enter FirstName"
            }
            else if (lName.isEmpty())
            {
                binding.edLname.error = "Please Enter LastName"
            }
            else if (email.isEmpty())
            {
                binding.edEmail.error = "Please Enter Email"
            }
            else if (phone.isEmpty())
            {
                binding.edPhoneNo.error = "Please Enter Phone"
            }
            else if (city.isEmpty())
            {
                binding.edCity.setError("Please Enter City")
            }
            else
            {
                var call:Call<Void> = apiInterface.signup(fName,lName,gender,email,phone,password)

                call.enqueue(object:Callback<Void>{
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {

                        Toast.makeText(applicationContext,"Signup Successful",Toast.LENGTH_SHORT).show()
                        startActivity(Intent(applicationContext,LoginActivity::class.java))

                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        Toast.makeText(applicationContext,"Incorrect SignUp",Toast.LENGTH_SHORT).show()
                    }
                })

            }
        }
    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {

        if (binding.rbMale.isChecked)
        {
            gender = "Male"
        }
        else if (binding.rbFemale.isChecked)
        {
            gender = "Female"
        }
    }
}


