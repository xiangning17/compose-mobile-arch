import org.gradle.api.Project

/**
 * Author: xiangning
 * Date: 2023/7/23 10:21
 * Description: 版本管理
 */

class Versions private constructor(project: Project) {

    private val properties: MutableMap<String, Any?>

    companion object {

        private var instance: Versions? = null

        fun getVersions(project: Project): Versions {
            if (instance != null) {
                return instance!!
            }

            instance = Versions(project)
            return instance!!
        }

        private fun getVersionFromProperty(key: String): String = instance?.properties?.get(key) as? String ?: ""
    }

    init {
        properties = project.properties.toMutableMap()
        properties.putAll(project.extensions.extraProperties.properties ?: emptyMap())
    }

    class Android internal constructor() {
        val agp by lazy { getVersionFromProperty("agp.version") }
        val minSdk by lazy { getVersionFromProperty("android.minSdk") }
        val targetSdk by lazy { getVersionFromProperty("android.targetSdk") }
        val compileSdk by lazy { getVersionFromProperty("android.compileSdk") }
        val androidx = AndroidX

        object AndroidX {
            const val activity = "1.7.2"
            const val appcompat = "1.6.1"
            const val core = "1.10.1"
        }
    }
    val android = Versions.Android()

    val kotlin by lazy { getVersionFromProperty("kotlin.version") }
    val compose by lazy { getVersionFromProperty("compose.version") }

    val mokeResource = "0.23.0"
    val mokeGraphic = "0.9.0"

}

val Project.versions: Versions
    get() = Versions.getVersions(this)