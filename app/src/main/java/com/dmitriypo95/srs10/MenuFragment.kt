package com.dmitriypo95.srs10

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.sqrt

private const val VALUE_A = "value"
private const val LOG_TAG = "MyLog"

class MenuFragment : Fragment() {

    private lateinit var buttonCalc: Button
    private lateinit var editTextParA: com.google.android.material.textfield.TextInputEditText
    private lateinit var editTextParB: com.google.android.material.textfield.TextInputEditText
    private lateinit var editTextParC: com.google.android.material.textfield.TextInputEditText
    private lateinit var textViewResult: com.google.android.material.textview.MaterialTextView

   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        buttonCalc = view.findViewById(R.id.calcButton)

        editTextParA = view.findViewById(R.id.editTextParA)
        editTextParB = view.findViewById(R.id.editTextParB)
        editTextParC = view.findViewById(R.id.editTextParC)
        textViewResult = view.findViewById(R.id.resultTexView)

        editTextParA.setText(savedInstanceState?.getString(VALUE_A))
        buttonCalc.setOnClickListener {
            val a = editTextParA.text.toString().toDouble()
            val b = editTextParB.text.toString().toDouble()
            val c = editTextParC.text.toString().toDouble()

            textViewResult.text = calcResult(a,b,c).toString()

            resultCalcList.add(History("$a x^2 + $b x + c = 0",textViewResult.text.toString()))

        }
        return view
    }

    private fun calcResult(a: Double, b: Double, c: Double): String {
        var result: String

        val d = b * b - 4 * a * c
        if (d > 0) {
            val x1 = (-b + sqrt(d)) / (2 * a)
            val x2 = (-b - sqrt(d)) / (2 * a)
            result = "The solutions are $x1 and $x2"
        } else if (d.equals(0)) {
            val x = -b / (2 * a)
            result = "Both solutions are $x"
        } else {
            result = "This equation has no solutions"
        }
        return result
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(VALUE_A, editTextParA.text.toString())
    }

}