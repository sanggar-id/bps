apply(from = "${rootProject.projectDir}/common.library.gradle")

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.isfa.utils"
}

dependencies {}