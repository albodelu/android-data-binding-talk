package com.xrubio.databindingexample.ui

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import android.view.View
import com.xrubio.databindingexample.R
import com.xrubio.databindingexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Preferred way (more clear, similar to previous syntax)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Also possible, no need to import R, but involves two steps
        /*
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        */

        binding.view = this
        binding.pojoModelActivityButton.apply {
            alpha = 0.9f
            setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize * 2.0f)
        }
        binding.observableModelActivityButton.apply {
            alpha = 0.9f
            setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize * 1.28f)
        }
        binding.observableFieldModelActivityButton.apply {
            alpha = 0.9f
            setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize * 1.0f)
        }

        binding.twoWayBindingVanillaActivityButton.apply {
            alpha = 0.9f
            setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize * 0.9f)
        }
        binding.twoWayBindingConversionActivityButton.apply {
            alpha = 0.9f
            setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize * 0.62f)
        }
        binding.twoWayBindingConversionConverterActivityButton.apply {
            alpha = 0.9f
            setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize * 0.8f)
        }
    }

    fun onClickPojoModelActivityButton(view: View) {
        startActivity(Intent(this, PojoModelActivity::class.java))
    }

    fun onClickObservableModelActivityButton(view: View) {
        startActivity(Intent(this, ObservableModelActivity::class.java))
    }

    fun onClickObservableFieldModelActivityButton(view: View) {
        startActivity(Intent(this, ObservableFieldModelActivity::class.java))
    }

    fun onClickTwoWayBindingVanillaActivityButton(view: View) {
        startActivity(Intent(this, TwoWayBindingVanillaActivity::class.java))
    }

    fun onClickTwoWayBindingConversionActivityButton(view: View) {
        startActivity(Intent(this, TwoWayBindingConversionActivity::class.java))
    }

    fun onClickTwoWayBindingConversionConverterActivityButton(view: View) {
        startActivity(Intent(this, TwoWayBindingConversionConverterActivity::class.java))
    }
}
