import dependencies.Versions
import dependencies.Deps

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android-extensions")
}
group = "com.example.myfirstkmmsample"
version = "1.0-SNAPSHOT"

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
}
dependencies {
    implementation(project(":shared"))
    implementation(Deps.AndroidX.design)
    implementation(Deps.AndroidX.appCompat)
    implementation(Deps.AndroidX.constraintLayout)
    implementation(Deps.AndroidX.Ktx.fragment)
    implementation(Deps.AndroidX.Ktx.activity)
    implementation(Deps.AndroidX.Ktx.core)
    implementation(Deps.Kotlin.androidCoroutinesDispatcher)
    implementation(Deps.Coil.coil)
}
android {
    compileSdkVersion(Versions.androidCompileSdkVersion)
    defaultConfig {
        applicationId = "com.example.myfirstkmmsample.androidApp"
        minSdkVersion(Versions.androidMinSdkVersion)
        targetSdkVersion(Versions.androidTargetSdkVersion)
        versionCode = 1
        versionName = "1.0"
    }
    
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}