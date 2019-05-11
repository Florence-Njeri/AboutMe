package com.example.android.aboutme

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.android.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Binding object variable
    private lateinit var binding: ActivityMainBinding
//Instantiate the MyName class
    private val myName:MyName= MyName("Florence njeri")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName=myName
        binding.doneButton.setOnClickListener { addNickname(it) }

    }

    //    View refers to the Button
    private fun addNickname(view: View) {

        binding.apply {
        //Binding.nicknameText.text = binding.nicknameEdit.text
        //Setting the nickname to the user input
            myName?.nickname=nicknameEdit.toString()
//            Rebind to refresh the UI
            invalidateAll()
            binding.nicknameEdit.visibility = View.GONE
            binding.doneButton.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE
        }


        // Hide the keyboard once input is done
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
