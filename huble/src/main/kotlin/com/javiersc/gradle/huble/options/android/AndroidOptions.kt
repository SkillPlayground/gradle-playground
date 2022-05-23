package com.javiersc.gradle.huble.options.android

import com.javiersc.gradle.huble.internal.features.Android
import com.javiersc.gradle.huble.options.Options
import javax.inject.Inject
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.property

public abstract class AndroidOptions
@Inject
constructor(
    objects: ObjectFactory,
) : Options(objects) {

    public val compileSdk: Property<Int> =
        objects.property<Int>().convention(Android.DefaultCompileSdk)

    public val minSdk: Property<Int> = objects.property<Int>().convention(Android.DefaultMinSdk)
}
