package io.github.fornewid.data

import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import io.github.fornewid.core.kotlin.di.AppScope

@Module
@ContributesTo(AppScope::class)
interface DataModule {

    @Binds
    fun bindRepository(impl: ExampleRepositoryImpl): ExampleRepository
}
