package io.github.fornewid.feature.bar.bindings

import androidx.lifecycle.ViewModel
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.github.fornewid.core.kotlin.AppScope
import io.github.fornewid.core.kotlin.ViewModelKey
import io.github.fornewid.data.ExampleRepository
import io.github.fornewid.feature.bar.impl.BarViewModel

@Module
@ContributesTo(AppScope::class)
object BarViewModelModule {

    @Provides
    @IntoMap
    @ViewModelKey(BarViewModel::class)
    fun provideBarViewModel(exampleRepository: ExampleRepository): ViewModel =
        BarViewModel(exampleRepository)
}
