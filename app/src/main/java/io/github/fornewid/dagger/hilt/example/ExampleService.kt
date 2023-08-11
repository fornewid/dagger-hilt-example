package io.github.fornewid.dagger.hilt.example

import android.app.Service
import android.content.Intent
import android.os.IBinder
import dagger.hilt.android.AndroidEntryPoint
import io.github.fornewid.feature.bar.Bar
import javax.inject.Inject

@AndroidEntryPoint
class ExampleService : Service() {

    @Inject
    lateinit var bar: Bar

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        bar.toString()
        return super.onStartCommand(intent, flags, startId)
    }
}


