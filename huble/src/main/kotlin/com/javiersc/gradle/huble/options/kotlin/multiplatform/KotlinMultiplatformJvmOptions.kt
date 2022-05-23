package com.javiersc.gradle.huble.options.kotlin.multiplatform

import com.javiersc.gradle.huble.internal.features.Kotlin
import com.javiersc.gradle.huble.internal.propertyConvention
import com.javiersc.gradle.huble.options.kotlin.KotlinOptions
import javax.inject.Inject
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property

public abstract class KotlinMultiplatformJvmOptions
@Inject
constructor(
    objects: ObjectFactory,
) : KotlinOptions(objects) {
    public val isEnabled: Property<Boolean> = objects.propertyConvention(false)

    public val name: Property<String> =
        objects.propertyConvention(Kotlin.Multiplatform.DefaultJvmName)
}
