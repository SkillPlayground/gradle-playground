package com.javiersc.gradle.huble.options.kotlin.multiplatform

import com.javiersc.gradle.huble.internal.propertyConvention
import com.javiersc.gradle.huble.options.android.AndroidLibraryOptions
import javax.inject.Inject
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property

public abstract class KotlinMultiplatformAndroidOptions
@Inject
constructor(
    objects: ObjectFactory,
) : AndroidLibraryOptions(objects) {

    public val isEnabled: Property<Boolean> = objects.propertyConvention(false)
}
