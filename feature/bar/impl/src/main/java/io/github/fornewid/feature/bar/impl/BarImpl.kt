package io.github.fornewid.feature.bar.impl

import com.squareup.anvil.annotations.ContributesBinding
import io.github.fornewid.core.kotlin.di.AppScope
import io.github.fornewid.feature.bar.Bar
import io.github.fornewid.feature.foo.Foo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@ContributesBinding(AppScope::class)
class BarImpl @Inject constructor(
    private val foo: Foo,
) : Bar {

    override fun toString(): String {
        return "BarImpl(foo=$foo)"
    }
}
