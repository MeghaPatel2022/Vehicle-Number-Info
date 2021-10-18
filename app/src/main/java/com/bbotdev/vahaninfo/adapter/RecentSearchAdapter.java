package com.bbotdev.vahaninfo.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bbotdev.vahaninfo.R;
import com.bbotdev.vahaninfo.activity.OwnerDetailActivity;
import com.bbotdev.vahaninfo.customclass.PrefValue;
import com.bbotdev.vahaninfo.databinding.ListItemRecentSearchBinding;
import com.bbotdev.vahaninfo.objectdata.DataItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RecentSearchAdapter extends RecyclerView.Adapter<RecentSearchAdapter.MyViewHolder> {

    private final Activity mContext;
    public ArrayList<DataItem> data;
    Type type = new TypeToken<List<DataItem>>() {
    }.getType();


    public RecentSearchAdapter(Activity mContext, ArrayList<DataItem> data) {
        this.mContext = mContext;
        this.data = data;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemRecentSearchBinding recentSearchBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.list_item_recent_search,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(recentSearchBinding);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.recentSearchBinding.tvNo.setText(data.get(position).getRegNo());
        holder.recentSearchBinding.tvName.setText(data.get(position).getOwnerName());

        holder.recentSearchBinding.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder1 = new AlertDialog.Builder(mContext);
                builder1.setMessage("Do you want to remove this vehicle from recent search list?..");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Delete",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                ArrayList<DataItem> vehicleDatas = new ArrayList<>();
                                if (!PrefValue.getVehicleInfo(mContext).equals("")) {
                                    vehicleDatas = new Gson().fromJson(PrefValue.getVehicleInfo(mContext), type);
                                    DataItem vehicleData = new DataItem();
                                    vehicleData.setRegNo(data.get(position).getRegNo());
                                    for (int i = 0; i < vehicleDatas.size(); i++) {
                                        if (vehicleDatas.get(i).getRegNo().contains(vehicleData.getRegNo())) {
                                            vehicleDatas.remove(i);
                                            PrefValue.setVehicleInfo(mContext, new Gson().toJson(vehicleDatas));
                                            data.remove(position);
                                            notifyDataSetChanged();
                                        }
                                    }
                                }
                                dialog.cancel();
                            }
                        });

                builder1.setNegativeButton(
                        "Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });

        holder.recentSearchBinding.loutMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<String> arrayList = new ArrayList<>();
                try {

                    DataItem dataItem = data.get(position);
                    arrayList.add(dataItem.getOwnerName());
                    arrayList.add(dataItem.getRegNo());
                    arrayList.add(dataItem.getRegnDt());
                    arrayList.add(dataItem.getMaker());
                    arrayList.add(dataItem.getVhClass());
                    arrayList.add(dataItem.getFuelType());
                    arrayList.add(dataItem.getEngineNo());
                    arrayList.add(dataItem.getChasiNo());
                    arrayList.add(dataItem.getRto());

                    arrayList.add(mContext.getResources().getString(R.string.Note));
                    arrayList.add("---");
                    Intent intent = new Intent(mContext, OwnerDetailActivity.class);
                    intent.putStringArrayListExtra("value", arrayList);
                    mContext.startActivityForResult(intent, 1);
                } catch (Exception e) {

                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public String getTagString(String tag, String html) {
        String result = "";
        final Pattern ptrn = Pattern.compile("<" + tag + ">(.+?)</" + tag + ">");
        final Matcher mtchr = ptrn.matcher(html);
        while (mtchr.find()) {
            result = html.substring(mtchr.start(), mtchr.end()).replace("<" + tag + ">", "").replace("</" + tag + ">", "");

        }
        return result;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ListItemRecentSearchBinding recentSearchBinding;

        public MyViewHolder(ListItemRecentSearchBinding recentSearchBinding) {
            super(recentSearchBinding.getRoot());
            this.recentSearchBinding = recentSearchBinding;
        }
    }
}
