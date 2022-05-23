package com.javiersc.gradle.huble.options.kotlin

import com.javiersc.gradle.huble.internal.features.Kotlin
import com.javiersc.gradle.huble.internal.propertyConvention
import com.javiersc.gradle.huble.options.Options
import javax.inject.Inject
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property

public abstract class KotlinOptions @Inject constructor(objects: ObjectFactory) : Options(objects) {

    public val target: Property<String> = objects.propertyConvention(Kotlin.DefaultJvmTarget)
}
