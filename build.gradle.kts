import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {

    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(Libs.Plugin.kotlinGradlePlugin)
        classpath(Libs.Plugin.androidGradlePlugin)
        classpath(Libs.Plugin.apolloGradlePlugin)
        classpath(Libs.Plugin.hilt)
    }

}

allprojects {
    repositories {
        google()
        jcenter()
        maven("https://jitpack.io")
        maven("https://dl.bintray.com/kotlin/kotlin-eap")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
    }
}