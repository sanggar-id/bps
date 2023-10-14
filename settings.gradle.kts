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
        mavenCentral()
    }

    versionCatalogs {
        create("libs") {
            from(files("libs.dependencies.toml"))
        }
    }
}

rootProject.name = "Catatan Berita"
include(":app")
include(":features:splash-screen")
include(":features:home")
include(":libraries:utils")
