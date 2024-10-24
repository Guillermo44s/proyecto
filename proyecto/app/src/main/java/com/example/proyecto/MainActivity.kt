package com.example.proyecto

import android.content.Context
import android.content.ContextParams
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.view.View.OnClickListener
import com.example.proyecto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , OnClickListener{

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.buttonSave.setOnClickListener(this)
        binding.buttonDelete.setOnClickListener(this)
        binding.buttonGoView.setOnClickListener(this)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun saveData(){
        val userName = binding.editTextUser.text.toString()

        var preference = getSharedPreferences("mePreference", Context.MODE_PRIVATE)
        var edit = preference.edit()

        edit.putString("userName",binding.editTextUser.text.toString())
        edit.apply()
    }

    private fun deleteData() {


        var preference = getSharedPreferences("mePreference", Context.MODE_PRIVATE)
        var edit = preference.edit()

        edit.remove("userName")
        edit.apply()
    }

    private fun goToView(){
        val intentrr = Intent(this, view::class.java)
        intentrr.putExtra("userName",binding.editTextUser.text.toString())
        startActivity(intentrr)
        finish()
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.buttonSave -> saveData()
            R.id.buttonDelete -> deleteData()
            R.id.buttonGoView -> goToView()
        }
    }
}