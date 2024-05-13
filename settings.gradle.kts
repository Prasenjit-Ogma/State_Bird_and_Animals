pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral() // Warning: this repository is going to shut down soon
        maven { url = uri("https://jitpack.io")}
    }
}

rootProject.name = "State Bird and Animals"
include(":app")
 