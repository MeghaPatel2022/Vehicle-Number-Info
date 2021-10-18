package com.mobilicos.howtotieknotspro;

import android.app.ActionBar.OnNavigationListener;
import android.app.ListActivity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.p000v4.app.NavUtils;
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
import com.google.android.gms.plus.PlusShare;
import com.mobilicos.howtotieknots.C1295R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FavoritesList extends ListActivity implements OnNavigationListener {
    private final String IMAGES_PATH_PART_ONE = "/data/";
    private final String IMAGES_PATH_PART_TWOO = "/images/";
    private ItemsListAdapter adapter;
    private int appOfTheDayUser;
    /* access modifiers changed from: private */
    public List<Item> items = new ArrayList();
    private Cursor myCursor;

    public class ItemsListAdapter extends BaseAdapter {
        private Context myContext;

        public ItemsListAdapter(Context c) {
            this.myContext = c;
        }

        public int getCount() {
            return FavoritesList.this.items.size();
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
            if (((Item) FavoritesList.this.items.get(position)).is_base == 1) {
                icon.setImageResource(FavoritesList.this.getResources().getIdentifier("i_" + ((Item) FavoritesList.this.items.get(position)).ident + "_icon", "drawable", this.myContext.getPackageName()));
            } else {
                Bitmap bm = BitmapFactory.decodeFile(new File(Utils.getStoragePath(this.myContext), "cache_" + ((Item) FavoritesList.this.items.get(position)).ident + "_icon.png").getAbsolutePath());
                if (bm == null) {
                    bm = BitmapFactory.decodeFile(new File(Utils.getStoragePath(this.myContext), "i_" + ((Item) FavoritesList.this.items.get(position)).ident + "_icon.png").getAbsolutePath());
                }
                icon.setImageBitmap(bm);
            }
            firstLine.setText(((Item) FavoritesList.this.items.get(position)).name);
            secondLine.setText(((Item) FavoritesList.this.items.get(position)).description);
            button.setBackgroundResource(C1295R.C1296drawable.accept);
            return rowLayout;
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        this.appOfTheDayUser = getSharedPreferences("AppOfTheDayUser", 0).getInt("AppOfTheDayUser", -1);
        DbOpenHelper dbOpenHelper = new DbOpenHelper(this);
        dbOpenHelper.createDataBase();
        this.myCursor = dbOpenHelper.getReadableDatabase().rawQuery("SELECT ident, name, description, is_base, level FROM lesson_item WHERE is_active=1 AND is_favorite=1", null);
        while (this.myCursor.moveToNext()) {
            Item item = new Item();
            item.ident = this.myCursor.getInt(this.myCursor.getColumnIndex("ident"));
            item.name = this.myCursor.getString(this.myCursor.getColumnIndex("name"));
            item.description = this.myCursor.getString(this.myCursor.getColumnIndex(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION));
            item.is_base = this.myCursor.getInt(this.myCursor.getColumnIndex("is_base"));
            item.level = this.myCursor.getString(this.myCursor.getColumnIndex("level"));
            this.items.add(item);
        }
        this.myCursor.close();
        dbOpenHelper.close();
        this.adapter = new ItemsListAdapter(this);
        setListAdapter(this.adapter);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                NavUtils.navigateUpFromSameTask(this);
                return true;
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
        getMenuInflater().inflate(C1295R.C1298menu.favorites_menu, menu);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent myIntent = new Intent(v.getContext(), PreviewItem.class);
        myIntent.putExtra("ident", ((Item) this.items.get(position)).ident);
        this.adapter.notifyDataSetInvalidated();
        startActivity(myIntent);
    }
}
