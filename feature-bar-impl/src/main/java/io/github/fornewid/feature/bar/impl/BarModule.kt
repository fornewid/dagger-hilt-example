package io.github.fornewid.feature.bar.impl

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.fornewid.feature.bar.Bar
import io.github.fornewid.feature.bar.BarNavigator

@Module
@InstallIn(SingletonComponent::class)
interface BarModule {

    @Binds
    fun bindsBar(impl: BarImpl): Bar

    @Binds
    fun bindsBarNavigator(impl: BarNavigatorImpl): BarNavigator
}
