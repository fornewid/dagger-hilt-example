package io.github.fornewid.feature.bar.impl

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.fornewid.data.ExampleRepository
import kotlinx.coroutines.launch

class BarViewModel(
    private val exampleRepository: ExampleRepository,
) : ViewModel() {

    fun doSomething() {
        viewModelScope.launch {
            Log.d("FooViewModel", "doSomething: " + exampleRepository.getSomething())
        }
    }
}
