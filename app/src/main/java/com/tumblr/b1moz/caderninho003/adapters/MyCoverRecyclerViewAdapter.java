package com.tumblr.b1moz.caderninho003.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tumblr.b1moz.caderninho003.R;

public class MyCoverRecyclerViewAdapter extends RecyclerView.Adapter<MyCoverRecyclerViewAdapter.ViewHolder> {

    final int[] mDrawables;

    public MyCoverRecyclerViewAdapter(int[] mDrawables) {
        this.mDrawables = mDrawables;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cover, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.cover.setImageResource(mDrawables[i]);
    }

    @Override
    public int getItemCount() {
        return mDrawables.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView cover;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            if (itemView instanceof ImageView)
                cover = (ImageView) itemView;
        }
    }

}
