package com.quora.kumarsaurav.customnotification;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import static android.app.Notification.*;
import static android.view.View.OnClickListener;

public class NotifyMe extends Activity {

    final static int NOTIFY_SIMPLE = 1;
    final static int NOTIFY_CUSTOM = 2;
    Button mSimpleNotificationButton;
    Button mCustomNotificationButton;
    NotificationManager mNotificationManager;
    Builder mNotificationBuilder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify_me);
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mSimpleNotificationButton = (Button) findViewById(R.id.button_notify_simple);
        mCustomNotificationButton = (Button) findViewById(R.id.button_notify_custom);

        mSimpleNotificationButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mNotificationBuilder = new Builder(NotifyMe.this);
                mNotificationBuilder.setSmallIcon(R.drawable.ic_launcher);
                mNotificationBuilder.setContentTitle("Hello World");
                mNotificationBuilder.setContentInfo("Hey, Everyone");
                mNotificationManager.notify(NOTIFY_SIMPLE, mNotificationBuilder.build());
            }
        });

        mCustomNotificationButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification_follow);
                remoteViews.setTextViewText(R.id.tv_notification_follow, "Hello, World");
                remoteViews.setTextViewCompoundDrawablesRelative(R.id.tv_notification_follow, R.drawable.ic_launcher, 0, 0, 0);
                mNotificationBuilder = new Builder(NotifyMe.this);
                mNotificationBuilder.setSmallIcon(R.drawable.ic_launcher);
                mNotificationBuilder.setContent(remoteViews);
                mNotificationManager.notify(NOTIFY_CUSTOM, mNotificationBuilder.build());
            }
        });
    }

}
