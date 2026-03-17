package io.github.fornewid.dagger.hilt.example

import android.content.Intent
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.lifecycleScope
import io.github.fornewid.feature.bar.Bar
import kotlinx.coroutines.launch
import javax.inject.Inject

class ExampleLifecycleService : LifecycleService() {

    @Inject
    lateinit var bar: Bar

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        bar.toString()
        lifecycleScope.launch {
            /* do something */
        }
        return super.onStartCommand(intent, flags, startId)
    }
}
