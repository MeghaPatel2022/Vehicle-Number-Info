package com.mobilicos.howtotieknotspro;

import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.p000v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import com.mobilicos.howtotieknots.C1295R;
import java.io.File;

public class PreviewItem extends Activity implements OnClickListener, OnNavigationListener {
    private ImageButton begin;
    private DbOpenHelper dbOpenHelper;
    private ImageButton favoriteButton;
    private Item item;
    private ImageButton process;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C1295R.layout.leson_info);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        int ident = getIntent().getIntExtra("ident", 0);
        this.dbOpenHelper = new DbOpenHelper(this);
        this.dbOpenHelper.createDataBase();
        Cursor myCursor = this.dbOpenHelper.getReadableDatabase().rawQuery("SELECT name, description, steps_count, is_favorite, is_base FROM lesson_item WHERE is_active=1 AND ident=" + ident, null);
        myCursor.moveToFirst();
        this.item = new Item();
        this.item.ident = ident;
        this.item.name = myCursor.getString(myCursor.getColumnIndex("name")).replace("&amp;", "&").replace("&#39;", "'");
        this.item.description = myCursor.getString(myCursor.getColumnIndex(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION)).replace("&amp;", "&").replace("&#39;", "'");
        this.item.is_favorite = myCursor.getInt(myCursor.getColumnIndex("is_favorite"));
        this.item.is_base = myCursor.getInt(myCursor.getColumnIndex("is_base"));
        ImageView imgView = (ImageView) findViewById(C1295R.C1297id.img);
        TextView descriptionView = (TextView) findViewById(C1295R.C1297id.description);
        float dpWidth = (float) getResources().getDisplayMetrics().widthPixels;
        LayoutParams params = imgView.getLayoutParams();
        params.width = (int) dpWidth;
        params.height = (int) dpWidth;
        imgView.setLayoutParams(params);
        if (this.item.is_base == 1) {
            imgView.setImageResource(getResources().getIdentifier("i_" + this.item.ident + "_image", "drawable", getPackageName()));
        } else {
            imgView.setImageBitmap(BitmapFactory.decodeFile(new File(Utils.getStoragePath(this), "i_" + this.item.ident + "_image.png").getAbsolutePath()));
        }
        descriptionView.setText(this.item.name + "\n" + this.item.description);
        this.favoriteButton = (ImageButton) findViewById(C1295R.C1297id.favorite);
        this.favoriteButton.setOnClickListener(this);
        if (myCursor.getInt(this.item.is_favorite) == 0) {
            this.favoriteButton.setBackgroundResource(C1295R.C1296drawable.rounded_edges);
        } else {
            this.favoriteButton.setBackgroundResource(C1295R.C1296drawable.star_empty);
        }
        this.begin = (ImageButton) findViewById(C1295R.C1297id.begin);
        this.begin.setOnClickListener(this);
        this.process = (ImageButton) findViewById(C1295R.C1297id.process);
        this.process.setOnClickListener(this);
        myCursor.close();
        this.dbOpenHelper.close();
    }

    public boolean onOptionsItemSelected(MenuItem item2) {
        switch (item2.getItemId()) {
            case 16908332:
                NavUtils.navigateUpFromSameTask(this);
                return true;
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
        return super.onOptionsItemSelected(item2);
    }

    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C1295R.C1298menu.mainmenu, menu);
        return true;
    }

    public void onClick(View v) {
        if (v == this.begin) {
            Intent myIntent = new Intent(v.getContext(), Step.class);
            myIntent.putExtra("ident", this.item.ident);
            startActivity(myIntent);
        } else if (v == this.process) {
            startActivity(new Intent(v.getContext(), SettingsActivity.class));
        } else if (v == this.favoriteButton) {
            SQLiteDatabase db = this.dbOpenHelper.getReadableDatabase();
            Cursor myCursor = db.rawQuery("SELECT is_favorite FROM lesson_item WHERE is_active=1 AND ident=" + this.item.ident, null);
            myCursor.moveToFirst();
            if (myCursor.getInt(myCursor.getColumnIndex("is_favorite")) == 0) {
                ContentValues cv = new ContentValues();
                cv.put("is_favorite", Integer.valueOf(1));
                db.update("lesson_item", cv, "ident=" + this.item.ident, null);
                this.favoriteButton.setBackgroundResource(C1295R.C1296drawable.star_empty);
            } else {
                ContentValues cv2 = new ContentValues();
                cv2.put("is_favorite", Integer.valueOf(0));
                db.update("lesson_item", cv2, "ident=" + this.item.ident, null);
                this.favoriteButton.setBackgroundResource(C1295R.C1296drawable.rounded_edges);
            }
            myCursor.close();
            db.close();
        }
    }
}
