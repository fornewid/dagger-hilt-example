package io.github.fornewid.feature.foo.bindings

import androidx.lifecycle.ViewModel
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.github.fornewid.core.kotlin.AppScope
import io.github.fornewid.core.kotlin.ViewModelKey
import io.github.fornewid.feature.foo.impl.FooViewModel

@Module
@ContributesTo(AppScope::class)
interface FooViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FooViewModel::class)
    fun bindFooViewModel(vm: FooViewModel): ViewModel
}
