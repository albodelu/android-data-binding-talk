package com.xrubio.databindingexample.converters

import android.databinding.InverseMethod
import android.view.View
import android.widget.EditText
import com.xrubio.databindingexample.R
import java.text.DecimalFormat
import java.text.NumberFormat
import java.text.ParseException

object AdvancedIntConverter {

    @InverseMethod("toInt")
    fun toString(view: EditText, oldValue: Int, value: Int): String {
        val numberFormat = getNumberFormat(view)
        try {
            // Don't return a different value if the parsed value doesn't change
            val inView = view.text.toString()
            val parsed = numberFormat.parse(inView).toInt()
            if (parsed == value) {
                return view.text.toString()
            }
        } catch (e: ParseException) {
            // Old number was broken
        }

        return numberFormat.format(value)
    }

    fun toInt(view: EditText, oldValue: Int, value: String): Int {
        val numberFormat = getNumberFormat(view)
        return try {
            numberFormat.parse(value).toInt()
        } catch (e: ParseException) {
            val resources = view.resources
            val errStr = resources.getString(R.string.bad_number)
            view.error = errStr
            oldValue
        }
    }

    private fun getNumberFormat(view: View): NumberFormat {
        val resources = view.resources
        val locale = resources.configuration.locale
        val format = NumberFormat.getNumberInstance(locale)
        if (format is DecimalFormat) {
            format.setGroupingUsed(false)
        }
        return format
    }
}