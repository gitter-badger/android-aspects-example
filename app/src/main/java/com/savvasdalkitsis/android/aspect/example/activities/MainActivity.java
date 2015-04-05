package com.savvasdalkitsis.android.aspect.example.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.savvasdalkitsis.android.aspect.example.R;
import com.savvasdalkitsis.android.aspect.example.pageview.MainPage;
import com.savvasdalkitsis.android.aspect.example.pageview.PageViewStrategy;
import com.savvasdalkitsis.android.aspect.example.pageview.WithPageView;
import com.shazam.android.aspects.base.activity.AspectActivity;

import java.util.UUID;

@WithPageView(page = MainPage.class, pageViewStrategy = PageViewStrategy.RESUME_PAUSE)
public class MainActivity extends AspectActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.start_new_activity).setOnClickListener(new LaunchNewActivityClickListener());
    }

    private class LaunchNewActivityClickListener implements View.OnClickListener {
        @Override
        public void onClick(@NonNull View v) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra(SecondActivity.PARAM_TRACK_ID, UUID.randomUUID().toString());
            startActivity(intent);
        }
    }
}
