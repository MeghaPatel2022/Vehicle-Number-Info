package com.mobilicos.howtotieknotspro;

import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mobilicos.howtotieknots.C1295R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoriesListFragment extends ListFragment implements OnItemClickListener {
    public ItemsListAdapter adapter;
    private List<Integer> category_cache_items_count;
    /* access modifiers changed from: private */
    public List<Integer> idents;
    /* access modifiers changed from: private */
    public List<Integer> items_count;
    /* access modifiers changed from: private */
    public List<String> names;

    public class ItemsListAdapter extends BaseAdapter {
        private Context myContext;

        public ItemsListAdapter(Context c) {
            this.myContext = c;
        }

        public int getCount() {
            return CategoriesListFragment.this.names.size();
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
                rowLayout = (LinearLayout) ((LayoutInflater) this.myContext.getSystemService("layout_inflater")).inflate(C1295R.layout.categories_list, null);
            } else {
                rowLayout = (LinearLayout) convertView;
            }
            TextView firstLine = (TextView) rowLayout.findViewById(C1295R.C1297id.firstLine);
            TextView secondLine = (TextView) rowLayout.findViewById(C1295R.C1297id.secondLine);
            ((ImageView) rowLayout.findViewById(C1295R.C1297id.icon)).setImageResource(CategoriesListFragment.this.getResources().getIdentifier("cat_" + CategoriesListFragment.this.idents.get(position) + "_icon", "drawable", this.myContext.getPackageName()));
            firstLine.setText((CharSequence) CategoriesListFragment.this.names.get(position));
            secondLine.setText("" + CategoriesListFragment.this.items_count.get(position));
            return rowLayout;
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        selectData();
        this.adapter = new ItemsListAdapter(getActivity());
        setListAdapter(this.adapter);
        getListView().setOnItemClickListener(this);
    }

    public void selectData() {
        this.names = new ArrayList();
        this.items_count = new ArrayList();
        this.idents = new ArrayList();
        this.category_cache_items_count = new ArrayList();
        DbOpenHelper dbOpenHelper = new DbOpenHelper(getActivity());
        dbOpenHelper.createDataBase();
        Cursor myCursor = dbOpenHelper.getReadableDatabase().rawQuery("SELECT lc.ident, lc.name, lc.items_count, count(lic.id) as category_cache_items_count FROM lesson_category lc LEFT JOIN lesson_item_cache lic ON lc.ident=lic.category_ident WHERE lc.is_active=1 GROUP BY lc.ident", null);
        while (myCursor.moveToNext()) {
            if (myCursor.getInt(myCursor.getColumnIndex("lc.items_count")) > 0 || myCursor.getInt(myCursor.getColumnIndex("category_cache_items_count")) > 0) {
                this.idents.add(Integer.valueOf(myCursor.getInt(myCursor.getColumnIndex("lc.ident"))));
                this.names.add(myCursor.getString(myCursor.getColumnIndex("lc.name")));
                this.items_count.add(Integer.valueOf(myCursor.getInt(myCursor.getColumnIndex("lc.items_count"))));
                this.category_cache_items_count.add(Integer.valueOf(myCursor.getInt(myCursor.getColumnIndex("category_cache_items_count"))));
            }
        }
        myCursor.close();
        dbOpenHelper.close();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(C1295R.layout.categories_custom_list, container, false);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), LessonsList.class);
        intent.putExtra("category_ident", (Serializable) this.idents.get(position));
        startActivity(intent);
    }
}
