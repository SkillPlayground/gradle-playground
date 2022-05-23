import com.android.build.gradle.LibraryExtension

plugins {
    id("com.javiersc.huble")
}

huble {
    androidLibrary {
        minSdk.set(23)
        compileSdk.set(28)
    }
//    kotlinMultiplatform {
//        android {
//            compileSdk.set(26)
//            minSdk.set(14)
//        }
//        jvm()
//    }
}

println("HELLLLLLLLLLLO")

println(the<LibraryExtension>().defaultConfig.minSdk)

println(the<LibraryExtension>().compileSdk)

//the<KotlinMultiplatformExtension>().sourceSets.forEach { println(it.name) }
