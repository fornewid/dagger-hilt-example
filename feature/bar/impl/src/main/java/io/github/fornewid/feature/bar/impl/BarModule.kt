package io.github.fornewid.feature.bar.impl

import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import io.github.fornewid.core.kotlin.AppScope
import io.github.fornewid.feature.bar.Bar
import io.github.fornewid.feature.bar.BarNavigator
import javax.inject.Singleton

@Module
@ContributesTo(AppScope::class)
interface BarModule {

    @Singleton
    @Binds
    fun bindsBar(impl: BarImpl): Bar

    @Binds
    fun bindsBarNavigator(impl: BarNavigatorImpl): BarNavigator
}
