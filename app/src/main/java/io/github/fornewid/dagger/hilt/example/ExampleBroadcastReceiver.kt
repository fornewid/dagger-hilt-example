package io.github.fornewid.dagger.hilt.example

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import io.github.fornewid.feature.bar.Bar
import javax.inject.Inject

class ExampleBroadcastReceiver : BroadcastReceiver() {

    @Inject
    lateinit var bar: Bar

    override fun onReceive(context: Context, intent: Intent) {
        context.appComponent.inject(this)
        bar.toString()
    }
}
