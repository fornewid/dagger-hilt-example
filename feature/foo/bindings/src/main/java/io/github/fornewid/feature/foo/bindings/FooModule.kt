package io.github.fornewid.feature.foo.bindings

import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import io.github.fornewid.core.kotlin.AppScope
import io.github.fornewid.feature.foo.Foo
import io.github.fornewid.feature.foo.FooNavigator
import io.github.fornewid.feature.foo.impl.FooImpl

@Module
@ContributesTo(AppScope::class)
interface FooModule {

    @Binds
    fun bindsFoo(impl: FooImpl): Foo

    @Binds
    fun bindsFooNavigator(impl: FooNavigatorImpl): FooNavigator
}
