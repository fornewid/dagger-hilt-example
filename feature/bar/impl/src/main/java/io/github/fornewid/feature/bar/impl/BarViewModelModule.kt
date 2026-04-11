package io.github.fornewid.feature.bar.impl

import androidx.lifecycle.ViewModel
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.github.fornewid.core.kotlin.di.ActivityRetainedScope
import io.github.fornewid.core.kotlin.di.ViewModelKey

@Module
@ContributesTo(ActivityRetainedScope::class)
abstract class BarViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(BarViewModel::class)
    abstract fun bindBarViewModel(viewModel: BarViewModel): ViewModel
}
