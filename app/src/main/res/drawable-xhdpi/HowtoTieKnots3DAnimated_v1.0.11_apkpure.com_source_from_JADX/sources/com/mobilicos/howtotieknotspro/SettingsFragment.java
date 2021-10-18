package com.mobilicos.howtotieknotspro;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import com.mobilicos.howtotieknots.C1295R;

public class SettingsFragment extends PreferenceFragment {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(C1295R.xml.preferences_new);
    }
}
