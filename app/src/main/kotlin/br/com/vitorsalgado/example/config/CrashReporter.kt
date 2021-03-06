package br.com.vitorsalgado.example.config

import android.content.Context
import br.com.vitorsalgado.example.BuildConfig
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import io.fabric.sdk.android.Fabric

object CrashReporter {
  fun setup(context: Context) =
    Fabric.with(
      context, Crashlytics.Builder()
        .core(CrashlyticsCore.Builder().disabled(BuildConfig.DEBUG).build())
        .build()
    )
}
