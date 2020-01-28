package com.science.app.sciencelab;

import android.app.Application;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.Locale;

public class App extends Application {
    @Override
    public void onCreate() {
        Resources res = getResources();
        // Change locale settings in the app.
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale("ar".toLowerCase())); // API 17+ only.
        // Use conf.locale = new Locale(...) if targeting lower versions
        res.updateConfiguration(conf, dm);
        super.onCreate();
    }
}
