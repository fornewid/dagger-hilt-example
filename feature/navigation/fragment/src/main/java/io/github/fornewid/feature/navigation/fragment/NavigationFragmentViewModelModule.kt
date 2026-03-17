package io.github.fornewid.feature.navigation.fragment

import androidx.lifecycle.ViewModel
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.github.fornewid.core.kotlin.AppScope
import io.github.fornewid.core.kotlin.ViewModelKey

@Module
@ContributesTo(AppScope::class)
interface NavigationFragmentViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ExampleNavGraphViewModel::class)
    fun bindExampleNavGraphViewModel(vm: ExampleNavGraphViewModel): ViewModel
}
