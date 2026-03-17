package io.github.fornewid.feature.foo.impl

import io.github.fornewid.feature.foo.Foo

class FooImpl : Foo {

    override fun toString(): String {
        return "FooImpl@" + hashCode().toString(16)
    }
}
