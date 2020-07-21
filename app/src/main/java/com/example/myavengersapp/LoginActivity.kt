package com.example.myavengersapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    //, View.OnClickListener interface not implemented
   // override fun onClick(p0: View?) {
    //    Toast.makeText(this,"We clicked to view toast",Toast.LENGTH_LONG).show()
   // }
    val validMobileNumber="1234567890"
    val validPassword=arrayOf("tony","panther","captain","thor","widow","hulk")
    lateinit var et1_username: EditText
    lateinit var et2_password: EditText
    lateinit var btn1_login:Button
    lateinit var t1_forgot_password:TextView
    lateinit var t2_create_account:TextView
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false)
        setContentView(R.layout.activity_login)
        if (isLoggedIn){
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)//define intent
            startActivity(intent)
            finish()
        }
        title = "Log In"
        et1_username = findViewById(R.id.et1_username)
        et2_password = findViewById(R.id.et2_password)
        btn1_login = findViewById(R.id.btn1_login)
        t1_forgot_password = findViewById(R.id.t1_forgot_password)
        t2_create_account = findViewById(R.id.t2_create_account)
        val intent = Intent(this@LoginActivity, AvengersActivity::class.java)//define intent
        btn1_login.setOnClickListener {
            val mobileNumber = et1_username.text.toString()
            val password = et2_password.text.toString()
            var nameOfAvenger = "Avenger"

        if (mobileNumber == validMobileNumber) {
            if(password == validPassword[0]){
                nameOfAvenger="Tony Stark"
                savePreferences(nameOfAvenger)
                //intent.putExtra("Name",nameOfAvenger)
                startActivity(intent)
                finish()
            }
            else if(password == validPassword[1]){
                nameOfAvenger="Black Panther"
                savePreferences(nameOfAvenger)
                //intent.putExtra("Name",nameOfAvenger)
                startActivity(intent)
                finish()
            }
            else if(password == validPassword[2]){
                nameOfAvenger="Captain America"
                savePreferences(nameOfAvenger)
                //intent.putExtra("Name",nameOfAvenger)
                startActivity(intent)
                finish()
            }
            else if(password == validPassword[3]){
                nameOfAvenger="Thor"
                savePreferences(nameOfAvenger)
               // intent.putExtra("Name",nameOfAvenger)
                startActivity(intent)
                finish()
            }
            else if(password == validPassword[4]){
                nameOfAvenger="Widow"
                savePreferences(nameOfAvenger)
                //intent.putExtra("Name",nameOfAvenger)
                startActivity(intent)
                finish()
            }
            else if(password == validPassword[5]){
                nameOfAvenger="Hulk"
                savePreferences(nameOfAvenger)
                //intent.putExtra("Name",nameOfAvenger)
                startActivity(intent)
                finish()
            }

        } else {
            Toast.makeText(
                this,
                "Incorrect Credentials! Please Try Again",
                Toast.LENGTH_LONG
            ).show()

            //change (this) to {it:View...} i.e. lambda representation
        }
    }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savePreferences(title:String){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }


}
