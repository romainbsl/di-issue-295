package org.kodein.playground

actual class Platform actual constructor() {
    actual fun get(): String = "Android ${android.os.Build.VERSION.SDK_INT}"
}