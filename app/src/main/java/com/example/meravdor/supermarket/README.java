package com.example.meravdor.supermarket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class README extends Activity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 10000;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_readme);

    }

    public void getStart(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}