package com.javiersc.gradle.huble.internal.features

internal inline fun <reified T : Feature> List<Feature>.isEnabled() = any {
    it is T && it.isEnabled.get()
}

internal val List<Feature>.isAndroidEnabled: Boolean
    get() = isEnabled<Android.Library>()

internal val List<Feature>.isAndroidApplicationEnabled: Boolean
    get() = isEnabled<Android.Application>()

internal val List<Feature>.isAndroidLibraryEnabled: Boolean
    get() = isEnabled<Android>()

internal val List<Feature>.isKotlinEnabled: Boolean
    get() = isEnabled<Kotlin>()

internal val List<Feature>.isKotlinJvmEnabled: Boolean
    get() = isEnabled<Kotlin.Multiplatform>()

internal val List<Feature>.isKotlinMultiplatformEnabled: Boolean
    get() = isEnabled<Kotlin.Multiplatform>()
