import Versions.apolloVersion
import Versions.daggerVersion
import Versions.kotlinVersion
import org.gradle.api.artifacts.dsl.DependencyHandler

object Versions {
    const val kotlinVersion = "1.5.10"
    const val apolloVersion = "2.5.9"
    const val daggerVersion = "2.37"
}

object Libs {

    object Kotlin {
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion"
    }

    object Plugin {
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        const val androidGradlePlugin = "com.android.tools.build:gradle:7.1.0-alpha02"
        const val apolloGradlePlugin = "com.apollographql.apollo:apollo-gradle-plugin:$apolloVersion"
        const val hilt = "com.google.dagger:hilt-android-gradle-plugin:$daggerVersion"
    }

    object Common {
        const val timber = "com.jakewharton.timber:timber:4.7.1"
    }

    object Fresco {
        private const val version = "2.5.0"
        const val fresco = "com.facebook.fresco:fresco:$version"
        const val fresco_gif = "com.facebook.fresco:animated-gif:$version"
    }

    object Android {
        const val core = "androidx.core:core-ktx:1.7.0-alpha01"
        const val appCompat = "androidx.appcompat:appcompat:1.3.0"
        const val fragment = "androidx.fragment:fragment-ktx:1.3.4"
    }

    object Material {
        const val material = "com.google.android.material:material:1.4.0"
    }

    object Navigation {
        const val navigation = "androidx.navigation:navigation-fragment-ktx:2.3.5"
        const val navigationKtx = "androidx.navigation:navigation-ui-ktx:2.3.5"
    }

    object Coroutines {
        private const val version = "1.5.1"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object Dagger {
        const val hilt = "com.google.dagger:hilt-android:$daggerVersion"
        const val navigation = "androidx.hilt:hilt-navigation-fragment:1.0.0"
        const val processor = "com.google.dagger:hilt-android-compiler:$daggerVersion"
        const val jetpackProcessor = "androidx.hilt:hilt-compiler:1.0.0"
        const val jetpack = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
        const val work = "androidx.hilt:hilt-work:1.0.0"
    }

    object Retrofit {
        private const val version = "2.7.2"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
    }

    object OkHttp {
        private const val version = "4.5.0"
        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Epoxy {
        private const val version = "4.6.3"
        const val epoxy = "com.airbnb.android:epoxy:$version"
        const val paging = "com.airbnb.android:epoxy-paging:$version"
        const val paging3 = "com.airbnb.android:epoxy-paging3:$version"
        const val paging3Runtime = "androidx.paging:paging-runtime:3.0.0-rc01"
        const val dataBinding = "com.airbnb.android:epoxy-databinding:$version"
        const val processor = "com.airbnb.android:epoxy-processor:$version"
    }

    object Apollo {
        const val runtime = "com.apollographql.apollo:apollo-runtime:$apolloVersion"
        const val sqlite = "com.apollographql.apollo:apollo-normalized-cache-sqlite:$apolloVersion"
        const val coroutines = "com.apollographql.apollo:apollo-coroutines-support:$apolloVersion"
        const val annotations = "org.jetbrains:annotations:13.0"
    }

    object Lifecycle {
        private const val version = "2.4.0-alpha02"
        const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
    }

    object Room {
        private const val version = "2.4.0-alpha03"
        const val runtime = "androidx.room:room-runtime:$version"
        const val ktx = "androidx.room:room-ktx:$version"
        const val compiler = "androidx.room:room-compiler:$version"
    }

    object Ktx {
        const val core = "androidx.core:core-ktx:1.6.0"
    }

    object WorkManager {
        const val workManager = "androidx.work:work-runtime-ktx:2.3.4"
    }

}

object Dependencies {

    val Processors = listOf(
        Libs.Dagger.processor,
        Libs.Dagger.jetpackProcessor,
        Libs.Room.compiler,
        Libs.Epoxy.processor
    )

    val Feature = listOf(
        Libs.Common.timber,
        Libs.Fresco.fresco,
        Libs.Fresco.fresco_gif,
        Libs.Android.core,
        Libs.Android.fragment,
        Libs.Android.appCompat,
        Libs.Material.material,
        Libs.Navigation.navigation,
        Libs.Navigation.navigationKtx,
        Libs.Coroutines.core,
        Libs.Coroutines.android,
        Libs.Dagger.hilt,
        Libs.Dagger.jetpack,
        Libs.Dagger.navigation,
        Libs.Dagger.work,
        Libs.Retrofit.retrofit,
        Libs.Retrofit.gsonConverter,
        Libs.OkHttp.okhttp,
        Libs.OkHttp.loggingInterceptor,
        Libs.Epoxy.epoxy,
        Libs.Epoxy.paging,
        Libs.Epoxy.paging3,
        Libs.Epoxy.paging3Runtime,
        Libs.Epoxy.dataBinding,
        Libs.Apollo.runtime,
        Libs.Apollo.sqlite,
        Libs.Apollo.coroutines,
        Libs.Lifecycle.livedata,
        Libs.Lifecycle.runtime,
        Libs.Lifecycle.viewModel,
        Libs.Room.runtime,
        Libs.Room.ktx,
        Libs.Ktx.core,
        Libs.WorkManager.workManager
    )

}

fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementations(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.testCompileOnlys(list: List<String>) {
    list.forEach { dependency ->
        add("testCompileOnly", dependency)
    }
}

fun DependencyHandler.compileOnlys(list: List<String>) {
    list.forEach { dependency ->
        add("compileOnly", dependency)
    }
}

fun DependencyHandler.testImplementations(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}


