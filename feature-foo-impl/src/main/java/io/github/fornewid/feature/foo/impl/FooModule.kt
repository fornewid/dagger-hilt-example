package io.github.fornewid.feature.foo.impl

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.fornewid.feature.foo.Foo
import io.github.fornewid.feature.foo.FooNavigator

@Module
@InstallIn(SingletonComponent::class)
interface FooModule {

    @Binds
    fun bindsFoo(impl: FooImpl): Foo

    @Binds
    fun bindsFooNavigator(impl: FooNavigatorImpl): FooNavigator
}
