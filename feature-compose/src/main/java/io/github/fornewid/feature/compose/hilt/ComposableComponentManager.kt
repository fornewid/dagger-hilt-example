package io.github.fornewid.feature.compose.hilt

import android.content.Context
import android.content.ContextWrapper
import androidx.compose.runtime.CompositionContext
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.internal.Contexts
import dagger.hilt.internal.GeneratedComponentManager

class ComposableComponentManager(
    private val context: Context,
    private val compositionContext: CompositionContext,
) : GeneratedComponentManager<Any> {

    @Volatile
    private var component: Any? = null
    private val componentLock = Any()

    @EntryPoint
    @InstallIn(ActivityComponent::class)
    interface ComposableComponentBuilderEntryPoint {
        fun composableComponentBuilder(): ComposableComponentBuilder
    }

    override fun generatedComponent(): Any {
        if (component == null) {
            synchronized(componentLock) {
                if (component == null) {
                    component = createComponent()
                }
            }
        }
        return component!!
    }

    private fun createComponent(): Any {
        val componentManager: GeneratedComponentManager<*> = getParentComponentManager()
        return EntryPoints.get(componentManager, ComposableComponentBuilderEntryPoint::class.java)
            .composableComponentBuilder()
            .compositionContext(compositionContext)
            .build()
    }

    private fun getParentComponentManager(): GeneratedComponentManager<*> {
        val context = getParentContext(GeneratedComponentManager::class.java)
        if (context is GeneratedComponentManager<*>) {
            return context
        }
        throw IllegalStateException(
            "${compositionContext.javaClass}, Hilt composable must be attached to an @AndroidEntryPoint Fragment or Activity.",
        )
    }

    private fun getParentContext(parentType: Class<*>): Context {
        val context = unwrap(context, parentType)
        if (context === Contexts.getApplication(context.applicationContext)) {
            // If we searched for a type but ended up on the application, just return null
            // as this is never what we are looking for
            throw IllegalStateException(
                "${compositionContext.javaClass}, Hilt composable cannot be created using the application context. "
                        + "Use a Hilt Fragment or Activity context."
            )
        }
        return context
    }

    private fun unwrap(context: Context, target: Class<*>): Context {
        var ctx = context
        while (ctx is ContextWrapper && !target.isInstance(ctx)) {
            ctx = ctx.baseContext
        }
        return ctx
    }
}
