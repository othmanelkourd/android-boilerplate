package br.com.vitorsalgado.example

import com.squareup.leakcanary.RefWatcher

class TestApp : App() {
  override fun enableLeakCanary(): RefWatcher {
    return RefWatcher.DISABLED
  }
}
