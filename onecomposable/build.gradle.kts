plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
}

android {
    namespace = "com.mightysana.onecomposable"
    compileSdk = 35  // Updated compileSdk to 35

    defaultConfig {
        minSdk = 29
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
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = "21"
    }
}

dependencies {
    val composeBom = platform("androidx.compose:compose-bom:2024.09.03")
    implementation(composeBom)

    implementation(libs.androidx.material3)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.material.icons.core)
    implementation(libs.androidx.material.icons.extended)
    implementation(libs.androidx.adaptive)

    implementation(libs.androidx.ui.tooling.preview)
    debugImplementation(libs.androidx.ui.tooling)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.github.andreasmlbngaol"
                artifactId = "onecomposable"
                version = "1.0"

                // Artifact configurations to ensure all required files are published
                artifact("$buildDir/outputs/aar/${artifactId}-release.aar")
                pom {
                    name.set("OneComposable")
                    description.set("A library for reusable Composable functions")
                    url.set("https://github.com/andreasmlbngaol/OneComposeLibrary")
                    licenses {
                        license {
                            name.set("Apache License 2.0")
                            url.set("http://www.apache.org/licenses/LICENSE-2.0")
                        }
                    }
                    developers {
                        developer {
                            id.set("andreasmlbngaol")
                            name.set("Andreas")
                        }
                    }
                    scm {
                        connection.set("scm:git:github.com/andreasmlbngaol/OneComposeLibrary.git")
                        developerConnection.set("scm:git:ssh://github.com/andreasmlbngaol/OneComposeLibrary.git")
                        url.set("https://github.com/andreasmlbngaol/OneComposeLibrary")
                    }
                }
            }
        }
    }
}
