apply(from = "${rootProject.projectDir}/common.library.gradle")

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.isfa.home"
}

dependencies {
    implementation(project(":libraries:utils"))

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso)
}