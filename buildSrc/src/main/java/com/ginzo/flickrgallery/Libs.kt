package com.ginzo.flickrgallery

object Libs {
  object kotlin {
    val kotlinVersion = "1.3.50"

    val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"

    object coroutines {
      val version = "1.3.2"

      val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
      val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object gradle {
      val core = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
      val allopen = "org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion"
    }
  }

  val coreKtx = "androidx.core:core-ktx:1.0.2"

  val constrainLayout = "androidx.constraintlayout:constraintlayout:1.1.3"

  object androidx {
    val appCompat = "androidx.appcompat:appcompat:1.0.2"
    val lifecycle = "androidx.lifecycle:lifecycle-common-java8:2.0.0"
  }

  object google {
    val material = "com.google.android.material:material:1.0.0"
  }

  const val junit = "junit:junit:4.12"
}

object Conf {
  const val compileSdkVersion = 28
  const val targetSdkVersion = 28
  const val minSdkVersion = 21
}