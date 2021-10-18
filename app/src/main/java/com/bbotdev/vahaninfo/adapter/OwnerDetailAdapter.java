package com.bbotdev.vahaninfo.adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bbotdev.vahaninfo.R;
import com.bbotdev.vahaninfo.databinding.ListItemOwnerBinding;

import java.util.ArrayList;


public class OwnerDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_FOOTER = 1;
    private static final int TYPE_ITEM = 2;
    public static String[] key = {"Owner Name", "Registration No", "Registration Date", "Model Name", "Vehicle Class", "Fuel Type"
            , "Engine Number", "Chassis Number", "City", "Not showing current owner details?", ""};
    private final Activity mContext;
    public ArrayList<String> data;


    public OwnerDetailAdapter(Activity mContext, ArrayList<String> data) {
        this.mContext = mContext;
        this.data = data;

    }

    @Override
    public int getItemViewType(int position) {
        if (position == data.size() - 1) {
            return TYPE_FOOTER;
        }
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
            footerHolder.lout_main_footer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_SUBJECT, "FEEDBACK");
                    intent.putExtra(Intent.EXTRA_TEXT, "Vehicle number:" + data.get(1));
                    intent.setData(Uri.parse("mailto:" + mContext.getResources().getString(R.string.email))); // or just "mailto:" for blank
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.

                    try {
                        mContext.startActivity(intent);
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(mContext, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else if (holder instanceof MyViewHolder) {
            MyViewHolder itemViewHolder = (MyViewHolder) holder;

            itemViewHolder.ownerBinding.setKey(key[position]);
            itemViewHolder.ownerBinding.setValue(data.get(position));
            
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
