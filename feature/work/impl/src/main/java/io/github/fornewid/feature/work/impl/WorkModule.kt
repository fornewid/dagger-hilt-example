package io.github.fornewid.feature.work.impl

import android.app.Application
import androidx.work.WorkManager
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import io.github.fornewid.core.kotlin.AppScope
import javax.inject.Singleton

@Module
@ContributesTo(AppScope::class)
object WorkModule {

    @Singleton
    @Provides
    fun providesWorkManager(
        application: Application,
    ): WorkManager {
        return WorkManager.getInstance(application)
    }
}
