package com.creative.twitterlogintesting;

import android.app.Application;
import android.util.Log;

import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;


public class MydApplication extends Application {

    public static final String TAG = MydApplication.class.getSimpleName();

    private static MydApplication mInstance;

    private float scale;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        this.scale = getResources().getDisplayMetrics().density;


        TwitterConfig config = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig("xi1FwgFSyQ9Oi076pGerW1fFP", "DGxzXAgQVyPQptBi1E4pHReIbpuMx6e3EvqK5LIWFilYlOHPeY"))
                .debug(true)
                .build();
        Twitter.initialize(config);

        //Twitter.initialize(this);

    }

    public static synchronized MydApplication getInstance() {
        return mInstance;
    }


    public int getPixelValue(int dps) {
        int pixels = (int) (dps * scale + 0.5f);
        return pixels;
    }
}
