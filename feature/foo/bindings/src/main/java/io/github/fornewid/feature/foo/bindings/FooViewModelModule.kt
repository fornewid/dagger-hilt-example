package io.github.fornewid.feature.foo.bindings

import androidx.lifecycle.ViewModel
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.github.fornewid.core.kotlin.AppScope
import io.github.fornewid.core.kotlin.ViewModelKey
import io.github.fornewid.data.ExampleRepository
import io.github.fornewid.feature.foo.impl.FooViewModel

@Module
@ContributesTo(AppScope::class)
object FooViewModelModule {

    @Provides
    @IntoMap
    @ViewModelKey(FooViewModel::class)
    fun provideFooViewModel(exampleRepository: ExampleRepository): ViewModel =
        FooViewModel(exampleRepository)
}
