package com.example.cholid_ridwan.tesanalytics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class MainActivity extends AppCompatActivity {

    public static GoogleAnalytics analytics;
    private Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtain the shared Tracker instance.
        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();
        analytics = GoogleAnalytics.getInstance(this);
        analytics.setLocalDispatchPeriod(1800);
        mTracker = analytics.newTracker("UA-79611794-3");
        mTracker.enableExceptionReporting(true);
        mTracker.enableAdvertisingIdCollection(true);
        mTracker.enableAutoActivityTracking(true);

        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory("Action")
                .setAction("Share")
                .build());

        sendScreenImageName();
    }


    public void sendData(View view) {
        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory("Action")
                .setAction("Share")
                .build());

        sendScreenImageName();
    }

    private void sendScreenImageName() {

        // [START screen_view_hit]
        Log.i("TAG", "Setting screen name: " + "name");
        mTracker.setScreenName("Image~" + "name");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
        // [END screen_view_hit]
    }

}
