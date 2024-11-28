import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.ksp)
}

val apiKeyFile = rootProject.file("apiKey.properties")
val properties = Properties()
properties.load(FileInputStream(apiKeyFile))

android {
    namespace = "dev.brunofelix.pmovie"
    compileSdk = 35

    defaultConfig {
        applicationId = "dev.brunofelix.pmovie"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }

        buildConfigField("String", "API_KEY", properties["API_KEY"].toString())
        buildConfigField("String", "BASE_URL", properties["BASE_URL"].toString())
        buildConfigField("String", "BASE_URL_IMAGE", properties["BASE_URL_IMAGE"].toString())
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    // Kotlin Core
    implementation(libs.androidx.core.ktx)

    // App Compat
    implementation(libs.androidx.appcompat)

    // Material 3
    implementation(libs.material3)

    // Coil
    implementation(libs.coil.compose)

    // Timber
    implementation(libs.timber)

    // DataStore
    implementation(libs.androidx.datastore.preferences)

    // Splash Screen
    implementation(libs.androidx.core.splashscreen)

    // Gson
    implementation(libs.gson)

    // Serialization JSON
    implementation(libs.kotlinx.serialization.json)

    // Jetpack Compose
    implementation(libs.androidx.activity.compose)
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(platform(libs.compose.bom))
    implementation(libs.androidx.material.icons.extended)
    implementation(libs.accompanist.flowlayout)
    implementation(libs.androidx.navigation.compose)

    // Paging3
    implementation(libs.androidx.paging.runtime.ktx)
    implementation(libs.androidx.paging.compose)

    // Coroutine Lifecycle
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.jetbrains.kotlinx.coroutines.core)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    // Hilt
    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    ksp(libs.hilt.compiler)
    ksp(libs.androidx.hilt.compiler)

    // Room
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)

    // Tests
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.ui.test.junit4)
    androidTestImplementation(platform(libs.compose.bom))
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}