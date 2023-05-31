package com.example.ct_flutter_integration;

import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;

import com.clevertap.android.sdk.CleverTapAPI;
import com.google.gson.Gson;

import java.util.Objects;

import io.flutter.embedding.android.FlutterActivity;

public class MainActivity extends FlutterActivity {

    @Override
    protected void onNewIntent(@NonNull Intent intent) {
        super.onNewIntent(intent);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (intent.getExtras()!=null){
                Log.d("MainActivity Flutter", "onNewIntent() called with: intent = [" + new Gson().toJson(intent.getExtras()) + "]");
                CleverTapAPI cleverTapAPI = CleverTapAPI.getDefaultInstance(getApplicationContext());
                if (cleverTapAPI != null) {
                    cleverTapAPI.pushNotificationClickedEvent(intent.getExtras());
                }
            }
        }
}
}
