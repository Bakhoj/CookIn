package main;

import com.cookin.app.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Anders on 13/07/2017.
 */

public class Application extends android.app.Application {


    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(
                new CalligraphyConfig.Builder()
                        .setDefaultFontPath("Academy-Sans.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build());
    }
}
