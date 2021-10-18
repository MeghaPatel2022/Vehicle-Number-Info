package com.mobilicos.howtotieknots;

import android.app.Activity;
import android.os.Bundle;

public class SettingsActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C1295R.layout.settings);
        getFragmentManager().beginTransaction().replace(16908290, new SettingsFragment()).commit();
    }
}
