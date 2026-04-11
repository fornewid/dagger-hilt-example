package io.github.fornewid.feature.foo.impl

import androidx.lifecycle.ViewModel
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.github.fornewid.core.kotlin.di.ActivityRetainedScope
import io.github.fornewid.core.kotlin.di.ViewModelKey

@Module
@ContributesTo(ActivityRetainedScope::class)
abstract class FooViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FooViewModel::class)
    abstract fun bindFooViewModel(viewModel: FooViewModel): ViewModel
}
