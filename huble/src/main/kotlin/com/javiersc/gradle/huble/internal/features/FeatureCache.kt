package com.javiersc.gradle.huble.internal.features

import java.util.LinkedList

internal val featureCache = FeatureCache()

internal class FeatureCache {

    val features: List<Feature>
        get() = _features.toList()
    private val _features: LinkedList<Feature> = LinkedList()

    inline fun <reified T : Feature> get(): T =
        checkNotNull(features.filterIsInstance<T>().firstOrNull()) {
            "Feature ${T::class.simpleName} is missing"
        }

    fun put(feature: Feature) {
        if (feature !in features) _features.add(feature)
    }
}
