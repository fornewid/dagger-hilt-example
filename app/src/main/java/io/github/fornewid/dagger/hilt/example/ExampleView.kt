package io.github.fornewid.dagger.hilt.example

import android.content.Context
import android.util.AttributeSet
import android.view.View
import dagger.hilt.android.AndroidEntryPoint
import io.github.fornewid.feature.bar.Bar
import javax.inject.Inject

@AndroidEntryPoint
class ExampleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : View(context, attrs, defStyleAttr) {

    @Inject
    lateinit var bar: Bar
}
