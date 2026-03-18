package io.github.fornewid.feature.foo.bindings

import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import io.github.fornewid.core.kotlin.AppScope
import io.github.fornewid.feature.foo.Foo
import io.github.fornewid.feature.foo.FooNavigator
import io.github.fornewid.feature.foo.impl.FooImpl
import io.github.fornewid.feature.foo.impl.FooNavigatorImpl

@Module
@ContributesTo(AppScope::class)
object FooModule {

    @Provides
    fun providesFoo(): Foo = FooImpl()

    @Provides
    fun providesFooNavigator(): FooNavigator = FooNavigatorImpl()
}
