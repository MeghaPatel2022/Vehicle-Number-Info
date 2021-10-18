package com.bbotdev.vahaninfo.listadapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bbotdev.vahaninfo.R;
import com.bbotdev.vahaninfo.customclass.ClcikEventCallBack;


public class NavListAdapter extends RecyclerView.Adapter<NavListAdapter.MyViewHolder> {

    private final Activity mContext;
    public int[] data;
    public String[] Title;
    ClcikEventCallBack clcikEventCallBack;


    public NavListAdapter(Activity mContext, int[] data, String[] Title, ClcikEventCallBack clcikEventCallBack) {
        this.mContext = mContext;
        this.data = data;
        this.Title = Title;
        this.clcikEventCallBack = clcikEventCallBack;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_nav, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tvTitle.setText(Title[position]);
        holder.ivImage.setBackgroundResource(data[position]);

        holder.lout_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (clcikEventCallBack != null) {
                    clcikEventCallBack.onItemClick(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivImage;
        private final LinearLayout lout_main;
        TextView tvTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            lout_main = itemView.findViewById(R.id.lout_main);
        }
    }
}
