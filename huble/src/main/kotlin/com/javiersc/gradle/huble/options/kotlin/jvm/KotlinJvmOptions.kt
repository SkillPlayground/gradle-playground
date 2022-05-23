package com.javiersc.gradle.huble.options.kotlin.jvm

import com.javiersc.gradle.huble.internal.features.Kotlin
import com.javiersc.gradle.huble.internal.features.featureCache
import com.javiersc.gradle.huble.options.kotlin.KotlinOptions
import javax.inject.Inject
import org.gradle.api.model.ObjectFactory

public abstract class KotlinJvmOptions
@Inject
constructor(
    objects: ObjectFactory,
) : KotlinOptions(objects) {

    init {
        featureCache.put(Kotlin.JVM())
    }
}
