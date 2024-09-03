package com.example.sharedpreference

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var name : EditText
    private lateinit var age : EditText
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        name = findViewById(R.id.edit1)
        age = findViewById(R.id.edit2)
    }

    override fun onResume() {
        super.onResume()
        val data = getSharedPreferences("Mysharedpref", MODE_PRIVATE)
        val s1 = data.getString("Name","")
        val s2 = data.getInt("Age",0)

        name.setText(s1)
        age.setText(s2.toString())
    }

    override fun onPause() {
        super.onPause()
        val sharedPreferences =  getSharedPreferences("Mysharedpref", MODE_PRIVATE)
        val myEdit = sharedPreferences.edit()

        myEdit.putString("name", name.text.toString())
        myEdit.putInt("age", age.text.toString().toInt())
        myEdit.apply()
    }
}