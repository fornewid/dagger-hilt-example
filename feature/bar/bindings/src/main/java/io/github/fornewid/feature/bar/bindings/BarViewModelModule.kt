package io.github.fornewid.feature.bar.bindings

import androidx.lifecycle.ViewModel
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.github.fornewid.core.kotlin.AppScope
import io.github.fornewid.core.kotlin.ViewModelKey
import io.github.fornewid.feature.bar.impl.BarViewModel

@Module
@ContributesTo(AppScope::class)
interface BarViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(BarViewModel::class)
    fun bindBarViewModel(vm: BarViewModel): ViewModel
}
