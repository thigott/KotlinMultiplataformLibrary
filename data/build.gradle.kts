plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("kotlinx-serialization")
    id("com.squareup.sqldelight")
}

version = "1.0.0"

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Kotlin Multiplataform Library Data module"
        homepage = "Data: homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "data"
        }
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.bundles.koin)
                implementation(libs.bundles.ktor)
                api(project(":domain"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.bundles.ktorAndroid)
                implementation(libs.sqldelightAndroid)
            }
        }
        val androidUnitTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(libs.ktorIOSClient)
                implementation(libs.sqldelightIOS)
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

dependencies {
    api(project(":domain"))
}

sqldelight {
    database("KmmLibraryDatabase") {
        packageName = "com.thigott.kotlinmultiplataformlibrary.database"
        sourceFolders = listOf("sqldelight")
    }
}

android {
    namespace = "com.thigott.kotlinmultiplataformlibrary.data"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}