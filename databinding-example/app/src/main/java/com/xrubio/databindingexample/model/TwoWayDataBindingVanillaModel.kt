package com.xrubio.databindingexample.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.xrubio.databindingexample.BR

// We can use data class...
//data class TwoWayDataBindingVanillaModel(var value: String)

// ...or observables
class TwoWayDataBindingVanillaModel() : BaseObservable() {

    constructor(value: String?) : this() {
        this.value = value
    }

    @get:Bindable
    var value: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.value)
        }
}

// ObservableFields don't work, generate compilation errors
/*
class TwoWayDataBindingVanillaModel() {

    val value: ObservableField<String> = ObservableField()

    constructor(value: String) : this() {
        this.value.set(value)
    }
}
*/