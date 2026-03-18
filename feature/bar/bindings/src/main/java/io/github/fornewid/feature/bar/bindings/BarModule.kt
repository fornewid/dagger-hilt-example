package io.github.fornewid.feature.bar.bindings

import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import io.github.fornewid.core.kotlin.AppScope
import io.github.fornewid.feature.bar.Bar
import io.github.fornewid.feature.bar.BarNavigator
import io.github.fornewid.feature.bar.impl.BarImpl
import io.github.fornewid.feature.bar.impl.BarNavigatorImpl
import io.github.fornewid.feature.foo.Foo
import javax.inject.Singleton

@Module
@ContributesTo(AppScope::class)
object BarModule {

    @Singleton
    @Provides
    fun providesBar(foo: Foo): Bar = BarImpl(foo)

    @Provides
    fun providesBarNavigator(): BarNavigator = BarNavigatorImpl()
}
