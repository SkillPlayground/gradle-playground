import com.javiersc.gradle.huble.HubleExtension
import com.javiersc.gradle.huble.internal.features.featureCache
import org.gradle.api.Project
import org.gradle.kotlin.dsl.the

public fun Project.huble(configure: HubleExtension.() -> Unit) {
    configure(the())

    for (feature in featureCache.features) {
        if (feature.isEnabled.get()) feature.configure(project)
    }
}
