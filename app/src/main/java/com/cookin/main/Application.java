package com.cookin.main;

import android.support.multidex.MultiDexApplication;

import com.cookin.app.R;

import com.amazonaws.mobile.AWSMobileClient;
import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Anders on 13/07/2017.
 */

public class Application extends MultiDexApplication {


    @Override
    public void onCreate() {
        super.onCreate();

        AWSMobileClient.initializeMobileClientIfNecessary(getApplicationContext());
        Fabric.with(this, new Crashlytics());

        CalligraphyConfig.initDefault(
                new CalligraphyConfig.Builder()
                        .setDefaultFontPath("Academy-Sans.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build());
    }
}
