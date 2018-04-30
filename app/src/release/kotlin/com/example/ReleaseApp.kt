package com.example

import com.example.configurers.CrashReporter
import com.scottyab.rootbeer.RootBeer
import timber.log.Timber

class ReleaseApp : App() {
  override fun onCreate() {
    super.onCreate()

    Timber.plant(ReleaseTree())
    CrashReporter.setup(this)

    val rootBeer = RootBeer(this)
    if (rootBeer.isRootedWithoutBusyBoxCheck) {
      // device is rooted
    }
  }
}
