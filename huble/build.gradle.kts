plugins {
    `kotlin-dsl`
}

kotlin {
    explicitApi()
}

repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
}

gradlePlugin {
    plugins {
        create("HublePlugin") {
            id = "com.javiersc.huble"
            implementationClass = "com.javiersc.gradle.huble.HublePlugin"
        }
    }
}

dependencies {
    // TODO: remove when the next issue is fixed:
    //  https://github.com/gradle/gradle/issues/15383#issuecomment-779893192
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))

    implementation(libs.android.toolsBuild.gradle)
    implementation(libs.jetbrains.kotlin.kotlinGradlePlugin)
}
