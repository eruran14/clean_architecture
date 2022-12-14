object Versions {
    const val androidCore = "1.7.0"
    const val androidAppCompat = "1.5.1"
    const val androidMaterial = "1.7.0"
    const val constraintLayout = "2.1.4"
    const val androidFragment = "1.5.4"
    const val jUnit = "4.13.2"
    const val androidJUnit = "1.1.4"
    const val espresso = "3.5.0"
    const val room = "2.4.3"
    const val AGP = "7.3.0"
    const val kotlin = "1.6.10"
    const val daggerHilt = "2.44.2"
    const val coroutines = "1.6.4"
    const val navComponent = "2.5.3"
    const val lifeCycle = "2.5.1"
}

object Dependencies {
    object UI {
        const val androidCore = "androidx.core:core-ktx:${Versions.androidCore}"
        const val androidAppCompat = "androidx.appcompat:appcompat:${Versions.androidAppCompat}"
        const val androidMaterial = "com.google.android.material:material:${Versions.androidMaterial}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val androidFragment = "androidx.fragment:fragment-ktx:${Versions.androidFragment}"
        const val jUnit = "junit:junit:${Versions.jUnit}"
        const val androidJUnit = "androidx.test.ext:junit:${Versions.androidJUnit}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:${Versions.room}"
        const val room = "androidx.room:room-ktx:${Versions.room}"
        const val compiler = "ndroidx.room:room-compiler:${Versions.room}"
    }

    object DaggerHilt{
        const val daggerHilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
        const val daggerCompiler = "com.google.dagger:hilt-compiler:${Versions.daggerHilt}"
    }

    object Coroutines{
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    }

    object NavComponent {
        const val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navComponent}"
        const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navComponent}"
    }

    object LifeCycle {
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycle}"
        const val runTime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycle}"
    }

    object ViewBindingDelegate{
        const val viewBindingDelegate = "implementation 'com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.6"
    }

}

object Plugins {

    object AGP{
        const val application = "com.android.application"
        const val library = "com.android.library"
    }

    object Kotlin {
        const val kotlin = "org.jetbrains.kotlin.android"
    }

    object DaggerHilt{
        const val hilt = "com.google.dagger.hilt.android"
    }
}