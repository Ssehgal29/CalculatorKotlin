package com.app.calculatorkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnNumClick(view:View){
        if(isNewOp){
            txtResult.text = ""
        }
        isNewOp=false
        val btnSelected = view as Button
        var btnClickValue = txtResult.text.toString()
        when(btnSelected.id){
            btnNum0.id -> {
                btnClickValue+="0"
            }
            btnNum1.id -> {
                btnClickValue+="1"
            }
            btnNum2.id -> {
                btnClickValue+="2"
            }
            btnNum3.id -> {
                btnClickValue+="3"
            }
            btnNum4.id -> {
                btnClickValue+="4"
            }
            btnNum5.id -> {
                btnClickValue+="5"
            }
            btnNum6.id -> {
                btnClickValue+="6"
            }
            btnNum7.id -> {
                btnClickValue+="7"
            }
            btnNum8.id -> {
                btnClickValue+="8"
            }
            btnNum9.id -> {
                btnClickValue+="9"
            }
            btnPoint.id -> {
                btnClickValue+="."
            }
            btnAllClear.id -> {
                btnClickValue="ac"
            }
            btnPlusMinus.id -> {
                btnClickValue="-"
            }
            btnPercent.id -> {
                btnClickValue="%"
            }
            btnDivide.id -> {
                btnClickValue="/"
            }
            btnMultiply.id -> {
                btnClickValue="*"
            }
            btnSubtract.id -> {
                btnClickValue="-$btnClickValue"
            }
            btnAddition.id -> {
                btnClickValue="+"
            }
            btnEquals.id -> {
                btnClickValue="="
            }
        }
        txtResult.text = btnClickValue
    }

    var operation = "*"
    var oldNum = ""
    var isNewOp = true

    fun btnOpEvent(view: View){
        val btnSelected = view as Button
        when(btnSelected.id) {
            btnMultiply.id -> {
                operation="*"
            }
            btnDivide.id -> {
                operation="/"
            }
            btnSubtract.id -> {
                operation="-"
            }
            btnAddition.id -> {
                operation="+"
            }
        }
        oldNum = txtResult.text.toString()
        isNewOp=true
    }

    fun btnEqualEvent(view: View){
        val newNum = txtResult.text.toString()
        var finalResult:Double?=null
        if(oldNum != "" && newNum != ""){
            when(operation){
                "*" -> {
                    finalResult = oldNum.toDouble() * newNum.toDouble()
                    oldNum=""
                }
                "/" -> {
                    finalResult = oldNum.toDouble() / newNum.toDouble()
                    oldNum=""
                }
                "+" -> {
                    finalResult = oldNum.toDouble() + newNum.toDouble()
                    oldNum=""
                }
                "-" -> {
                    finalResult = oldNum.toDouble() - newNum.toDouble()
                    oldNum=""
                }
            }
            txtResult.text = finalResult.toString()
            isNewOp=true
        }
    }

    fun btnPercentClick(view: View){
        val number = txtResult.text.toString().toDouble()/100

        txtResult.text = number.toString()
    }

    fun btnAcClick(view: View){
        txtResult.text = "0"
        oldNum=""
        isNewOp=true
    }
}