plugins {
    alias(libs.plugins.kotlinMultiplatform)
}

group = "com.github.felixdes"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    val hostOs = System.getProperty("os.name")
    val isArm64 = System.getProperty("os.arch") == "aarch64"
    val nativeTarget = when {
        hostOs == "Linux" && !isArm64 -> linuxX64("native")
        else -> throw GradleException("Targets on Linux only")
    }

    nativeTarget.apply {
        binaries {
            executable {
                entryPoint = "main"
            }
        }
    }
}