package com.mobilicos.howtotieknotspro;

import android.app.ActionBar.OnNavigationListener;
import android.app.ListActivity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import com.mobilicos.howtotieknots.C1295R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LessonsList extends ListActivity implements OnClickListener, OnNavigationListener {
    public static final String URI_DETAILS = "http://howset.com/apps-data/how-to-tie-knots/downloads/zip/";
    public ItemsListAdapter adapter;
    private int container_ident;
    private int container_type;
    /* access modifiers changed from: private */
    public List<Item> items = new ArrayList();

    public class ItemsListAdapter extends BaseAdapter {
        private Context myContext;

        public ItemsListAdapter(Context c) {
            this.myContext = c;
        }

        public int getCount() {
            return LessonsList.this.items.size();
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
                rowLayout = (LinearLayout) ((LayoutInflater) this.myContext.getSystemService("layout_inflater")).inflate(C1295R.layout.list_item, null);
            } else {
                rowLayout = (LinearLayout) convertView;
            }
            TextView firstLine = (TextView) rowLayout.findViewById(C1295R.C1297id.firstLine);
            TextView secondLine = (TextView) rowLayout.findViewById(C1295R.C1297id.secondLine);
            ImageView icon = (ImageView) rowLayout.findViewById(C1295R.C1297id.icon);
            ImageView button = (ImageView) rowLayout.findViewById(C1295R.C1297id.button);
            if (((Item) LessonsList.this.items.get(position)).is_loaded) {
                if (((Item) LessonsList.this.items.get(position)).is_base == 1) {
                    icon.setImageResource(LessonsList.this.getResources().getIdentifier("i_" + ((Item) LessonsList.this.items.get(position)).ident + "_icon", "drawable", this.myContext.getPackageName()));
                    icon.setAlpha(255);
                } else {
                    Bitmap bm = BitmapFactory.decodeFile(new File(Utils.getStoragePath(this.myContext), "cache_" + ((Item) LessonsList.this.items.get(position)).ident + "_icon.png").getAbsolutePath());
                    if (bm == null) {
                        bm = BitmapFactory.decodeFile(new File(Utils.getStoragePath(this.myContext), "i_" + ((Item) LessonsList.this.items.get(position)).ident + "_icon.png").getAbsolutePath());
                    }
                    icon.setImageBitmap(bm);
                    icon.setAlpha(255);
                }
                firstLine.setText(((Item) LessonsList.this.items.get(position)).name);
                if (((Item) LessonsList.this.items.get(position)).alternative_names.length() > 0) {
                    secondLine.setText(((Item) LessonsList.this.items.get(position)).alternative_names);
                } else {
                    secondLine.setText(((Item) LessonsList.this.items.get(position)).description);
                }
                button.setBackgroundResource(C1295R.C1296drawable.accept);
            } else {
                icon.setImageResource(LessonsList.this.getResources().getIdentifier("cache_" + ((Item) LessonsList.this.items.get(position)).ident + "_icon", "drawable", this.myContext.getPackageName()));
                icon.setAlpha(100);
                firstLine.setText(((Item) LessonsList.this.items.get(position)).name);
                if (((Item) LessonsList.this.items.get(position)).alternative_names.length() > 0) {
                    secondLine.setText(((Item) LessonsList.this.items.get(position)).alternative_names);
                } else {
                    secondLine.setText(((Item) LessonsList.this.items.get(position)).description);
                }
                button.setBackgroundResource(C1295R.C1296drawable.down);
            }
            return rowLayout;
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C1295R.layout.custom_list);
        Intent intent = getIntent();
        this.container_ident = intent.getIntExtra("container_ident", 0);
        this.container_type = intent.getIntExtra("container_type", 0);
        selectData();
        this.adapter = new ItemsListAdapter(this);
        setListAdapter(this.adapter);
    }

    public void selectData() {
        String mySql;
        int BASE_ITEMS = 0;
        this.items = new ArrayList();
        ArrayList<Integer> localModels = new ArrayList<>();
        DbOpenHelper dbOpenHelper = new DbOpenHelper(this);
        dbOpenHelper.createDataBase();
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        if (this.container_type == 1) {
            mySql = "SELECT li.ident, li.name, li.alternative_names, li.description, li.is_base, li.level FROM lesson_categories_items lci LEFT JOIN lesson_item li ON lci.item_ident=li.ident WHERE li.is_active=1 AND lci.category_ident=" + this.container_ident;
        } else {
            mySql = "SELECT li.ident, li.name, li.alternative_names, li.description, li.is_base, li.level FROM lesson_purposes_items lci LEFT JOIN lesson_item li ON lci.item_ident=li.ident WHERE li.is_active=1 AND lci.purpose_ident=" + this.container_ident;
        }
        Cursor cursor = db.rawQuery(mySql, null);
        while (cursor.moveToNext()) {
            Item item = new Item();
            item.ident = cursor.getInt(cursor.getColumnIndex("ident"));
            item.name = cursor.getString(cursor.getColumnIndex("name")).replace("&amp;", "&").replace("&#39;", "'");
            item.alternative_names = cursor.getString(cursor.getColumnIndex("alternative_names")).replace("&amp;", "&").replace("&#39;", "'");
            item.description = cursor.getString(cursor.getColumnIndex(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION)).replace("&amp;", "&").replace("&#39;", "'");
            item.is_base = cursor.getInt(cursor.getColumnIndex("is_base"));
            item.level = cursor.getString(cursor.getColumnIndex("level"));
            item.is_loaded = true;
            if (item.is_base == 1) {
                BASE_ITEMS++;
            }
            this.items.add(item);
            localModels.add(Integer.valueOf(item.ident));
        }
        cursor.close();
        if (this.container_type == 1) {
            Cursor cursor2 = db.rawQuery("SELECT ident, name, alternative_names, description, is_base, level FROM lesson_item_cache WHERE is_active=1 AND ident NOT IN (SELECT ident FROM lesson_item WHERE is_active=1 AND ident != 1000001) AND category_ident=" + this.container_ident + " ORDER BY id", null);
            while (cursor2.moveToNext()) {
                Item item2 = new Item();
                item2.ident = cursor2.getInt(cursor2.getColumnIndex("ident"));
                item2.name = cursor2.getString(cursor2.getColumnIndex("name")).replace("&amp;", "&").replace("&#39;", "'");
                item2.alternative_names = cursor2.getString(cursor2.getColumnIndex("alternative_names")).replace("&amp;", "&").replace("&#39;", "'");
                item2.description = cursor2.getString(cursor2.getColumnIndex(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION)).replace("&amp;", "&").replace("&#39;", "'");
                item2.is_base = 0;
                item2.level = cursor2.getString(cursor2.getColumnIndex("level"));
                if (!localModels.contains(Integer.valueOf(item2.ident))) {
                    this.items.add(item2);
                }
            }
            cursor2.close();
        }
        dbOpenHelper.close();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case C1295R.C1297id.next /*2131624099*/:
                startActivity(new Intent(this, FavoritesList.class));
                break;
            case C1295R.C1297id.favorites /*2131624100*/:
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

    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C1295R.C1298menu.mainmenu, menu);
        return true;
    }

    public void onClick(View v) {
        startActivity(new Intent(this, Download.class));
    }

    /* access modifiers changed from: protected */
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if (((Item) this.items.get(position)).is_loaded) {
            Intent myIntent = new Intent(v.getContext(), PreviewItem.class);
            myIntent.putExtra("ident", ((Item) this.items.get(position)).ident);
            startActivity(myIntent);
            return;
        }
        ((ImageView) l.findViewById(C1295R.C1297id.button)).setBackgroundResource(C1295R.C1296drawable.down);
        new DownloadItem(this, ((Item) this.items.get(position)).ident, "http://howset.com/apps-data/how-to-tie-knots/downloads/zip/").download();
    }
}
