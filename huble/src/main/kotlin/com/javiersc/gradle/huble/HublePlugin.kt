package com.javiersc.gradle.huble

import com.javiersc.gradle.huble.internal.ProjectSingleton
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create

public abstract class HublePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        ProjectSingleton.project = target

        target.extensions.create<HubleExtension>("InternalHubleExtension")
    }
}
