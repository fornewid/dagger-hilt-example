package io.github.fornewid.dagger.hilt.example

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import dagger.hilt.android.AndroidEntryPoint
import io.github.fornewid.feature.bar.Bar
import javax.inject.Inject

@AndroidEntryPoint
class ExampleBroadcastReceiver : BroadcastReceiver() {

    @Inject
    lateinit var bar: Bar

    override fun onReceive(context: Context, intent: Intent) {
        bar.toString()
    }
}

