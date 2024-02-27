package com.example.startedproject

import platform.Foundation.NSLog
import platform.UIKit.UIDevice
import platform.UIKit.UIScreen

actual class Platform {
    actual val oSName: String
        get() = UIDevice.currentDevice.systemName
    actual val oSVersion: String
        get() = UIDevice.currentDevice.systemVersion
    actual val deviceModel: String
        get() = UIDevice.currentDevice.model
    actual val density: Int
        get() = UIScreen.mainScreen.scale.toInt()

    actual fun logSystemInfo() {
        NSLog(
            "($oSName, $oSVersion, $deviceModel, $density)"
        )
    }
}