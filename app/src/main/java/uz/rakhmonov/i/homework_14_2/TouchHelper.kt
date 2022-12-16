package uz.rakhmonov.i.homework_14_2

import java.text.FieldPosition

interface TouchHelper {
    fun onItemMove(fromPosition:Int, toPosition:Int)
    fun onItemDissmiss(position:Int)
}