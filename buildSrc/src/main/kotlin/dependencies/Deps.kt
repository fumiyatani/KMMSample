package dependencies

object Deps {
    object Kotlin {
        private const val version = "1.4.1"
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val androidCoroutinesDispatcher = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val coroutinesIosX64 = "org.jetbrains.kotlinx:kotlinx-coroutines-core-iosx64:$version"
        const val coroutinesIosArm64 = "org.jetbrains.kotlinx:kotlinx-coroutines-core-iosarm64:$version"
    }

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:1.2.0"
        const val design =  "com.google.android.material:material:1.2.1"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4"

        object Ktx {
            const val fragment = "androidx.fragment:fragment-ktx:1.2.2"
            const val activity = "androidx.activity:activity-ktx:1.1.0"
            const val core = "androidx.core:core-ktx:1.2.0"
        }
    }

    object Coil {
        const val coil = "io.coil-kt:coil:1.0.0"
    }

    object Ktor {

    }
}