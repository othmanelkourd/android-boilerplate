package com.example;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnitRunner;

import com.linkedin.android.testbutler.TestButler;

public class InstrumentationRunner extends AndroidJUnitRunner {
	@Override
	public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return newApplication(InstrumentedApp.class, context);
	}

	@Override
	public void onStart() {
		TestButler.setup(InstrumentationRegistry.getTargetContext());
		super.onStart();
	}

	@Override
	public void finish(int resultCode, Bundle results) {
		TestButler.teardown(InstrumentationRegistry.getTargetContext());
		super.finish(resultCode, results);
	}
}
