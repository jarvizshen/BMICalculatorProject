package com.example.bmicalculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.googlecode.aviator.AviatorEvaluator
import java.util.*
import kotlin.text.StringBuilder

class CalculatorViewModel : ObservableViewModel() {
    val res: MutableLiveData<StringBuilder> = MutableLiveData(StringBuilder())

    //    fun onNum(num: Int) {
//        res.value!!.append(num)
//        notifyChange()
//    }
    fun del(){
            res.value!!.apply{
                deleteCharAt(length-1)
                if(isEmpty()){
                    append(0)
                }
                notifyChange()
            }
    }
    fun clear(){
        res.value!!.clear()
        notifyChange()
    }
    fun onChar(char: Char) {
        res.value!!.apply {
            if(equals("0")){
                deleteCharAt(0)
            }
            append(char)
        }
        notifyChange()
    }
    fun result(){
        val r = res.value.toString()
        clear()
        res.value!!.append(AviatorEvaluator.execute(r).toString())
        notifyChange()
    }
}