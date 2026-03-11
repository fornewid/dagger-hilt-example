package io.github.fornewid.feature.foo.impl

import io.github.fornewid.feature.foo.Foo
import javax.inject.Inject

class FooImpl @Inject constructor() : Foo {

    override fun toString(): String {
        return "FooImpl@" + hashCode().toString(16)
    }
}
