package com.xrubio.databindingexample.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.xrubio.databindingexample.R
import com.xrubio.databindingexample.databinding.ActivityTwoWayBindingVanillaBinding
import com.xrubio.databindingexample.model.TwoWayDataBindingVanillaModel

class TwoWayBindingVanillaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTwoWayBindingVanillaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_two_way_binding_vanilla)

        binding.model = TwoWayDataBindingVanillaModel("")
        binding.view = this
    }

    fun onButtonClick(btn: View, value: String) {
        Toast.makeText(this, "Value is ${if (value.isNotBlank()) value else "empty"}", Toast.LENGTH_LONG)
                .show()
    }

}