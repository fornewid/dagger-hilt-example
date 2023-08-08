package io.github.fornewid.feature.work.impl

import io.github.fornewid.feature.bar.Bar
import javax.inject.Inject

interface ExampleUseCase {
    operator fun invoke(): Boolean
}

class ExampleUseCaseImpl @Inject constructor(
    private val bar: Bar,
) : ExampleUseCase {

    override fun invoke(): Boolean {
        bar.toString()
        return true
    }
}
