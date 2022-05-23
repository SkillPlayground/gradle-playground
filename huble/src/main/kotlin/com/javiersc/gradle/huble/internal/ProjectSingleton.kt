package com.javiersc.gradle.huble.internal

import org.gradle.api.Project
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.listProperty
import org.gradle.kotlin.dsl.property

// TODO: This shit should be removed when context receivers are available in Gradle and
//  use `context(Project)` over `Feature` sealed classes and so on.
internal object ProjectSingleton {

    lateinit var project: Project
    val objects: ObjectFactory
        get() = project.objects
}

internal inline fun <reified T> singletonPropertyConvention(value: T) =
    singletonProperty<T>().convention(value)

internal inline fun <reified T> singletonProperty() = ProjectSingleton.objects.property<T>()
