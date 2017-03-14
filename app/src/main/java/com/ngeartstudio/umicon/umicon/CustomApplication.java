package com.ngeartstudio.umicon.umicon;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.firebase.client.Firebase;

/**
 * Created by fikneader on 3/8/2017.
 */

public class CustomApplication extends android.app.Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
    }
}
