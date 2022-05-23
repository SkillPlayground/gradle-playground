import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.the
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal val Project.androidLibrary: LibraryExtension
    get() = the()

internal fun Project.androidLibrary(configure: LibraryExtension.() -> Unit = {}) {
    configure(androidLibrary)
}

internal val Project.androidApp: BaseAppModuleExtension
    get() = the()

internal fun Project.androidApp(configure: BaseAppModuleExtension.() -> Unit = {}) {
    configure(androidApp)
}

internal val Project.kotlin: KotlinMultiplatformExtension
    get() = the()

internal fun Project.kotlin(configure: KotlinMultiplatformExtension.() -> Unit = {}) {
    configure(kotlin)
}
