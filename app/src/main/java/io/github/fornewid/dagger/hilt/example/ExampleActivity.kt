package io.github.fornewid.dagger.hilt.example

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import io.github.fornewid.core.kotlin.DaggerViewModelFactory
import io.github.fornewid.dagger.hilt.example.databinding.ExampleActivityBinding
import io.github.fornewid.feature.bar.BarNavigator
import io.github.fornewid.feature.compose.bindings.ExampleComposeActivity
import io.github.fornewid.feature.compose.bindings.advanced.AdvancedExampleComposeActivity
import io.github.fornewid.feature.foo.FooNavigator
import io.github.fornewid.feature.navigation.compose.bindings.ExampleNavigationComposeActivity
import io.github.fornewid.feature.navigation.fragment.bindings.ExampleNavigationFragmentActivity
import javax.inject.Inject

class ExampleActivity : AppCompatActivity() {

    @Inject
    lateinit var fooNavigator: FooNavigator

    @Inject
    lateinit var barNavigator: BarNavigator

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory

    private val viewModel: ExampleViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent.inject(this)
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
        binding.navigationFragment.setOnClickListener {
            startActivity(Intent(this, ExampleNavigationFragmentActivity::class.java))
        }
        binding.navigationCompose.setOnClickListener {
            startActivity(Intent(this, ExampleNavigationComposeActivity::class.java))
        }
        binding.composeBasic.setOnClickListener {
            startActivity(Intent(this, ExampleComposeActivity::class.java))
        }
        binding.composeAdvanced.setOnClickListener {
            startActivity(Intent(this, AdvancedExampleComposeActivity::class.java))
        }
    }
}
