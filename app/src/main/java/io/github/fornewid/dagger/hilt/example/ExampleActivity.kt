package io.github.fornewid.dagger.hilt.example

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import io.github.fornewid.core.kotlin.di.activityRetainedComponent
import io.github.fornewid.dagger.hilt.example.databinding.ExampleActivityBinding
import io.github.fornewid.feature.bar.BarNavigator
import io.github.fornewid.feature.foo.FooNavigator
import javax.inject.Inject

class ExampleActivity : AppCompatActivity() {

    @Inject
    lateinit var fooNavigator: FooNavigator

    @Inject
    lateinit var barNavigator: BarNavigator

    private val viewModel: ExampleViewModel by viewModels {
        activityRetainedComponent.viewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as ExampleApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        val binding = ExampleActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.doSomething()

        binding.foo.setOnClickListener {
            startActivity(fooNavigator.createIntent(this))
        }
        binding.bar.setOnClickListener {
            startActivity(barNavigator.createIntent(this))
        }
    }
}
