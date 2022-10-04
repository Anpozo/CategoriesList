package com.example.categorieslist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Attributes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attributes)
        val API= findViewById<TextView>(R.id.API)
           val recibeApi=intent.getStringExtra("API")
              API.setText(recibeApi)

        val Description= findViewById<TextView>(R.id.Description)
           val recibeDescription=intent.getStringExtra("Description")
               Description.setText(recibeDescription)

        val Auth= findViewById<TextView>(R.id.Auth)
            val recibeAuth=intent.getStringExtra("Auth")
                Auth.setText(recibeAuth)

        val HTTPS= findViewById<TextView>(R.id.HTTPS)
            val recibeHTTPS= intent.getStringExtra("HTTPS")
                HTTPS.setText(recibeHTTPS)

        val Cors = findViewById<TextView>(R.id.Cors)
            val recibeCors= intent.getStringExtra("Cors")
                Cors.setText(recibeCors)

        val Link= findViewById<TextView>(R.id.Link)
            val recibeLink= intent.getStringExtra("Link")
                Link.setText(recibeLink)

        val back:Button=findViewById(R.id.button)
          back.setOnClickListener { val toMain= Intent(this, MainActivity::class.java)
          startActivity(toMain)}

    }

}