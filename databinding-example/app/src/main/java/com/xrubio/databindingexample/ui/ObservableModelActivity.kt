package com.xrubio.databindingexample.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import com.xrubio.databindingexample.R
import com.xrubio.databindingexample.databinding.ActivityObservableModelBinding
import com.xrubio.databindingexample.model.ObservableModel

class ObservableModelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityObservableModelBinding
    private lateinit var model: ObservableModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_observable_model)

        model = ObservableModel(message = "Hello World!")
        binding.model = model

        Handler(Looper.getMainLooper()).postDelayed({
            binding.model.message = "You should see this instead of 'Hello World!'"
        }, 1000)
    }
}