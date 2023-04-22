
package com.example.assingmentapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PdfImplicit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_implicit)

        var url = "https://topsint.com/careercenter/assignment/android_assignment.pdf"
        var i = Intent(Intent.ACTION_VIEW)
        i.setData(Uri.parse(url))
        startActivity(i)
    }
}