package io.github.fornewid.dagger.hilt.example

import androidx.lifecycle.ViewModel
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.github.fornewid.core.kotlin.AppScope
import io.github.fornewid.core.kotlin.ViewModelKey

@Module
@ContributesTo(AppScope::class)
interface ExampleViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ExampleViewModel::class)
    fun bindExampleViewModel(vm: ExampleViewModel): ViewModel
}
