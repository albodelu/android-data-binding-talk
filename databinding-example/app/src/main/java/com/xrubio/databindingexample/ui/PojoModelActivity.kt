package com.xrubio.databindingexample.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import com.xrubio.databindingexample.R
import com.xrubio.databindingexample.databinding.ActivityPojoModelBinding
import com.xrubio.databindingexample.model.PojoModel

class PojoModelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPojoModelBinding
    private lateinit var model: PojoModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_pojo_model)

        model = PojoModel(message = "Hello World!")
        binding.model = model

        Handler(Looper.getMainLooper()).postDelayed({
            binding.model.message = "You will never see this..."
        }, 1000)

        Handler(Looper.getMainLooper()).postDelayed({
            binding.model = PojoModel("...but you will see this")
        }, 2000)
    }
}
