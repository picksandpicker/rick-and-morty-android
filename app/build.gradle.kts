plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("com.apollographql.apollo")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.rickandmorty.app"
        minSdk = 24
        targetSdk = 31
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

apollo {
    generateKotlinModels.set(true) // or false for Java models
    service("RickAndMorty") {
        schemaPath.set("src/main/graphql/com/rickandmorty/app/schema.json")
        sourceFolder.set(".")
        introspection {
            endpointUrl.set("https://rickandmortyapi.com/graphql")
        }
    }
}

sourceSets.create("main") {
    java.srcDir("${buildDir.absolutePath}/tmp/kapt3/stubs//main/kotlinGenerated/")
}

dependencies {

    implementations(Dependencies.Feature)
    kapt(Dependencies.Processors)
}