package com.ginzo.flickrgallery

object Libs {
  object kotlin {
    val kotlinVersion = "1.3.50"

    val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"

    object coroutines {
      val version = "1.3.2"

      val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
      val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
      val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object gradle {
      val core = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
      val allopen = "org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion"
    }
  }

  val coreKtx = "androidx.core:core-ktx:1.0.2"

  val constrainLayout = "androidx.constraintlayout:constraintlayout:1.1.3"

  val material = "com.google.android.material:material:1.0.0"

  object androidx {
    val appCompat = "androidx.appcompat:appcompat:1.0.2"
    val lifecycle = "androidx.lifecycle:lifecycle-common-java8:2.0.0"
    val recyclerview = "androidx.recyclerview:recyclerview:1.0.0"

    object test {
      private const val version = "1.2.0"

      const val core = "androidx.test:core:$version"
      const val rules = "androidx.test:rules:$version"

      object espresso {
        private const val version = "3.2.0"

        const val core = "androidx.test.espresso:espresso-core:$version"
        const val contrib = "androidx.test.espresso:espresso-contrib:$version"
        const val intents = "androidx.test.espresso:espresso-intents:$version"
      }
    }
  }

  const val junit = "junit:junit:4.12"

  object mockito {
    private val version = "2.23.0"

    val core = "org.mockito:mockito-core:$version"
    val inline = "org.mockito:mockito-inline:$version"
    val android = "org.mockito:mockito-android:$version"
  }

}

object Conf {
  const val compileSdkVersion = 28
  const val targetSdkVersion = 28
  const val minSdkVersion = 21
}