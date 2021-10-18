package com.bbotdev.vahaninfo.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bbotdev.vahaninfo.R;
import com.bbotdev.vahaninfo.databinding.ListItemCityheaderBinding;
import com.bbotdev.vahaninfo.databinding.ListItemCitylistBinding;
import com.bbotdev.vahaninfo.objectdata.FuelData;

import java.util.ArrayList;


public class CityListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 1;
    private static final int TYPE_ITEM = 2;
    private final Activity mContext;
    public ArrayList<FuelData> data;

    public CityListAdapter(Activity mContext, ArrayList<FuelData> data) {
        this.mContext = mContext;
        this.data = data;

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM) {
            ListItemCitylistBinding itemCitylistBinding =
                    DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.list_item_citylist,parent,false);
            return new MyViewHolder(itemCitylistBinding);
        } else if (viewType == TYPE_HEADER) {
            ListItemCityheaderBinding itemCityheaderBinding =
                    DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.list_item_cityheader,parent,false);
            return new HeaderViewHolder(itemCityheaderBinding);
        } else return null;


    }

    @Override
    public int getItemViewType(int position) {
        if (!data.get(position).isHeader()) {
            return TYPE_ITEM;
        } else {
            return TYPE_HEADER;

        }

    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof HeaderViewHolder) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            headerViewHolder.itemCityheaderBinding.setFuelData(data.get(position));
        } else if (holder instanceof MyViewHolder) {
            MyViewHolder itemViewHolder = (MyViewHolder) holder;
            itemViewHolder.itemCitylistBinding.setFuelData(data.get(position));

            itemViewHolder.itemCitylistBinding.tvCity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("city", data.get(position).getCityname());
                    intent.putExtra("code", data.get(position).getCitycode());
                    mContext.setResult(Activity.RESULT_OK, intent);
                    mContext.finish();

                }
            });
        }

    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setFilter(ArrayList<FuelData> FilteredDataList) {
        data = FilteredDataList;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ListItemCitylistBinding itemCitylistBinding;

        public MyViewHolder(ListItemCitylistBinding itemCitylistBinding) {
            super(itemCitylistBinding.getRoot());
            this.itemCitylistBinding = itemCitylistBinding;
        }
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {

        private final ListItemCityheaderBinding itemCityheaderBinding;

        public HeaderViewHolder(ListItemCityheaderBinding itemCityheaderBinding) {
            super(itemCityheaderBinding.getRoot());
            this.itemCityheaderBinding = itemCityheaderBinding;
        }
    }


}
