package com.example.startedproject

import android.content.res.Resources
import android.os.Build
import android.util.Log
import kotlin.math.round

actual class Platform {
    actual val oSName: String
        get() = "Android"
    actual val oSVersion: String
        get() = "${Build.VERSION.SDK_INT}"
    actual val deviceModel: String
        get() = "${Build.MANUFACTURER} ${Build.MODEL}"
    actual val density: Int
        get() = round(Resources.getSystem().displayMetrics.density).toInt()

    actual fun logSystemInfo() {
        Log.d(
            "Daily Pulse",
            "($oSName, $oSVersion, $deviceModel, $density)"
        )
    }
}