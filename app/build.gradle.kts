plugins {

        id("com.android.application")
        id("org.jetbrains.kotlin.android")
        id("com.google.gms.google-services") // 👈 Important for Firebase

}

android {
    {
        // This whole block should be there!
        signingConfigs {
            create("debug") {
                storeFile = file("debug.keystore")
                storePassword = "android"
                keyAlias = "androiddebugkey"
                keyPassword = "android"
            }
        }
    }
    namespace = "com.example.smarthealthapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.smarthealthapp"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"  // ✅ THIS FIXES KeyboardOptions!
    }
}

dependencies {

    // Compose BOM (replaces individual version numbers)
    implementation("androidx.compose:compose-bom:2023.10.01")

    // Compose
    implementation("androidx.compose.ui:ui:1.5.4")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation ("androidx.compose.ui:ui-text:1.5.4")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.compose.material3:material3:1.1.2")
    implementation ("androidx.compose.material:material:1.5.4")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("androidx.compose.foundation:foundation")


    //Navigation
    implementation("androidx.navigation:navigation-compose:2.7.7")

    // Tooling for preview and testing
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    testImplementation("junit:junit:4.13.2")

    // Firebase Auth
    implementation(platform("com.google.firebase:firebase-bom:32.2.0"))
    implementation("com.google.firebase:firebase-auth-ktx")

    // Google Sign-In
    implementation("com.google.android.gms:play-services-auth:20.7.0")

    // Google Fit
    implementation("com.google.android.gms:play-services-fitness:21.0.1")

    // TensorFlow Lite (if using AI model later)
    implementation("org.tensorflow:tensorflow-lite:2.13.0")
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
}