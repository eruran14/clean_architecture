
import org.gradle.internal.impldep.com.amazonaws.PredefinedClientConfigurations.defaultConfig

plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
}

android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        applicationId = "com.eru.clean_architecture"
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation (Dependencies.UI.androidCore)
    implementation (Dependencies.UI.androidAppCompat)
    implementation (Dependencies.UI.androidMaterial)
    implementation (Dependencies.UI.constraintLayout)
    testImplementation (Dependencies.UI.jUnit)
    androidTestImplementation (Dependencies.UI.androidJUnit)
    androidTestImplementation (Dependencies.UI.espresso)
    implementation (Dependencies.UI.androidFragment)

    implementation (Dependencies.Room.runtime)
    implementation (Dependencies.Room.room)
    kapt (Dependencies.Room.compiler)

    //Dagger Hilt
    implementation (Dependencies.DaggerHilt.daggerHilt)
    kapt (Dependencies.DaggerHilt.daggerHilt)

    //Coroutines
    implementation(Dependencies.Coroutines.coroutines)
    implementation(Dependencies.Coroutines.core)

    //Navigation
    implementation(Dependencies.NavComponent.fragment)
    implementation(Dependencies.NavComponent.ui)

    //Lifecycle
    implementation (Dependencies.LifeCycle.viewModel)
    implementation (Dependencies.LifeCycle.runTime)

    //ViewBindingDelegate
    implementation (Dependencies.ViewBindingDelegate.viewBindingDelegate)

}