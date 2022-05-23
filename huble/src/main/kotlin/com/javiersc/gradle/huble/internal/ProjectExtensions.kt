package com.javiersc.gradle.huble.internal

import com.javiersc.gradle.huble.HubleExtension
import org.gradle.api.Project
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.newInstance
import org.gradle.kotlin.dsl.property
import org.gradle.kotlin.dsl.the

internal inline fun <reified T> ObjectFactory.buildOptionsProperty(): Property<T> =
    property<T>().convention(newInstance<T>())

internal fun Project.playgroundExtension(): HubleExtension = the()
