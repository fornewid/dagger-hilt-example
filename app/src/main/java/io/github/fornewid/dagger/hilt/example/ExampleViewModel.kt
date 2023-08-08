package io.github.fornewid.dagger.hilt.example

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.fornewid.feature.bar.Bar
import javax.inject.Inject

@HiltViewModel
class ExampleViewModel @Inject constructor(
    private val bar: Bar,
) : ViewModel() {

    fun doSomething() {
        bar.toString()
    }
}
