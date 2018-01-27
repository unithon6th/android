package kr.unithon.noname;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class DefaultApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        init();
    }

    private void init() {
        initFont();
    }

    private void initFont() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(getString(R.string.font_regular))
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
