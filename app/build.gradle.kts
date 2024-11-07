



plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.scrollless"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.scrollless"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    implementation("com.android.tools:desugar_jdk_libs:2.0.4")
    implementation("com.badlogicgames.gdx:gdx-backend-android:1.13.0")
    //implementation(project(":core"))

    // Natives with platform specific variants
    val platforms = listOf("arm64-v8a", "armeabi-v7a", "x86", "x86_64")
    platforms.forEach { platform ->
        implementation("com.badlogicgames.gdx:gdx-platform:1.13.0:natives-$platform")
    }
    // https://mvnrepository.com/artifact/com.badlogicgames.gdx/gdx
    implementation("com.badlogicgames.gdx:gdx:1.13.0")
    // https://mvnrepository.com/artifact/com.badlogicgames.gdx/gdx-platform
    //testImplementation("com.badlogicgames.gdx:gdx-platform:1.13.0")
    // https://mvnrepository.com/artifact/com.badlogicgames.gdx/gdx-backend-android
    //implementation("com.badlogicgames.gdx:gdx-backend-android:1.13.0")

}