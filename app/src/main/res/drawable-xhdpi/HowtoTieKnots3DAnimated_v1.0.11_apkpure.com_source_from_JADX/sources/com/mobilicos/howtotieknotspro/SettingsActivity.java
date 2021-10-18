package com.mobilicos.howtotieknotspro;

import android.app.Activity;
import android.os.Bundle;
import com.mobilicos.howtotieknots.C1295R;

public class SettingsActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C1295R.layout.settings);
        getFragmentManager().beginTransaction().replace(16908290, new SettingsFragment()).commit();
    }
}
