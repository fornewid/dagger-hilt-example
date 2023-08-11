package io.github.fornewid.dagger.hilt.example

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import dagger.hilt.android.AndroidEntryPoint
import io.github.fornewid.dagger.hilt.example.databinding.ExampleActivityBinding
import io.github.fornewid.feature.bar.BarNavigator
import io.github.fornewid.feature.foo.FooNavigator
import io.github.fornewid.feature.navigation.compose.ExampleNavigationComposeActivity
import io.github.fornewid.feature.navigation.fragment.ExampleNavigationFragmentActivity
import javax.inject.Inject

@AndroidEntryPoint
class ExampleActivity : FragmentActivity() {

    @Inject
    lateinit var fooNavigator: FooNavigator

    @Inject
    lateinit var barNavigator: BarNavigator

    private val viewModel: ExampleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
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
    }
}
