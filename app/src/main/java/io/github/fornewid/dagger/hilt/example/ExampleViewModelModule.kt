package io.github.fornewid.dagger.hilt.example

import androidx.lifecycle.ViewModel
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.github.fornewid.core.kotlin.di.ActivityRetainedScope
import io.github.fornewid.core.kotlin.di.ViewModelKey

@Module
@ContributesTo(ActivityRetainedScope::class)
abstract class ExampleViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ExampleViewModel::class)
    abstract fun bindExampleViewModel(viewModel: ExampleViewModel): ViewModel
}
