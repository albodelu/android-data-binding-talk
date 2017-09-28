package com.xrubio.databindingexample.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.xrubio.databindingexample.BR

class ObservableModel() : BaseObservable() {

    constructor(message: String?) : this() {
        this.message = message
    }

    @get:Bindable
    var message: String? = null
        set(message) {
            field = message
            notifyPropertyChanged(BR.message)
        }
}
