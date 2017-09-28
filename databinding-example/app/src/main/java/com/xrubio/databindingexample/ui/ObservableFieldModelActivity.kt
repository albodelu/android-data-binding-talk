package com.xrubio.databindingexample.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import com.xrubio.databindingexample.R
import com.xrubio.databindingexample.databinding.ActivityObservableFieldModelBinding
import com.xrubio.databindingexample.model.ObservableFieldModel

class ObservableFieldModelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityObservableFieldModelBinding
    private lateinit var model: ObservableFieldModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_observable_field_model)

        model = ObservableFieldModel(message = "Hello World!", visible = true)
        binding.model = model

        Handler(Looper.getMainLooper()).postDelayed({
            binding.model.message.set("You should see this instead of 'Hello World!'")
        }, 1000)
    }
}