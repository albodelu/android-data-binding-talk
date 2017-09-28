package com.xrubio.databindingexample.converters

import android.databinding.InverseMethod

object IntConverter {

    @InverseMethod("toInt")
    fun toString(value: Int): String {
        return if (value >= 0)
            value.toString()
        else
            ""
    }

    fun toInt(value: String): Int {
        return try {
            Integer.parseInt(value)
        } catch (e: NumberFormatException) {
            -1
        }
    }
}
