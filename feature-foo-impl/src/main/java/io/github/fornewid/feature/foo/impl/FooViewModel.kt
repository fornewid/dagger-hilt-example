package io.github.fornewid.feature.foo.impl

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.fornewid.data.ExampleRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FooViewModel @Inject constructor(
    private val exampleRepository: ExampleRepository,
) : ViewModel() {

    fun doSomething() {
        viewModelScope.launch {
            Log.d("FooViewModel", "doSomething: " + exampleRepository.getSomething())
        }
    }
}
