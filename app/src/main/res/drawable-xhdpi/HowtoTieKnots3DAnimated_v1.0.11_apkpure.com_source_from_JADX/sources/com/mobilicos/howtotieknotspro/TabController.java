package com.mobilicos.howtotieknotspro;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import com.mobilicos.howtotieknots.C1295R;

public class TabController extends TabActivity implements OnTabChangeListener {
    private TabHost tabHost;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(C1295R.layout.tab_controller);
        this.tabHost = getTabHost();
        this.tabHost.setOnTabChangedListener(this);
        TabSpec tabSpec = this.tabHost.newTabSpec("list");
        tabSpec.setIndicator("List", getResources().getDrawable(C1295R.C1296drawable.list));
        tabSpec.setContent(new Intent(this, CategoriesListFragment.class).addFlags(67108864));
        this.tabHost.addTab(tabSpec);
        TabSpec tabSpec2 = this.tabHost.newTabSpec("downloads");
        tabSpec2.setIndicator("Downloads", getResources().getDrawable(C1295R.C1296drawable.download));
        tabSpec2.setContent(new Intent(this, Download.class));
        this.tabHost.addTab(tabSpec2);
        TabSpec tabSpec3 = this.tabHost.newTabSpec("favorites_list");
        tabSpec3.setIndicator("Favorites", getResources().getDrawable(C1295R.C1296drawable.heart));
        tabSpec3.setContent(new Intent(this, FavoritesList.class).addFlags(67108864));
        this.tabHost.addTab(tabSpec3);
        TabSpec tabSpec4 = this.tabHost.newTabSpec("applications_list");
        tabSpec4.setIndicator("More Apps", getResources().getDrawable(C1295R.C1296drawable.gift));
        tabSpec4.setContent(new Intent(this, ApplicationsList.class));
        this.tabHost.addTab(tabSpec4);
        for (int i = 0; i < this.tabHost.getTabWidget().getChildCount(); i++) {
            this.tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#eba167"));
            TextView tv = (TextView) this.tabHost.getTabWidget().getChildAt(i).findViewById(16908310);
            tv.setTextColor(Color.parseColor("#ffffff"));
            tv.setTextSize(12.0f);
        }
        this.tabHost.getTabWidget().getChildAt(this.tabHost.getCurrentTab()).setBackgroundColor(Color.parseColor("#fc8300"));
        TextView tv2 = (TextView) this.tabHost.getTabWidget().getChildAt(this.tabHost.getCurrentTab()).findViewById(16908310);
        tv2.setTextColor(Color.parseColor("#ffffff"));
        tv2.setTextSize(12.0f);
    }

    public void onTabChanged(String tabId) {
        for (int i = 0; i < this.tabHost.getTabWidget().getChildCount(); i++) {
            this.tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#eba167"));
            TextView tv = (TextView) this.tabHost.getTabWidget().getChildAt(i).findViewById(16908310);
            tv.setTextColor(Color.parseColor("#ffffff"));
            tv.setTextSize(12.0f);
        }
        this.tabHost.getTabWidget().getChildAt(this.tabHost.getCurrentTab()).setBackgroundColor(Color.parseColor("#fc8300"));
        TextView tv2 = (TextView) this.tabHost.getTabWidget().getChildAt(this.tabHost.getCurrentTab()).findViewById(16908310);
        tv2.setTextColor(Color.parseColor("#ffffff"));
        tv2.setTextSize(12.0f);
    }
}
