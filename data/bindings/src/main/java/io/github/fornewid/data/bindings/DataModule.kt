package io.github.fornewid.data.bindings

import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import io.github.fornewid.core.kotlin.AppScope
import io.github.fornewid.data.ExampleRepository
import io.github.fornewid.data.ExampleRepositoryImpl

@Module
@ContributesTo(AppScope::class)
interface DataModule {

    @Binds
    fun bindRepository(impl: ExampleRepositoryImpl): ExampleRepository
}
