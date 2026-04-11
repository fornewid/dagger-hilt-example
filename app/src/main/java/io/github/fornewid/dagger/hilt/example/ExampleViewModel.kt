package io.github.fornewid.dagger.hilt.example

import androidx.lifecycle.ViewModel
import io.github.fornewid.feature.bar.Bar
import javax.inject.Inject

class ExampleViewModel @Inject constructor(
    private val bar: Bar,
) : ViewModel() {

    fun doSomething() {
        bar.toString()
    }
}
