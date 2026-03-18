package io.github.fornewid.feature.navigation.compose.bindings

import androidx.lifecycle.ViewModel
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.github.fornewid.core.kotlin.AppScope
import io.github.fornewid.core.kotlin.ViewModelKey
import io.github.fornewid.feature.navigation.compose.ExampleNavGraphViewModel

@Module
@ContributesTo(AppScope::class)
interface NavigationComposeViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ExampleNavGraphViewModel::class)
    fun bindExampleNavGraphViewModel(vm: ExampleNavGraphViewModel): ViewModel
}
