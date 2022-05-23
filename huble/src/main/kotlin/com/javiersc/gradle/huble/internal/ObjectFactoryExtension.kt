package com.javiersc.gradle.huble.internal

import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.property

internal inline fun <reified T> ObjectFactory.propertyConvention(value: T): Property<T> =
    property<T>().convention(value)
