package com.example;

import android.app.Application;
import android.content.Context;

import com.crashlytics.android.Crashlytics;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import java.lang.ref.WeakReference;

import io.fabric.sdk.android.Fabric;

public class App extends Application {
    static WeakReference<App> instance;
    RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }

        AppDeps.init(this);
        setUpCrashlytics();

        refWatcher = setUpLeakCanary();
        instance = new WeakReference<>(this);
    }

    public static Context getContext() {
        return instance.get().getApplicationContext();
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public static RefWatcher getRefWatcher(Context context) {
        return ((App) context.getApplicationContext()).refWatcher;
    }

    protected void setUpCrashlytics() {
        if (BuildConfig.DEBUG) {
            return;
        }

        Fabric.with(this, new Crashlytics());
    }

    protected RefWatcher setUpLeakCanary() {
        return RefWatcher.DISABLED;
    }
}
