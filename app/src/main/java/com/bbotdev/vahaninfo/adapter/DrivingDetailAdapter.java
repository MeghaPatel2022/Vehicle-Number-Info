package com.bbotdev.vahaninfo.adapter;

import android.app.Activity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bbotdev.vahaninfo.R;
import com.bbotdev.vahaninfo.databinding.ListItemOwnerBinding;
import com.bbotdev.vahaninfo.objectdata.LicenceData;

import java.util.ArrayList;


public class DrivingDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_FOOTER = 1;
    private static final int TYPE_ITEM = 2;
    private final Activity mContext;
    public ArrayList<LicenceData> data;


    public DrivingDetailAdapter(Activity mContext, ArrayList<LicenceData> data) {
        this.mContext = mContext;
        this.data = data;

    }

    @Override
    public int getItemViewType(int position) {
        return TYPE_ITEM;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM) {
            //Inflating recycle view item layout
            ListItemOwnerBinding ownerBinding =
                    DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.list_item_owner,parent,false);
            return new MyViewHolder(ownerBinding);
        } else if (viewType == TYPE_FOOTER) {
            //Inflating footer view
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_footer, parent, false);
            return new FooterViewHolder(itemView);
        } else return null;


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FooterViewHolder) {
            FooterViewHolder footerHolder = (FooterViewHolder) holder;
        } else if (holder instanceof MyViewHolder) {
            MyViewHolder itemViewHolder = (MyViewHolder) holder;
            itemViewHolder.ownerBinding.setKey(data.get(position).getKey());
            itemViewHolder.ownerBinding.setValue(String.valueOf(Html.fromHtml(data.get(position).getValue())));
        }
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class FooterViewHolder extends RecyclerView.ViewHolder {

        LinearLayout lout_main_footer;

        public FooterViewHolder(View itemView) {
            super(itemView);
            lout_main_footer = itemView.findViewById(R.id.lout_main_footer);
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ListItemOwnerBinding ownerBinding;

        public MyViewHolder(ListItemOwnerBinding ownerBinding) {
            super(ownerBinding.getRoot());
            this.ownerBinding = ownerBinding;
        }
    }

}
