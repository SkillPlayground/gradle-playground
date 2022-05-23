package com.javiersc.gradle.huble.internal.features

import androidLibrary
import com.javiersc.gradle.huble.internal.playgroundExtension
import com.javiersc.gradle.huble.internal.singletonPropertyConvention
import com.javiersc.gradle.huble.options.android.AndroidLibraryOptions
import com.javiersc.gradle.huble.options.kotlin.jvm.KotlinJvmOptions
import com.javiersc.gradle.huble.options.kotlin.multiplatform.KotlinMultiplatformAndroidOptions
import com.javiersc.gradle.huble.options.kotlin.multiplatform.KotlinMultiplatformJvmOptions
import com.javiersc.gradle.huble.options.kotlin.multiplatform.KotlinMultiplatformOptions
import kotlin
import org.gradle.api.Project
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// context(Project)
internal sealed class Feature(
    val isEnabled: Property<Boolean> = singletonPropertyConvention(false)
) {

    abstract fun configure(project: Project)

    abstract fun compatible(features: ListProperty<Feature>): Boolean
}

internal sealed class Android : Feature() {

    internal class Library : Android() {

        override fun configure(project: Project) {
            val options: Property<AndroidLibraryOptions> =
                project.playgroundExtension().androidLibrary
            project.pluginManager.apply("com.android.library")
            project.androidLibrary {
                compileSdk = options.flatMap(AndroidLibraryOptions::compileSdk).get()
                defaultConfig.minSdk = options.flatMap(AndroidLibraryOptions::minSdk).get()
            }
        }

        override fun compatible(features: ListProperty<Feature>): Boolean =
            !features.get().isKotlinEnabled
    }

    internal class Application : Android() {

        override fun configure(project: Project) {
            TODO()
        }

        override fun compatible(features: ListProperty<Feature>): Boolean =
            !features.get().isKotlinEnabled
    }

    companion object {
        const val DefaultMinSdk = 21
        const val DefaultCompileSdk = 31
    }
}

internal sealed class Kotlin : Feature() {

    internal class JVM : Kotlin() {

        override fun configure(project: Project) {
            val options: Property<KotlinJvmOptions> = project.playgroundExtension().kotlinJVM
            project.pluginManager.apply("org.jetbrains.kotlin.jvm")
            project.tasks.withType<KotlinCompile>().all {
                kotlinOptions.jvmTarget = options.flatMap(KotlinJvmOptions::target).get()
            }
        }

        override fun compatible(features: ListProperty<Feature>): Boolean =
            !features.get().isAndroidEnabled
    }

    internal class Multiplatform : Kotlin() {

        override fun configure(project: Project) {
            val options: Property<KotlinMultiplatformOptions> =
                project.playgroundExtension().kotlinMultiplatform
            project.pluginManager.apply("org.jetbrains.kotlin.multiplatform")
            project.tasks.withType<KotlinCompile>().all {
                kotlinOptions.jvmTarget =
                    options
                        .flatMap(KotlinMultiplatformOptions::jvm)
                        .flatMap(KotlinMultiplatformJvmOptions::target)
                        .get()
            }

            if (options
                    .flatMap(KotlinMultiplatformOptions::android)
                    .flatMap(KotlinMultiplatformAndroidOptions::isEnabled)
                    .get()
            ) {
                project.kotlin { android() }
            }
            if (options
                    .flatMap(KotlinMultiplatformOptions::jvm)
                    .flatMap(KotlinMultiplatformJvmOptions::isEnabled)
                    .get()
            ) {
                project.kotlin { jvm() }
            }
        }

        override fun compatible(features: ListProperty<Feature>): Boolean =
            !features.get().isAndroidApplicationEnabled

        companion object {
            const val DefaultJvmName = "jvm"
        }
    }

    companion object {
        const val DefaultJvmTarget = "1.8"
    }
}
