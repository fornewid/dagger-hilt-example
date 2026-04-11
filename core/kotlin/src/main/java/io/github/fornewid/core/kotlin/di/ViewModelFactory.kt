package io.github.fornewid.core.kotlin.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

/**
 * A generic ViewModelProvider.Factory that creates ViewModels from
 * a Dagger multi-binding map.
 *
 * Replaces Hilt's @HiltViewModel mechanism.
 * Each ViewModel is contributed via @IntoMap + @ViewModelKey.
 */
class ViewModelFactory @Inject constructor(
    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = creators[modelClass]
            ?: creators.entries.firstOrNull { modelClass.isAssignableFrom(it.key) }?.value
            ?: throw IllegalArgumentException("Unknown ViewModel class: $modelClass")
        @Suppress("UNCHECKED_CAST")
        return creator.get() as T
    }
}
