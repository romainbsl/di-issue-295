package org.kodein.playground

import platform.UIKit.UIDevice

actual class Platform actual constructor() {
    actual fun get(): String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}