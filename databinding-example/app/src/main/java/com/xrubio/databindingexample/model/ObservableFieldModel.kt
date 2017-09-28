package com.xrubio.databindingexample.model

import android.databinding.ObservableBoolean
import android.databinding.ObservableField

class ObservableFieldModel() {

    val message: ObservableField<String> = ObservableField()
    val visible: ObservableBoolean = ObservableBoolean()

    constructor(message: String, visible: Boolean) : this() {
        this.message.set(message)
        this.visible.set(visible)
    }
}
