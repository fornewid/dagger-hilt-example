package io.github.fornewid.feature.navigation.compose

import androidx.lifecycle.ViewModel
import io.github.fornewid.feature.bar.Bar
import javax.inject.Inject

class ExampleNavGraphViewModel @Inject constructor(
    private val bar: Bar,
) : ViewModel() {

    fun getSomething(): String {
        return "ExampleNavGraphViewModel@" + hashCode().toString(16)
    }
}
