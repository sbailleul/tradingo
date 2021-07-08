rootProject.name = "tradingo"
include("education-manager")
include("common")
include("membership-manager")
include("market-manager")


pluginManagement {
    val kotlinVersion: String by settings
    val springBootVersion: String by settings
    val springDependencyManagement: String by settings
    val lombokVersion: String by settings
    println(kotlinVersion)
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "org.jetbrains.kotlin.jvm" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.spring" -> useVersion(kotlinVersion)
                "org.springframework.boot" -> useVersion(springBootVersion)
                "io.freefair.lombok" -> useVersion(lombokVersion)
                "org.jetbrains.kotlin.plugin.lombok" -> useVersion(kotlinVersion)
                "io.spring.dependency-management" -> useVersion(springDependencyManagement)
            }
        }
    }
}
include("generic-client")
