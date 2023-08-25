package io.github.fornewid.feature.bar.impl

import io.github.fornewid.feature.bar.Bar
import io.github.fornewid.feature.foo.Foo
import javax.inject.Inject

class BarImpl @Inject constructor(
    private val foo: Foo,
) : Bar {

    override fun toString(): String {
        return "BarImpl(foo=$foo)"
    }
}
