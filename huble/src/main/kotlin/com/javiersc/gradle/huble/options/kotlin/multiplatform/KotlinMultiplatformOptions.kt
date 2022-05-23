package com.javiersc.gradle.huble.options.kotlin.multiplatform

import com.javiersc.gradle.huble.internal.features.Kotlin
import com.javiersc.gradle.huble.internal.features.featureCache
import javax.inject.Inject
import org.gradle.api.Action
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.property

public abstract class KotlinMultiplatformOptions @Inject constructor(objects: ObjectFactory) {

    init {
        featureCache.put(Kotlin.Multiplatform())
    }

    public val android: Property<KotlinMultiplatformAndroidOptions> = objects.property()

    public val jvm: Property<KotlinMultiplatformJvmOptions> = objects.property()

    public fun all(vararg exclude: String) {
        if ("android" !in exclude) android(action = {})
        if ("jvm" !in exclude) jvm(action = {})
    }

    public fun android(action: Action<in KotlinMultiplatformAndroidOptions>) {
        android.get().isEnabled.set(true)
        action.execute(android.get())
    }

    public fun jvm(action: Action<in KotlinMultiplatformJvmOptions>) {
        jvm.get().isEnabled.set(true)
        action.execute(jvm.get())
    }
}
