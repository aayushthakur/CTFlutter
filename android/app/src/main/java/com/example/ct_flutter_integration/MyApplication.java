package com.example.ct_flutter_integration;

import com.clevertap.android.sdk.ActivityLifecycleCallback;
import com.clevertap.android.sdk.CleverTapAPI;

import io.flutter.app.FlutterApplication;

public class MyApplication extends FlutterApplication {
    @java.lang.Override
    public void onCreate() {
        CleverTapAPI.setDebugLevel(3);
//        TemplateRenderer.setDebugLevel(3);
//        CleverTapAPI.setNotificationHandler(new PushTemplateNotificationHandler());
        ActivityLifecycleCallback.register(this); //<--- Add this before super.onCreate()
        super.onCreate();
    }
}
