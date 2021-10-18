package com.mobilicos.howtotieknots;

import android.app.ActionBar.OnNavigationListener;
import android.app.ListActivity;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class CategoriesList extends ListActivity implements OnNavigationListener {
    public ItemsListAdapter adapter;
    /* access modifiers changed from: private */
    public ArrayList<Container> items = new ArrayList<>();

    public class ItemsListAdapter extends BaseAdapter {
        private Context myContext;

        public ItemsListAdapter(Context c) {
            this.myContext = c;
        }

        public int getCount() {
            return CategoriesList.this.items.size();
        }

        public Object getItem(int position) {
            return Integer.valueOf(position);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LinearLayout rowLayout;
            int resId;
            if (convertView == null) {
                rowLayout = (LinearLayout) ((LayoutInflater) this.myContext.getSystemService("layout_inflater")).inflate(C1295R.layout.categories_list, null);
            } else {
                rowLayout = (LinearLayout) convertView;
            }
            TextView firstLine = (TextView) rowLayout.findViewById(C1295R.C1297id.firstLine);
            TextView secondLine = (TextView) rowLayout.findViewById(C1295R.C1297id.secondLine);
            ImageView icon = (ImageView) rowLayout.findViewById(C1295R.C1297id.icon);
            if (((Container) CategoriesList.this.items.get(position)).type == 1) {
                resId = CategoriesList.this.getResources().getIdentifier("cat_" + ((Container) CategoriesList.this.items.get(position)).ident + "_icon", "drawable", this.myContext.getPackageName());
            } else {
                resId = CategoriesList.this.getResources().getIdentifier("pur_" + ((Container) CategoriesList.this.items.get(position)).ident + "_icon", "drawable", this.myContext.getPackageName());
            }
            icon.setImageResource(resId);
            firstLine.setText(((Container) CategoriesList.this.items.get(position)).name);
            secondLine.setText("" + ((Container) CategoriesList.this.items.get(position)).items_count);
            return rowLayout;
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C1295R.layout.custom_list);
        updateContainers();
        selectData();
        this.adapter = new ItemsListAdapter(this);
        setListAdapter(this.adapter);
    }

    private boolean updateContainers() {
        SharedPreferences prefs = getSharedPreferences("Settings", 0);
        if (!prefs.getBoolean("updatedContainers", false)) {
            try {
                DbOpenHelper dbOpenHelper = new DbOpenHelper(this);
                dbOpenHelper.createDataBase();
                SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
                JSONObject mainObject = Utils.parseJSONAssetFile(getAssets().open("containers.json"));
                Iterator keys = mainObject.keys();
                db.execSQL("DELETE FROM lesson_categories_items");
                db.execSQL("DELETE FROM lesson_purposes_items");
                Cursor cursor = db.rawQuery("SELECT ident FROM lesson_item WHERE is_active=1", null);
                while (cursor.moveToNext()) {
                    String ident = cursor.getString(cursor.getColumnIndex("ident"));
                    if (mainObject.get(ident) instanceof JSONObject) {
                        JSONObject currentObject = mainObject.getJSONObject(ident);
                        JSONArray categories = currentObject.getJSONArray("categories");
                        JSONArray purposes = currentObject.getJSONArray("purposes");
                        if (categories.length() > 0) {
                            for (int j = 0; j < categories.length(); j++) {
                                ContentValues cv = new ContentValues();
                                cv.put("category_ident", Integer.valueOf(categories.getInt(j)));
                                cv.put("item_ident", ident);
                                db.insert("lesson_categories_items", null, cv);
                            }
                        }
                        if (purposes.length() > 0) {
                            for (int j2 = 0; j2 < purposes.length(); j2++) {
                                ContentValues cv2 = new ContentValues();
                                cv2.put("purpose_ident", Integer.valueOf(purposes.getInt(j2)));
                                cv2.put("item_ident", ident);
                                db.insert("lesson_purposes_items", null, cv2);
                            }
                        }
                    }
                }
                cursor.close();
                dbOpenHelper.close();
                Editor editor = prefs.edit();
                editor.putBoolean("updatedContainers", true);
                editor.apply();
            } catch (Exception e) {
                Log.e("CONTAINER ERROR", e.getMessage());
                return false;
            }
        }
        return true;
    }

    public void selectData() {
        this.items = new ArrayList<>();
        DbOpenHelper dbOpenHelper = new DbOpenHelper(this);
        dbOpenHelper.createDataBase();
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        Cursor myCursor = db.rawQuery("SELECT lc.ident ident, lc.name name, count(lci.item_ident) category_items_count FROM lesson_category lc LEFT JOIN lesson_categories_items lci ON lc.ident=lci.category_ident WHERE lci.item_ident IN (SELECT ident FROM lesson_item WHERE is_active=1) GROUP BY lc.id", null);
        while (myCursor.moveToNext()) {
            Container container = new Container();
            container.ident = myCursor.getInt(myCursor.getColumnIndex("ident"));
            container.name = myCursor.getString(myCursor.getColumnIndex("name"));
            container.items_count = myCursor.getInt(myCursor.getColumnIndex("category_items_count"));
            container.type = 1;
            this.items.add(container);
        }
        Cursor myCursor2 = db.rawQuery("SELECT lc.ident ident, lc.name name, count(lci.item_ident) purpose_items_count FROM lesson_purpose lc LEFT JOIN lesson_purposes_items lci ON lc.ident=lci.purpose_ident WHERE lci.item_ident IN (SELECT ident FROM lesson_item WHERE is_active=1) GROUP BY lc.id", null);
        while (myCursor2.moveToNext()) {
            Container container2 = new Container();
            container2.ident = myCursor2.getInt(myCursor2.getColumnIndex("ident"));
            container2.name = myCursor2.getString(myCursor2.getColumnIndex("name"));
            container2.items_count = myCursor2.getInt(myCursor2.getColumnIndex("purpose_items_count"));
            container2.type = 2;
            this.items.add(container2);
        }
        myCursor2.close();
        dbOpenHelper.close();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case C1295R.C1297id.favorites /*2131624100*/:
                startActivity(new Intent(this, FavoritesList.class));
                break;
            case C1295R.C1297id.more_apps /*2131624101*/:
                try {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://developer?id=Mobilicos")));
                    break;
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/developer?id=Mobilicos")));
                    break;
                }
        }
        return super.onOptionsItemSelected(item);
    }

    /* access modifiers changed from: protected */
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(this, LessonsList.class);
        intent.putExtra("container_ident", ((Container) this.items.get(position)).ident);
        intent.putExtra("container_type", ((Container) this.items.get(position)).type);
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.adapter != null) {
            selectData();
            this.adapter.notifyDataSetChanged();
        }
    }

    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C1295R.C1298menu.mainmenu, menu);
        return true;
    }
}
