plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.library").version("8.1.0-beta02").apply(false)
    kotlin("multiplatform").version("1.8.10").apply(false)
    id("maven-publish")
    id("org.jetbrains.kotlin.plugin.serialization").version("1.8.21")
}

buildscript {

    dependencies {
        classpath(libs.sqldelightGradlePlugin)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

subprojects {
    apply(plugin = "maven-publish")

    afterEvaluate {
        plugins.withId("com.android.library") {
            publishing {
                publications {
                    register<MavenPublication>("release") {
                        groupId = "com.github.thigott"
                        version = "1.0.0"

                        afterEvaluate {
                            from(components["release"])
                        }
                    }
                }
            }
        }
    }
}
