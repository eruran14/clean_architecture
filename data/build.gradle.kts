plugins {
    id(Plugins.AGP.library)
    id(Plugins.Kotlin.kotlin)
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 28
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
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
}

dependencies {

    implementation(Dependencies.UI.androidCore)
    testImplementation(Dependencies.UI.jUnit)
    androidTestImplementation(Dependencies.UI.androidJUnit)

    implementation(Dependencies.DaggerHilt.daggerHilt)
    implementation(Dependencies.DaggerHilt.daggerCompiler)

    implementation(Dependencies.Room.room)
    implementation(Dependencies.Room.compiler)
    implementation(Dependencies.Room.runtime)

    implementation(Dependencies.Coroutines.coroutines)
}