package com.tumblr.b1moz.caderninho003.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tumblr.b1moz.caderninho003.R;
import com.tumblr.b1moz.caderninho003.domain.Category;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyCategoriesRecyclerViewAdapter extends RecyclerView.Adapter<MyCategoriesRecyclerViewAdapter.ViewHolder> {
    
    List<Category> mList;
    
    public MyCategoriesRecyclerViewAdapter(List<Category> mList) {
        this.mList = mList;
    }
    
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_category,
                viewGroup, false);
        return new ViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.icon.setImageResource(mList.get(i).getResourseID());
        viewHolder.name.setText(mList.get(i).getName());
        viewHolder.quantity.setText(String.valueOf(mList.get(i).getQuantity()));
    }
    
    @Override
    public int getItemCount() {
        return mList.size();
    }
    
    public class ViewHolder extends RecyclerView.ViewHolder {
    
        @BindView(R.id.item_category_icon_imageview) ImageView icon;
        @BindView(R.id.item_category_name_textview) TextView name;
        @BindView(R.id.item_category_quantity_textview) TextView quantity;
    
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        
    }
    
}
