package io.github.fornewid.feature.foo.impl

import com.squareup.anvil.annotations.ContributesBinding
import io.github.fornewid.core.kotlin.di.AppScope
import io.github.fornewid.feature.foo.Foo
import javax.inject.Inject

@ContributesBinding(AppScope::class)
class FooImpl @Inject constructor() : Foo {

    override fun toString(): String {
        return "FooImpl@" + hashCode().toString(16)
    }
}
