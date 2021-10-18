package com.mobilicos.howtotieknotspro;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import com.mobilicos.howtotieknots.C1295R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ApplicationsList extends ListActivity {
    /* access modifiers changed from: private */
    public List<HashMap<String, String>> apps = new ArrayList();

    public class ItemsListAdapter extends BaseAdapter {
        private Context myContext;

        public ItemsListAdapter(Context c) {
            this.myContext = c;
        }

        public int getCount() {
            return ApplicationsList.this.apps.size();
        }

        public Object getItem(int position) {
            return Integer.valueOf(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LinearLayout rowLayout;
            if (convertView == null) {
                rowLayout = (LinearLayout) ((LayoutInflater) this.myContext.getSystemService("layout_inflater")).inflate(C1295R.layout.application_item, null);
            } else {
                rowLayout = (LinearLayout) convertView;
            }
            HashMap<String, String> currentApp = (HashMap) ApplicationsList.this.apps.get(position);
            TextView firstLine = (TextView) rowLayout.findViewById(C1295R.C1297id.firstLine);
            TextView secondLine = (TextView) rowLayout.findViewById(C1295R.C1297id.secondLine);
            ImageView icon = (ImageView) rowLayout.findViewById(C1295R.C1297id.icon);
            int resId = ApplicationsList.this.getResources().getIdentifier((String) currentApp.get("icon"), "drawable", this.myContext.getPackageName());
            firstLine.setText((CharSequence) currentApp.get("name"));
            secondLine.setText((CharSequence) currentApp.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION));
            icon.setImageResource(resId);
            return rowLayout;
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(C1295R.layout.categories_custom_list);
        HashMap<String, String> app = new HashMap<>();
        app.put("name", "How to Make Origami Birds");
        app.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, "Step-by-step 3D animated instructions.");
        app.put("icon", "icon_12");
        app.put("uri", "market://details?id=com.mobilicos.howtomakeorigamibirds");
        this.apps.add(app);
        HashMap<String, String> app2 = new HashMap<>();
        app2.put("name", "How to Make Origami Animals");
        app2.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, "Step-by-step 3D animated instructions.");
        app2.put("icon", "icon_11");
        app2.put("uri", "market://details?id=com.mobilicos.howtomakeorigamianimals");
        this.apps.add(app2);
        HashMap<String, String> app3 = new HashMap<>();
        app3.put("name", "How to make Paper Airplanes");
        app3.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, "Step-by-step 3D animated instructions.");
        app3.put("icon", "icon_2");
        app3.put("uri", "market://details?id=com.mobilicos.howtomakepaperairplanes");
        this.apps.add(app3);
        HashMap<String, String> app4 = new HashMap<>();
        app4.put("name", "How to Tie Knots");
        app4.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, "Step-by-step 3D animated instructions.");
        app4.put("icon", "icon_3");
        app4.put("uri", "market://details?id=com.howset.howtotieknots");
        this.apps.add(app4);
        HashMap<String, String> app5 = new HashMap<>();
        app5.put("name", "How to Tie a Tie");
        app5.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, "Step-by-step 3D animated instructions.");
        app5.put("icon", "icon_10");
        app5.put("uri", "market://details?id=com.howset.howtotie");
        this.apps.add(app5);
        setListAdapter(new ItemsListAdapter(this));
    }

    /* access modifiers changed from: protected */
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String) ((HashMap) this.apps.get(position)).get("uri"))));
    }
}
