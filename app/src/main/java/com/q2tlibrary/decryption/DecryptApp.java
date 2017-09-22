package com.q2tlibrary.decryption;

import android.app.Application;
import android.content.Context;

/**
 * Created by aksha_000 on 12/5/2015.
 */
public class DecryptApp extends Application {
    private static final String TAG = DecryptApp.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        NetworkManager.init(getApplicationContext());
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
