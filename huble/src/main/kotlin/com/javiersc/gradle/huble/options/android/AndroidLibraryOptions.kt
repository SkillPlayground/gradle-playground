package com.javiersc.gradle.huble.options.android

import com.javiersc.gradle.huble.internal.features.Android
import com.javiersc.gradle.huble.internal.features.featureCache
import javax.inject.Inject
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.property

public abstract class AndroidLibraryOptions
@Inject
constructor(
    objects: ObjectFactory,
) : AndroidOptions(objects) {

    init {
        featureCache.put(Android.Library())
    }
}
