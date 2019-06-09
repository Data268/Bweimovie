package com.bawei.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.bweicinema.R;
import com.bawei.user.HotUser;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * 佀常勇
 *
 * @Data:2019/6/9 20:42
 * 描述：
 */
public class HotAdapter extends RecyclerView.Adapter<HotAdapter.ViewHolder> {
    private Context context;

    public HotAdapter(Context context) {
        this.context = context;
    }
    List<HotUser> list=new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.hot_item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.hottext.setText(list.get(position).name);
        Glide.with(context).load(list.get(position).imageUrl).into(holder.hotimage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void add(List<HotUser> listData) {
        if (listData != null) {
            list.addAll(listData);
        }
    }

    public void clear() {
        list.clear();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView hotimage;
        TextView hottext;
        public ViewHolder(View itemView) {
            super(itemView);
            hotimage=itemView.findViewById(R.id.hotimage);
            hottext=itemView.findViewById(R.id.hottext);
        }
    }
}
