package com.hasan.calculatorapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hasan.calculatorapp.databinding.ActivityMainBinding
import android.content.Context
import android.view.inputmethod.InputMethodManager

@SuppressLint("SetTextI18n")
class MainActivity : AppCompatActivity() {

    lateinit var myString : String
    private lateinit var binding: ActivityMainBinding

    private var number1 : Int? = null
    private var number2 : Int? = null
    private var result : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        myString = ""

    }

    //source: https://stackoverflow.com/questions/41790357/close-hide-the-android-soft-keyboard-with-kotlin
    fun hideKeyboard(context: Context, view: View) {
        val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }


    fun handleAllClear(view : View) {
        //AC button to delete everything
        binding.editText.text = null
        binding.editText2.text = null
        binding.resultText.text = "0"
        binding.operationText.text = ""
        binding.editText.requestFocus() //focus on the first input after cleared all
    }
    fun handleSum(view : View) {
        number1 = binding.editText.text.toString().toIntOrNull()
        number2 = binding.editText2.text.toString().toIntOrNull()

        if (number1 == null || number2 == null ) {
            binding.resultText.text = "Error!"
            binding.operationText.text = ""

        } else {
            result = number1!! + number2!!
            binding.resultText.text = "$result"
            binding.operationText.text = "$number1 + $number2"
        }

        hideKeyboard(this@MainActivity,binding.editText)
    }

    fun handleSubtraction(view : View) {
        number1 = binding.editText.text.toString().toIntOrNull()
        number2 = binding.editText2.text.toString().toIntOrNull()

        if (number1 == null || number2 == null ) {
            binding.resultText.text = "Error!"
            binding.operationText.text = ""
        } else {
            result = number1!! - number2!!
            binding.resultText.text = "$result"
            binding.operationText.text = "$number1 - $number2"
        }
        hideKeyboard(this@MainActivity,binding.editText)

    }

    fun handleMultiplication(view: View) {
        number1 = binding.editText.text.toString().toIntOrNull()
        number2 = binding.editText2.text.toString().toIntOrNull()

        if (number1 == null || number2 == null ) {

            binding.resultText.text = "Error!"
            binding.operationText.text = ""

        } else {
            result = number1!! * number2!!
            binding.resultText.text = "$result"
            binding.operationText.text = "$number1 * $number2"
        }
        hideKeyboard(this@MainActivity,binding.editText)


    }

    fun handleDivision(view: View) {

        number1 = binding.editText.text.toString().toIntOrNull()
        number2 = binding.editText2.text.toString().toIntOrNull()

        if (number1 == null || number2 == null ) {

            binding.resultText.text = "Error!"
            binding.operationText.text = ""

        } else {
            result = number1!! / number2!!
            binding.resultText.text = "$result"
            binding.operationText.text = "$number1 / $number2"

        }
        hideKeyboard(this@MainActivity,binding.editText)

    }





}