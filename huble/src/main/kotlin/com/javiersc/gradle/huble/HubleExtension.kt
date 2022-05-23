package com.javiersc.gradle.huble

import com.javiersc.gradle.huble.internal.buildOptionsProperty
import com.javiersc.gradle.huble.internal.features.Android
import com.javiersc.gradle.huble.internal.features.Kotlin
import com.javiersc.gradle.huble.internal.features.featureCache
import com.javiersc.gradle.huble.options.android.AndroidLibraryOptions
import com.javiersc.gradle.huble.options.kotlin.jvm.KotlinJvmOptions
import com.javiersc.gradle.huble.options.kotlin.multiplatform.KotlinMultiplatformOptions
import javax.inject.Inject
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property

public abstract class HubleExtension
@Inject
constructor(
    private val project: Project,
    objects: ObjectFactory,
) {

    public val androidLibrary: Property<AndroidLibraryOptions> = objects.buildOptionsProperty()

    public val kotlinJVM: Property<KotlinJvmOptions> = objects.buildOptionsProperty()

    public val kotlinMultiplatform: Property<KotlinMultiplatformOptions> =
        objects.buildOptionsProperty()

    public fun androidLibrary(action: Action<in AndroidLibraryOptions>) {
        featureCache.get<Android.Library>().isEnabled.set(true)
        action.execute(androidLibrary.get())
    }

    public fun kotlinJVM(action: Action<in KotlinJvmOptions>) {
        featureCache.get<Kotlin.JVM>().isEnabled.set(true)
        action.execute(kotlinJVM.get())
    }

    public fun kotlinMultiplatform(action: Action<in KotlinMultiplatformOptions>) {
        featureCache.get<Kotlin.Multiplatform>().isEnabled.set(true)
        action.execute(kotlinMultiplatform.get())
    }
}
